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

import static org.docstr.gwt.canvastext.client.Justify.justifyLine;

import elemental2.dom.CanvasRenderingContext2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author delight.wjk@gmail.com
 */
public class SplitText {

  // Hair space character for precise justification
  private static final String SPACE = "\u200A";

  private SplitText() {
  }

  public static List<String> splitText(
      CanvasRenderingContext2D ctx, String text, boolean justify,
      double width) {
    final Map<String, Double> textMap = new HashMap<>();

    List<String> textArray = new ArrayList<>();
    String[] initialTextArray = text.split("\n");

    double spaceWidth = justify ? measureText(ctx, textMap, SPACE) : 0;

    int index = 0;
    int averageSplitPoint = 0;
    for (String singleLine : initialTextArray) {
      double textWidth = measureText(ctx, textMap, singleLine);
      int singleLineLength = singleLine.length();

      if (textWidth <= width) {
        textArray.add(singleLine);
        continue;
      }

      String tempLine = singleLine;

      int splitPoint = 0;
      double splitPointWidth = 0;
      String textToPrint = "";

      while (textWidth > width) {
        index++;
        splitPoint = averageSplitPoint;
        splitPointWidth =
            splitPoint == 0 ? 0
                : measureText(ctx, textMap, tempLine.substring(0, splitPoint));

        // if (splitPointWidth === width) Nailed
        if (splitPointWidth < width) {
          while (splitPointWidth < width && splitPoint < singleLineLength) {
            splitPoint++;
            splitPointWidth = measureText(ctx, textMap,
                tempLine.substring(0, splitPoint));
            if (splitPoint == singleLineLength) {
              break;
            }
          }
        } else if (splitPointWidth > width) {
          while (splitPointWidth > width) {
            splitPoint = Math.max(1, splitPoint - 1);
            splitPointWidth = measureText(ctx, textMap,
                tempLine.substring(0, splitPoint));
            if (splitPoint == 0 || splitPoint == 1) {
              break;
            }
          }
        }

        averageSplitPoint = Math.round(
            averageSplitPoint + (splitPoint - averageSplitPoint) / index);

        // Remove last character that was out of the box
        splitPoint--;

        // Ensures a new line only happens at a space, and not amidst a word
        if (splitPoint > 0) {
          int tempSplitPoint = splitPoint;
          if (!" ".equals(
              tempLine.substring(tempSplitPoint, tempSplitPoint + 1))) {
            while (!" ".equals(
                tempLine.substring(tempSplitPoint, tempSplitPoint + 1)) &&
                tempSplitPoint >= 0) {
              tempSplitPoint--;
            }
            if (tempSplitPoint > 0) {
              splitPoint = tempSplitPoint;
            }
          }
        }

        if (splitPoint == 0) {
          splitPoint = 1;
        }

        // Finally sets text to print
        textToPrint = tempLine.substring(0, splitPoint);

        textToPrint = justify
            ? justifyLine(ctx, textToPrint, spaceWidth, SPACE, width)
            : textToPrint;
        textArray.add(textToPrint);
        tempLine = tempLine.substring(splitPoint);
        textWidth = measureText(ctx, textMap, tempLine);
      }

      if (textWidth > 0) {
        textToPrint = justify
            ? justifyLine(ctx, tempLine, spaceWidth, SPACE, width)
            : tempLine;
        textArray.add(textToPrint);
      }
    }
    return textArray;
  }

  private static double measureText(
      CanvasRenderingContext2D ctx, Map<String, Double> textMap, String text) {
    Double width = textMap.get(text);
    if (width != null) {
      return width;
    }

    width = ctx.measureText(text).width;
    textMap.put(text, width);
    return width;
  }
}
