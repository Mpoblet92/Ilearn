package Controller;

import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class loginController {
	@FXML private TextField txtUser;
	@FXML private PasswordField txtPassword;
	@FXML private Button btnLogin;
	@FXML private Label lblStatus, lblActionStatus;

	public void clickOnLogin(ActionEvent event) throws Exception {
		//requestUserEntry();
		lblActionStatus.setTextFill(Color.FIREBRICK);
		lblActionStatus.setText("Sign in Button Pressed!");
	}

	/*private void requestUserEntry() {
		String query = "request user entry " + "(user, password)"
				+ "values(?,?)";
		ResultSet keys = null;

	 }*/
}
