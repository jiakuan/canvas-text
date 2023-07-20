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

import elemental2.dom.CanvasRenderingContext2D;
import jsinterop.base.Js;

/**
 * @author delight.wjk@gmail.com
 */
public class TextHeight {

  private TextHeight() {
  }

  public static double getTextHeight(
      CanvasRenderingContext2D ctx, String text, String style) {
    String previousTextBaseline = ctx.textBaseline;
    String previousFont = ctx.font;

    ctx.textBaseline = "bottom";
    ctx.font = style;

    TextMetrics2 metrics = Js.cast(ctx.measureText(text));
    double height = metrics.actualBoundingBoxAscent;

    // Reset baseline
    ctx.textBaseline = previousTextBaseline;
    ctx.font = previousFont;

    return height;
  }
}
