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

import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import elemental2.dom.BaseRenderingContext2D.StrokeStyleUnionType;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.TextMetrics;
import java.util.ArrayList;
import java.util.List;

/**
 * Java implementation of drawing canvas text inspired by a TypeScript library
 * <a href="https://canvas-txt.geongeorge.com/">Canvas-Txt</a>.
 *
 * @author delight.wjk@gmail.com
 */
public class CanvasText {

  // Hair space character for precise justification
  private static final char SPACE = '\u200A';

  private boolean debug = false;
  private String align = "center";
  private String vAlign = "middle";
  private int fontSize = 14;
  private String fontWeight = "";
  private String fontStyle = "";
  private String fontVariant = "";
  private String font = "Arial";
  private Double lineHeight = null;
  private boolean justify = false;

  /**
   * Draw text inside a rectangle.
   *
   * @param context
   * @param text
   * @param x
   * @param y
   * @param width
   * @param height
   * @return The height of multi-line text box
   */
  public double drawText(
      CanvasRenderingContext2D context, String text, double x,
      double y, double width, double height
  ) {
    if (width <= 0 || height <= 0 || this.fontSize <= 0) {
      // width or height or font size cannot be 0
      return 0;
    }

    // End points
    double xEnd = x + width;
    double yEnd = y + height;

    StringBuilder styleBuilder = new StringBuilder().append(fontStyle)
        .append(" ").append(fontVariant)
        .append(" ").append(fontWeight)
        .append(" ").append(fontSize).append("px")
        .append(" ").append(font);
    String style = styleBuilder.toString();
    context.font = style;

    double txtY = y + height / 2 + this.fontSize / 2;

    double textAnchor;

    if ("right".equalsIgnoreCase(this.align)) {
      textAnchor = xEnd;
      context.textAlign = "right";
    } else if ("left".equalsIgnoreCase(this.align)) {
      textAnchor = x;
      context.textAlign = "left";
    } else {
      textAnchor = x + width / 2;
      context.textAlign = "center";
    }

    // added one-line only auto linebreak feature
    List<String> textArray = new ArrayList<>();
    String[] tempTextArray = text.split("\n");

    double spaceWidth =
        this.justify ? context.measureText(SPACE + "").width : 0;
    for (String txt : tempTextArray) {
      double textWidth = context.measureText(txt).width;
      if (textWidth <= width) {
        textArray.add(txt);
      } else {
        String tempText = txt;
        double lineLen = width;
        int textLen;
        double textPixLen;
        String textToPrint;
        textWidth = context.measureText(tempText).width;
        while (textWidth > lineLen) {
          textLen = 0;
          textPixLen = 0;
          textToPrint = "";
          while (textPixLen < lineLen) {
            textLen++;
            textToPrint = tempText.substring(0, textLen);
            textPixLen = context.measureText(textToPrint).width;
          }
          // Remove last character that was out of the box
          textLen--;
          textToPrint = textToPrint.substring(0, textLen);
          // if statement ensures a new line only happens at a space, and not amidst a word
          int backup = textLen;
          if (!" ".equals(tempText.substring(textLen, textLen + 1))) {
            while (!" ".equals(tempText.substring(textLen, textLen + 1))
                && textLen != 0) {
              textLen--;
            }
            if (textLen == 0) {
              textLen = backup;
            }
            textToPrint = tempText.substring(0, textLen);
          }

          textToPrint = this.justify
              ? this.justifyLine(context, textToPrint, spaceWidth, SPACE, width)
              : textToPrint;

          tempText = tempText.substring(textLen);
          textWidth = context.measureText(tempText).width;
          textArray.add(textToPrint);
        }
        if (textWidth > 0) {
          textArray.add(tempText);
        }
      }
      // end foreach tempTextArray
    }
    double charHeight = this.lineHeight != null
        ? this.lineHeight
        // close approximation of height with width
        : this.getTextHeight(context, text, style);
    double vHeight = charHeight * (textArray.size() - 1);
    double negOffset = vHeight / 2;

    double debugY = y;
    // Vertical Align
    if ("top".equalsIgnoreCase(this.vAlign)) {
      txtY = y + this.fontSize;
    } else if ("bottom".equalsIgnoreCase(this.vAlign)) {
      txtY = yEnd - vHeight;
      debugY = yEnd;
    } else {
      //defaults to center
      debugY = y + height / 2;
      txtY -= negOffset;
    }
    // print all lines of text
    for (String txtLine : textArray) {
      txtLine = txtLine.trim();
      context.fillText(txtLine, textAnchor, txtY);
      txtY += charHeight;
    }

    if (this.debug) {
      // Text box
      context.lineWidth = 3;
      context.strokeStyle = StrokeStyleUnionType.of("#00909e");
      context.strokeRect(x, y, width, height);

      context.lineWidth = 2;

      // Horizontal Center
      context.strokeStyle = StrokeStyleUnionType.of("#f6d743");
      context.beginPath();
      context.moveTo(textAnchor, y);
      context.lineTo(textAnchor, yEnd);
      context.stroke();

      // Vertical Center
      context.strokeStyle = StrokeStyleUnionType.of("#ff6363");
      context.beginPath();
      context.moveTo(x, debugY);
      context.lineTo(xEnd, debugY);
      context.stroke();
    }

    double textHeight = vHeight + charHeight;
    return textHeight;
  }

  /**
   * Calculate Height of the font
   */
  private double getTextHeight(
      CanvasRenderingContext2D context, String text, String style) {
    String previousTextBaseline = context.textBaseline;
    String previousFont = context.font;

    context.textBaseline = "bottom";
    context.font = style;

    double height = getActualBoundingBoxAscent(context.measureText(text));

    // Reset baseline
    context.textBaseline = previousTextBaseline;
    context.font = previousFont;

    return height;
  }

  public static native double getActualBoundingBoxAscent(
      TextMetrics textMetrics)  /*-{
    return textMetrics.actualBoundingBoxAscent;
  }-*/;

  /**
   * This function will insert spaces between words in a line in order
   * to raise the line width to the box width.
   *
   * The spaces are evenly spread in the line, and extra spaces (if any)
   * are inserted between the first words.
   *
   * It returns the justified text.
   */
  private String justifyLine(
      CanvasRenderingContext2D context, String line,
      double spaceWidth, char spaceChar, double width
  ) {
    String text = line.trim();

    double lineWidth = context.measureText(text).width;

    int nbSpaces = text.split("\\s+").length - 1;
    int nbSpacesToInsert = (int) Math.floor((width - lineWidth) / spaceWidth);

    if (nbSpaces <= 0 || nbSpacesToInsert <= 0) {
      return text;
    }

    // Insert at least nbSpacesMinimum and we add extraSpaces to the first words
    int nbSpacesMinimum = (int) Math.floor(nbSpacesToInsert * 1.0 / nbSpaces);
    int extraSpaces = nbSpacesToInsert - nbSpaces * nbSpacesMinimum;

    StringBuilder spacesBuilder = new StringBuilder();
    for (int i = 0; i < nbSpacesMinimum; i++) {
      spacesBuilder.append(spaceChar);
    }
    String spaces = spacesBuilder.toString();

    StringBuilder justifiedText = new StringBuilder();
    RegExp regExp = RegExp.compile("\\s+", "g");
    int lastIndex = 0;
    for (MatchResult matcher = regExp.exec(text); matcher != null;
        matcher = regExp.exec(text)) {
      String match = matcher.getGroup(0);
      String allSpaces = extraSpaces > 0 ? spaces + spaceChar : spaces;
      String newSpaces = match + allSpaces;

      int lastIndex2 = regExp.getLastIndex();
      justifiedText.append(text, lastIndex, lastIndex2 - match.length());
      justifiedText.append(newSpaces);

      extraSpaces--;
      lastIndex = lastIndex2;
    }

    return justifiedText.toString();
  }

  public boolean isDebug() {
    return debug;
  }

  public CanvasText setDebug(boolean debug) {
    this.debug = debug;
    return this;
  }

  public String getAlign() {
    return align;
  }

  public CanvasText setAlign(String align) {
    this.align = align;
    return this;
  }

  public String getvAlign() {
    return vAlign;
  }

  public CanvasText setvAlign(String vAlign) {
    this.vAlign = vAlign;
    return this;
  }

  public int getFontSize() {
    return fontSize;
  }

  public CanvasText setFontSize(int fontSize) {
    this.fontSize = fontSize;
    return this;
  }

  public String getFontWeight() {
    return fontWeight;
  }

  public CanvasText setFontWeight(String fontWeight) {
    this.fontWeight = fontWeight;
    return this;
  }

  public String getFontStyle() {
    return fontStyle;
  }

  public CanvasText setFontStyle(String fontStyle) {
    this.fontStyle = fontStyle;
    return this;
  }

  public String getFontVariant() {
    return fontVariant;
  }

  public CanvasText setFontVariant(String fontVariant) {
    this.fontVariant = fontVariant;
    return this;
  }

  public String getFont() {
    return font;
  }

  public CanvasText setFont(String font) {
    this.font = font;
    return this;
  }

  public Double getLineHeight() {
    return lineHeight;
  }

  public CanvasText setLineHeight(Double lineHeight) {
    this.lineHeight = lineHeight;
    return this;
  }

  public boolean isJustify() {
    return justify;
  }

  public CanvasText setJustify(boolean justify) {
    this.justify = justify;
    return this;
  }
}
