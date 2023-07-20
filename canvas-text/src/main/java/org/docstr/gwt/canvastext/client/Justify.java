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

import static elemental2.dom.DomGlobal.console;

import elemental2.dom.CanvasRenderingContext2D;

/**
 * This function will insert spaces between words in a line in order to
 * raise the line width to the box width. The spaces are evenly spread
 * in the line, and extra spaces (if any) are inserted between the first words.
 * <p>
 * It returns the justified text.
 *
 * @author delight.wjk@gmail.com
 */
public class Justify {

  private Justify() {
  }

  public static String justifyLine(
      CanvasRenderingContext2D ctx, String line, double spaceWidth,
      String spaceChar, double width) {

    String text = line.trim();
    String[] words = text.split("\\s+");
    int numOfWords = words.length - 1;

    if (numOfWords == 0) {
      return text;
    }

    // Width without spaces
    double lineWidth = ctx.measureText(String.join("", words)).width;

    double numOfSpacesToInsert = (width - lineWidth) / spaceWidth;
    int spacesPerWord = (int) Math.floor(numOfSpacesToInsert / numOfWords);

    if (numOfSpacesToInsert < 1) {
      return text;
    }

    console.log("numOfSpacesToInsert", numOfSpacesToInsert, numOfWords);

    String spaces = repeat(spaceChar, spacesPerWord);

    // Return justified text
    return String.join(spaces, words);
  }

  private static String repeat(String spaceChar, int spacesPerWord) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < spacesPerWord; i++) {
      sb.append(spaceChar);
    }
    return sb.toString();
  }
}
