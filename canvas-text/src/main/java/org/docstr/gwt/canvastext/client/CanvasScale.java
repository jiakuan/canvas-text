package org.docstr.gwt.canvastext.client;

import static elemental2.dom.DomGlobal.window;

import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.HTMLCanvasElement;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

@JsType(name = "CanvasScale", namespace = JsPackage.GLOBAL)
public class CanvasScale {

  public static void configCanvasScale(
      HTMLCanvasElement canvas, double canvasWidth, double canvasHeight) {
    double devicePixelRatio = window.devicePixelRatio;

    // Increase the actual size of our canvas
    canvas.width = (int) (canvasWidth * devicePixelRatio);
    canvas.height = (int) (canvasHeight * devicePixelRatio);

    // Ensure all drawing operations are scaled
    CanvasRenderingContext2D ctx = Js.cast(canvas.getContext("2d"));
    ctx.scale(devicePixelRatio, devicePixelRatio);

    // Scale everything down using CSS
    canvas.style.setProperty("width", canvasWidth + "px");
    canvas.style.setProperty("height", canvasHeight + "px");
    canvas.style.setProperty("min-width", canvasWidth + "px");
    canvas.style.setProperty("min-height", canvasHeight + "px");
    canvas.style.setProperty("max-width", canvasWidth + "px");
    canvas.style.setProperty("max-height", canvasHeight + "px");
  }
}
