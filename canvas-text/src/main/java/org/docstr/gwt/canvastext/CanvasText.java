package org.docstr.gwt.canvastext;

import static elemental2.dom.DomGlobal.alert;
import static elemental2.dom.DomGlobal.window;

import jsinterop.annotations.JsFunction;
import jsinterop.base.Js;

/**
 * J2CL entry point class.
 */
public class CanvasText {

  public void onModuleLoad() {
    Js.asPropertyMap(window)
        .set("hello", (OnCall) name -> alert("Hello " + name));
  }

  @JsFunction
  private interface OnCall {

    void invoke(String name);
  }
}
