package org.docstr.gwt.canvastext.demo.linker;

import com.google.gwt.core.ext.LinkerContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.linker.SingleScriptLinker;

/**
 * @author jake
 */
public class CustomSingleScriptLinker extends SingleScriptLinker {

  @Override
  protected String getSelectionScriptTemplate(TreeLogger logger,
      LinkerContext context) throws UnableToCompleteException {
    return "org/docstr/gwt/canvastext/demo/linker/CustomSingleScriptTemplate.js";
  }
}
