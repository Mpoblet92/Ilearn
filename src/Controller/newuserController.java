package Controller;

import java.lang.reflect.Array;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class newuserController {
	
	@FXML private Button btnCancel, btnSubmit;
	@FXML private PasswordField txtPassword, txtPasswordConfirm;
	@FXML private TextField txtUsername, txtEmail, txtEmailConfirm;
	@FXML private RadioButton radStudent, radAdvisor;
	@FXML private Label lblError;
	private String[] emailList = {"john@ung.edu", "jacob@ung.edu"};
	private String[] usernameList = {"john", "jacob"};
	
	@FXML
	public void clickCancel(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
		loginPage();
	}
	
	public void loginPage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@FXML
	public void clickSubmit(ActionEvent event) throws Exception
	{
		
		
		int pwd = passwordCheck();
		int email = emailCheck();
		int user = usernameCheck();

		switch (pwd) {
		case 0: 
		break;
		case 1: lblError.setText("Empty Password Field");
		break;
		case 2: lblError.setText("Empty Confirm Password Field");
		break;
		case 3: lblError.setText("Passwords do not match");
	    break;
		}
		
		switch (email) {
		case 0: 
		break;
		case 1: lblError.setText("Empty Email Field");
		break;
		case 2: lblError.setText("Empty Confirm Email Field");
		break;
		case 3: lblError.setText("Emails do not match");
	    break;
		case 4: lblError.setText("Email is in use");
		break;
		}
		
		switch (user) {
		case 0: 
		break;
		case 1: lblError.setText("Empty Username Field");
		break;
		case 2: lblError.setText("Username is in use");
		break;
		}
		
		if(pwd  + email + user == 0){
			//Stage stage = (Stage) btnCancel.getScene().getWindow();
			//profilePage();
			lblError.setText("Good to go!");
		}
			
	}
	
	public void profilePage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private int passwordCheck() throws Exception
	{
		if(txtPassword.getText().equals(""))
		{
			return 1;
		} else if(txtPasswordConfirm.getText().equals("")) {
			return 2;
		} else if(!txtPassword.getText().equals(txtPasswordConfirm.getText())) {
			return 3;
		} else {
			return 0;
		}

	}
	
	private int usernameCheck() throws Exception
	{
		if(txtUsername.getText().equals(""))
		{
			return 1;
		} else {
			for(int i = 0; i < usernameList.length; i++)
			{
				if (txtUsername.getText().equals(usernameList[i].toString()))
					return 2;
			}
		}
		return 0;
	}
	
	private int emailCheck() throws Exception
	{
		if(txtEmail.getText().equals(""))
			return 1;
		else if(txtEmailConfirm.getText().equals(""))
			return 2;
		else if(!txtEmail.getText().equals(txtEmailConfirm.getText()))
			return 3;
		else {
			for(int i = 0; i < emailList.length; i++)
			{
				if (txtEmail.getText().equals(emailList[i].toString()))
					return 4;
			}
		}
		return 0;
	}
	
	

}
