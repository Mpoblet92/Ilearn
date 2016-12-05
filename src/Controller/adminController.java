package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import application.IlearnDBConfig;

public class adminController {

	@FXML private Button btnBack;

	@FXML
	public void clickBack(ActionEvent event) throws Exception
	{
		Stage stage = (Stage) btnBack.getScene().getWindow();
		stage.close();
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/View/MainMenu.fxml"));
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	Connection con = IlearnDBConfig.getConnection();
	Statement stmt = con.createStatement();
	String getPlan = "select * from collegeplan";
	ResultSet rs = stmt.executeQuery(getPlan);
}
