package financas.gwt.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite {

	private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}

	@UiField
	TextBox usuario;
	
	@UiField
	InputElement senha;
	
	@UiField
	Button entrar;
	
	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
		
		usuario.setValue("walison");
		
		senha.setValue("123");
	}
	
	@UiHandler("entrar")
	public void entrarClick(ClickEvent e) {
		Window.alert("usuario:" + usuario.getValue());
	}

}
