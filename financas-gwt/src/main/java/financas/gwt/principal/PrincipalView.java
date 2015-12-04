package financas.gwt.principal;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class PrincipalView extends Composite {

	private static PrincipalViewUiBinder uiBinder = GWT.create(PrincipalViewUiBinder.class);

	interface PrincipalViewUiBinder extends UiBinder<Widget, PrincipalView> {
	}

	public PrincipalView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
