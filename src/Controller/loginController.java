package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class loginController {
	@FXML private TextField txtUsername;
	@FXML private PasswordField txtPassword;
	//@FXML private Button btnLogin;
	@FXML private Label lblStatus, lblActionStatus;

	@FXML
	public void clickOnLogin(ActionEvent event) 
	{
		if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass"))
		{
			lblActionStatus.setText("Success!");
			lblActionStatus.setTextFill(Color.GREEN);
		}
		else
		{
			lblActionStatus.setText("Invalid Username or Password!");	
			lblActionStatus.setTextFill(Color.FIREBRICK);
		}
		txtUsername.setText("");
		txtPassword.setText("");
	
	}

	/*private void requestUserEntry() {
		String query = "request user entry " + "(user, password)"
				+ "values(?,?)";
		ResultSet keys = null;

	 }*/
}
