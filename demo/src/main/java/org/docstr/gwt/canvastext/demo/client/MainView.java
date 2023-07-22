package org.docstr.gwt.canvastext.demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;
import org.docstr.gwt.canvastext.demo.client.resources.Resources;

public class MainView extends Composite {

  interface MainViewUiBinder extends UiBinder<HTMLPanel, MainView> {

  }

  private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

  @UiField
  HTMLDivElement iconAlignLeft;
  @UiField
  HTMLDivElement iconAlignHCenter;
  @UiField
  HTMLDivElement iconAlignRight;
  @UiField
  HTMLDivElement iconAlignTop;
  @UiField
  HTMLDivElement iconAlignVCenter;
  @UiField
  HTMLDivElement iconAlignBottom;

  private final HTMLDivElement rootElement;
  private final HTMLInputElement checkboxJustify;
  private final HTMLInputElement checkboxDebug;

  public MainView() {
    initWidget(uiBinder.createAndBindUi(this));

    rootElement = Js.cast(getElement());
    checkboxJustify = Js.cast(rootElement.querySelector("#checkboxJustify"));
    checkboxDebug = Js.cast(rootElement.querySelector("#checkboxDebug"));

    iconAlignLeft.innerHTML = Resources.INSTANCE.svgAlignLeft().getText();
    iconAlignHCenter.innerHTML = Resources.INSTANCE.svgAlignHCenter().getText();
    iconAlignRight.innerHTML = Resources.INSTANCE.svgAlignRight().getText();
    iconAlignTop.innerHTML = Resources.INSTANCE.svgAlignTop().getText();
    iconAlignVCenter.innerHTML = Resources.INSTANCE.svgAlignVCenter().getText();
    iconAlignBottom.innerHTML = Resources.INSTANCE.svgAlignBottom().getText();
  }
}
