package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import application.IlearnDBConfig;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class loginController {
	@FXML private TextField txtUsername, txtEmail;
	@FXML private PasswordField txtPassword;
	@FXML private Button btnLogin, btnPos, btnBack;
	@FXML private Label lblStatus, lblActionStatus;
	@FXML private Hyperlink linkRegister;

	@FXML
	public void clickOnLogin(ActionEvent event) throws Exception
	{
		txtPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent keyEvent){
		        if (keyEvent.getCode() == KeyCode.ENTER)  {
		    		try {
						if(requestUserEntry())
						{
							lblActionStatus.setText("Success!");
							lblActionStatus.setTextFill(Color.GREEN);
						    Stage stage = (Stage) btnLogin.getScene().getWindow();
						    stage.close();
							mainMenuPage();
						}
						else
						{
							lblActionStatus.setText("Invalid Username or Password!");
							lblActionStatus.setTextFill(Color.FIREBRICK);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
		    		txtUsername.setText("");
		    		txtPassword.setText("");
		        }
		    }
		});
		if(txtUsername.getText().equals("user") && txtPassword.getText().equals("pass"))
		{
			lblActionStatus.setText("Success!");
			lblActionStatus.setTextFill(Color.GREEN);
		    Stage stage = (Stage) btnLogin.getScene().getWindow();
		    stage.close();
		    mainMenuPage();
		}
		else
		{
			lblActionStatus.setText("Invalid Username or Password!");
			lblActionStatus.setTextFill(Color.FIREBRICK);
		}
		txtUsername.setText("");
		txtPassword.setText("");

	}
	
	@FXML
	public void clickOnRegister(ActionEvent event) throws Exception
	{
		linkRegister.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		        if (mouseEvent.getEventType() != null)  {
		            Stage stage = (Stage) linkRegister.getScene().getWindow();
		            stage.close();
		            try {
						registerPage();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		        
		        }
		    }
		});
	}
	
	@FXML
	public void clickOnSubmit(ActionEvent event)
	{
		txtUsername.setText("");
		txtEmail.setText("");
		txtPassword.setText("");
	}

	@FXML 
	public void clickOnBack(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnBack.getScene().getWindow();
		stage.close();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/LoginView.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void mainMenuPage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@FXML
	public void registerPage() throws Exception
	{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/NewUser.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private boolean requestUserEntry() throws Exception
	{
		String user = txtUsername.getText();
		String pass = txtPassword.getText();
		String query = "select password from user where username='" + user + "'";
		Connection con = IlearnDBConfig.getConnection();
		Statement stmt = con.createStatement();
		ResultSet authenticate = stmt.executeQuery(query);
		String mainPass = null;
		while(authenticate.next())
			mainPass = authenticate.getString("password");
		authenticate.close();
		if(mainPass != null)
			return mainPass.equals(pass) ? true:false;
		return false;
	 }
}