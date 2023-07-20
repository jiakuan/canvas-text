package org.docstr.gwt.canvastext.client;

import elemental2.dom.TextMetrics;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, name = "TextMetrics", namespace = JsPackage.GLOBAL)
public class TextMetrics2 extends TextMetrics {

  public double actualBoundingBoxAscent;
  public double actualBoundingBoxDescent;
  public double actualBoundingBoxLeft;
  public double actualBoundingBoxRight;
  public double fontBoundingBoxAscent;
  public double fontBoundingBoxDescent;
}
