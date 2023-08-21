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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author delight.wjk@gmail.com
 */
@JsType(name = "CanvasTextConfig", namespace = JsPackage.GLOBAL)
public class CanvasTextConfig {

  public double width;
  public double height;
  public double x;
  public double y;
  public boolean debug;
  /**
   * Horizontal alignment of the text. Possible values: left, center, right.
   */
  public String align;
  /**
   * Vertical alignment of the text. Possible values: top, middle, bottom.
   */
  public String vAlign;
  public double fontSize;
  public String fontWeight;
  public String fontStyle;
  public String fontVariant;
  public String font;
  public Double lineHeight;
  public boolean justify;
}
