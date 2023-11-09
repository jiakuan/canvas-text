package org.docstr.gwt.canvastext.demo.client;

import static elemental2.dom.DomGlobal.console;
import static elemental2.dom.DomGlobal.window;
import static org.docstr.gwt.canvastext.client.CanvasScale.configCanvasScale;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import elemental2.dom.CanvasRenderingContext2D;
import elemental2.dom.DOMRect;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLCanvasElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLTextAreaElement;
import jsinterop.base.Js;
import org.docstr.gwt.canvastext.client.CanvasText;
import org.docstr.gwt.canvastext.client.CanvasTextConfig;
import org.docstr.gwt.canvastext.demo.client.resources.Resources;

public class MainView extends Composite {

  interface MainViewUiBinder extends UiBinder<HTMLPanel, MainView> {

  }

  private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

  @UiField
  HTMLCanvasElement canvas;
  @UiField
  HTMLElement spanTimeSpent;
  @UiField
  HTMLTextAreaElement textarea;

  @UiField
  HTMLInputElement inputRangeX;
  @UiField
  HTMLInputElement inputNumberX;

  @UiField
  HTMLInputElement inputRangeY;
  @UiField
  HTMLInputElement inputNumberY;

  @UiField
  HTMLInputElement inputRangeWidth;
  @UiField
  HTMLInputElement inputNumberWidth;

  @UiField
  HTMLInputElement inputRangeHeight;
  @UiField
  HTMLInputElement inputNumberHeight;

  @UiField
  HTMLInputElement inputRangeFontSize;
  @UiField
  HTMLInputElement inputNumberFontSize;

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

  @UiField
  HTMLButtonElement btnReset;

  private final HTMLDivElement rootElement;
  private final HTMLInputElement checkboxJustify;
  private final HTMLInputElement checkboxDebug;

  private CanvasTextConfig config = CanvasText.canvasTextConfig();
  private final Timer resizer = new Timer() {
    @Override
    public void run() {
      canvas.style.display = "none";

      DOMRect canvasRect = canvas.parentElement.getBoundingClientRect();
      double canvasWidth = canvasRect.width;
      double canvasHeight = canvasRect.height;
      configCanvasScale(canvas, canvasWidth, canvasHeight);

      canvas.style.display = "block";
      updateCanvas();
    }
  };

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

    Scheduler.get().scheduleDeferred(() -> {
      DOMRect canvasRect = canvas.parentElement.getBoundingClientRect();
      double canvasWidth = canvasRect.width;
      double canvasHeight = canvasRect.height;
      configCanvasScale(canvas, canvasWidth, canvasHeight);

      setInitialSizeAndPosition();
      updateInputRanges();
      updateInputValues(config);
      updateCanvas();
    });
    textarea.addEventListener("input", evt -> updateCanvas());
    inputRangeX.addEventListener("input", evt -> {
      inputNumberX.value = inputRangeX.value;
      config.x = Double.parseDouble(inputRangeX.value);
      updateCanvas();
    });
    inputNumberX.addEventListener("input", evt -> {
      inputRangeX.value = inputNumberX.value;
      config.x = Double.parseDouble(inputNumberX.value);
      updateCanvas();
    });
    inputRangeY.addEventListener("input", evt -> {
      inputNumberY.value = inputRangeY.value;
      config.y = Double.parseDouble(inputRangeY.value);
      updateCanvas();
    });
    inputNumberY.addEventListener("input", evt -> {
      inputRangeY.value = inputNumberY.value;
      config.y = Double.parseDouble(inputNumberY.value);
      updateCanvas();
    });
    inputRangeWidth.addEventListener("input", evt -> {
      inputNumberWidth.value = inputRangeWidth.value;
      config.width = Double.parseDouble(inputRangeWidth.value);
      updateCanvas();
    });
    inputNumberWidth.addEventListener("input", evt -> {
      inputRangeWidth.value = inputNumberWidth.value;
      config.width = Double.parseDouble(inputNumberWidth.value);
      updateCanvas();
    });
    inputRangeHeight.addEventListener("input", evt -> {
      inputNumberHeight.value = inputRangeHeight.value;
      config.height = Double.parseDouble(inputRangeHeight.value);
      updateCanvas();
    });
    inputNumberHeight.addEventListener("input", evt -> {
      inputRangeHeight.value = inputNumberHeight.value;
      config.height = Double.parseDouble(inputNumberHeight.value);
      updateCanvas();
    });
    inputRangeFontSize.addEventListener("input", evt -> {
      inputNumberFontSize.value = inputRangeFontSize.value;
      config.fontSize = Double.parseDouble(inputRangeFontSize.value);
      updateCanvas();
    });
    inputNumberFontSize.addEventListener("input", evt -> {
      inputRangeFontSize.value = inputNumberFontSize.value;
      config.fontSize = Double.parseDouble(inputNumberFontSize.value);
      updateCanvas();
    });
    checkboxJustify.addEventListener("change", evt -> {
      config.justify = checkboxJustify.checked;
      updateCanvas();
    });
    checkboxDebug.addEventListener("change", evt -> {
      config.debug = checkboxDebug.checked;
      updateCanvas();
    });
    iconAlignLeft.addEventListener("click", evt -> {
      config.align = "left";
      updateIconAlign(config);
      updateCanvas();
    });
    iconAlignHCenter.addEventListener("click", evt -> {
      config.align = "center";
      updateIconAlign(config);
      updateCanvas();
    });
    iconAlignRight.addEventListener("click", evt -> {
      config.align = "right";
      updateIconAlign(config);
      updateCanvas();
    });
    iconAlignTop.addEventListener("click", evt -> {
      config.vAlign = "top";
      updateIconVAlign(config);
      updateCanvas();
    });
    iconAlignVCenter.addEventListener("click", evt -> {
      config.vAlign = "middle";
      updateIconVAlign(config);
      updateCanvas();
    });
    iconAlignBottom.addEventListener("click", evt -> {
      config.vAlign = "bottom";
      updateIconVAlign(config);
      updateCanvas();
    });
    btnReset.addEventListener("click", evt -> {
      config = CanvasText.canvasTextConfig();
      setInitialSizeAndPosition();
      updateInputValues(config);
      updateCanvas();
    });

    window.addEventListener("resize", evt -> resizer.schedule(300));
  }

  private void setInitialSizeAndPosition() {
    DOMRect canvasRect = canvas.getBoundingClientRect();
    config.width = canvasRect.width / 2;
    config.height = canvasRect.height / 2;
    config.x = (canvasRect.width - config.width) / 2;
    config.y = (canvasRect.height - config.height) / 2;
    console.log("x=" + config.x + ", y=" + config.y
        + ", width=" + config.width + ", height=" + config.height);
  }

  private void updateInputRanges() {
    DOMRect canvasRect = canvas.getBoundingClientRect();
    int width = (int) canvasRect.width;
    int height = (int) canvasRect.height;
    console.log("Updating max width and height for sliders"
        + ": canvasRect=" + width + "x" + height);

    inputRangeX.max = String.valueOf(width);
    inputNumberX.max = String.valueOf(width);

    inputRangeY.max = String.valueOf(height);
    inputNumberY.max = String.valueOf(height);

    inputRangeWidth.max = String.valueOf(width);
    inputNumberWidth.max = String.valueOf(width);

    inputRangeHeight.max = String.valueOf(height);
    inputNumberHeight.max = String.valueOf(height);

    inputRangeFontSize.min = "11";
    inputNumberFontSize.min = "11";

    inputRangeFontSize.max = "72";
    inputNumberFontSize.max = "72";
  }

  private void updateInputValues(CanvasTextConfig config) {
    inputRangeX.value = String.valueOf(config.x);
    inputNumberX.value = String.valueOf(config.x);

    inputRangeY.value = String.valueOf(config.y);
    inputNumberY.value = String.valueOf(config.y);

    inputRangeWidth.value = String.valueOf(config.width);
    inputNumberWidth.value = String.valueOf(config.width);

    inputRangeHeight.value = String.valueOf(config.height);
    inputNumberHeight.value = String.valueOf(config.height);

    inputRangeFontSize.value = String.valueOf(config.fontSize);
    inputNumberFontSize.value = String.valueOf(config.fontSize);

    updateIconAlign(config);
    updateIconVAlign(config);

    checkboxJustify.checked = config.justify;
    checkboxDebug.checked = config.debug;
  }

  private void updateIconAlign(CanvasTextConfig config) {
    if ("left".equalsIgnoreCase(config.align)) {
      iconAlignLeft.classList.add("active");
      iconAlignHCenter.classList.remove("active");
      iconAlignRight.classList.remove("active");
    }
    if ("center".equalsIgnoreCase(config.align)) {
      iconAlignLeft.classList.remove("active");
      iconAlignHCenter.classList.add("active");
      iconAlignRight.classList.remove("active");
    }
    if ("right".equalsIgnoreCase(config.align)) {
      iconAlignLeft.classList.remove("active");
      iconAlignHCenter.classList.remove("active");
      iconAlignRight.classList.add("active");
    }
  }

  private void updateIconVAlign(CanvasTextConfig config) {
    if ("top".equalsIgnoreCase(config.vAlign)) {
      iconAlignTop.classList.add("active");
      iconAlignVCenter.classList.remove("active");
      iconAlignBottom.classList.remove("active");
    }
    if ("middle".equalsIgnoreCase(config.vAlign)) {
      iconAlignTop.classList.remove("active");
      iconAlignVCenter.classList.add("active");
      iconAlignBottom.classList.remove("active");
    }
    if ("bottom".equalsIgnoreCase(config.vAlign)) {
      iconAlignTop.classList.remove("active");
      iconAlignVCenter.classList.remove("active");
      iconAlignBottom.classList.add("active");
    }
  }

  private void updateCanvas() {
    CanvasRenderingContext2D ctx = Js.cast(canvas.getContext("2d"));
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    long startTime = System.nanoTime();
    double height = CanvasText.drawText(ctx, textarea.value, config);

    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    double durationMs = duration / 1000000.0;
    spanTimeSpent.innerHTML = durationMs + "";
    console.log("CanvasText.drawText: textHeight=" + height
        + ", timeSpent=" + durationMs + "ms");
  }
}
