package org.docstr.gwt.canvastext.demo.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface Resources extends ClientBundle {

  Resources INSTANCE = GWT.create(Resources.class);

  @Source("align-bottom.svg")
  TextResource svgAlignBottom();

  @Source("align-h-center.svg")
  TextResource svgAlignHCenter();

  @Source("align-left.svg")
  TextResource svgAlignLeft();

  @Source("align-right.svg")
  TextResource svgAlignRight();

  @Source("align-top.svg")
  TextResource svgAlignTop();

  @Source("align-v-center.svg")
  TextResource svgAlignVCenter();
}
