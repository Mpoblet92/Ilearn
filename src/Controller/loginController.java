package Controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class loginController {
	@FXML private TextField txtUsername;
	@FXML private PasswordField txtPassword;
	@FXML private Button btnLogin;
	@FXML private Label lblStatus, lblActionStatus;

	@FXML
	public void clickOnLogin(ActionEvent event) throws Exception
	{
		if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass"))
		{
			lblActionStatus.setText("Success!");
			lblActionStatus.setTextFill(Color.GREEN);
		    Stage stage = (Stage) btnLogin.getScene().getWindow();
		    stage.close();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
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