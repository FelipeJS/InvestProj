package financas.gwt;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import financas.gwt.principal.PrincipalView;

public class GwtEntryPoint implements EntryPoint {

  public void onModuleLoad() {
    RootPanel.get().add(new PrincipalView());
  }

}