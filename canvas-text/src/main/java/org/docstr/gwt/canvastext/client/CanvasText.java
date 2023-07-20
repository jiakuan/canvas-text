/*
 * Copyright (c) 2023 Document Node Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.docstr.gwt.canvastext.client;

import static org.docstr.gwt.canvastext.client.SplitText.splitText;
import static org.docstr.gwt.canvastext.client.TextHeight.getTextHeight;

import elemental2.dom.BaseRenderingContext2D.StrokeStyleUnionType;
import elemental2.dom.CanvasRenderingContext2D;
import java.util.List;

/**
 * Java implementation of drawing canvas text inspired by a TypeScript library
 * <a href="https://canvas-txt.geongeorge.com/">Canvas-Txt</a>.
 *
 * @author delight.wjk@gmail.com
 */
public class CanvasText {

  /**
   * @return a configuration with default styles
   */
  public static CanvasTextConfig defaultConfig() {
    CanvasTextConfig config = new CanvasTextConfig();
    config.debug = false;
    config.align = "center";
    config.vAlign = "middle";
    config.fontSize = 14;
    config.fontWeight = "";
    config.fontStyle = "";
    config.fontVariant = "";
    config.font = "Arial";
    config.lineHeight = null;
    config.justify = false;
    return config;
  }

  /**
   * Draw text inside a rectangle.
   *
   * @param ctx The canvas context
   * @param text The text to draw
   * @param cfg The configuration
   * @return The height of multi-line text box
   */
  public static double drawText(
      CanvasRenderingContext2D ctx, String text, CanvasTextConfig cfg) {

    if (cfg.width <= 0 || cfg.height <= 0 || cfg.fontSize <= 0) {
      // width or height or font size cannot be 0
      return 0;
    }

    // End points
    double xEnd = cfg.x + cfg.width;
    double yEnd = cfg.y + cfg.height;

    StringBuilder sb = new StringBuilder()
        .append(cfg.fontStyle)
        .append(" ").append(cfg.fontVariant)
        .append(" ").append(cfg.fontWeight)
        .append(" ").append(cfg.fontSize).append("px")
        .append(" ").append(cfg.font);
    String style = sb.toString();
    ctx.font = style;

    double txtY = cfg.y + cfg.height / 2 + cfg.fontSize / 2;

    double textAnchor;

    if ("right".equalsIgnoreCase(cfg.align)) {
      textAnchor = xEnd;
      ctx.textAlign = "right";
    } else if ("left".equalsIgnoreCase(cfg.align)) {
      textAnchor = cfg.x;
      ctx.textAlign = "left";
    } else {
      textAnchor = cfg.x + cfg.width / 2;
      ctx.textAlign = "center";
    }

    List<String> textArray = splitText(ctx, text, cfg.justify, cfg.width);
    double charHeight = cfg.lineHeight != null
        ? cfg.lineHeight : getTextHeight(ctx, "M", style);
    double vHeight = charHeight * (textArray.size() - 1);
    double negOffset = vHeight / 2;

    double debugY = cfg.y;
    // Vertical Align
    if ("top".equals(cfg.vAlign)) {
      ctx.textBaseline = "top";
      txtY = cfg.y;
    } else if ("bottom".equals(cfg.vAlign)) {
      ctx.textBaseline = "bottom";
      txtY = yEnd - vHeight;
      debugY = yEnd;
    } else {
      // defaults to center
      ctx.textBaseline = "bottom";
      debugY = cfg.y + cfg.height / 2;
      txtY -= negOffset;
    }
    // print all lines of text
    for (String textLine : textArray) {
      ctx.fillText(textLine.trim(), textAnchor, txtY);
      txtY += charHeight;
    }

    if (cfg.debug) {
      String debugColor = "#0C8CE9";

      // Text box
      ctx.lineWidth = 1;
      ctx.strokeStyle = StrokeStyleUnionType.of(debugColor);
      ctx.strokeRect(cfg.x, cfg.y, cfg.width, cfg.height);

      ctx.lineWidth = 1;
      // Horizontal Center
      ctx.strokeStyle = StrokeStyleUnionType.of(debugColor);
      ctx.beginPath();
      ctx.moveTo(textAnchor, cfg.y);
      ctx.lineTo(textAnchor, yEnd);
      ctx.stroke();
      // Vertical Center
      ctx.strokeStyle = StrokeStyleUnionType.of(debugColor);
      ctx.beginPath();
      ctx.moveTo(cfg.x, debugY);
      ctx.lineTo(xEnd, debugY);
      ctx.stroke();
    }
    // Return the height of the text box
    return vHeight + charHeight;
  }
}
