package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.parser;
import application.IlearnDBConfig;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;

public class planofstudyController {
	
	@FXML private Button btnBack;
	@FXML private Accordion listA, listB, listC, listD, listE, listF, listMajor;
	
	public void loadPlan() throws Exception
	{
		String major, pos, areaA = null, areaB = null, areaC = null, areaD = null, areaE = null, areaF = null, majorArea = null;
		String[] parsedAreaA, parsedAreaB, parsedAreaC, parsedAreaD, parsedAreaE, parsedAreaF, parsedMajorArea;
		Connection con = IlearnDBConfig.getConnection();
		Statement stmt = con.createStatement();
		String getPlan = "select * from collegeplan";
		ResultSet rs = stmt.executeQuery(getPlan);
		while(rs.next())
		{
			major = rs.getString("major");
			pos = rs.getString("pos");
			areaA = rs.getString("AreaA");
			areaB = rs.getString("AreaB");
			areaC = rs.getString("AreaC");
			areaD = rs.getString("AreaD");
			areaE = rs.getString("AreaE");
			areaF = rs.getString("AreaF");
			majorArea = rs.getString("majorArea");
		}
		con.close();
			parsedAreaA = parser.and(areaA);
			//parsedAreaB = parser.and(areaB);
			parsedAreaC = parser.and(areaC);
			parsedAreaD = parser.and(areaD);
			parsedAreaE = parser.and(areaE);
			parsedAreaF = parser.and(areaF);
			parsedMajorArea = parser.and(majorArea);
			
			setTitlePane(listA, parsedAreaA);
		/*
		
		TextArea desc = new TextArea();
		TitledPane titleAreaA = new TitledPane("english", desc);
		listA.getPanes().addAll(titleAreaA);
	*/
	}
	
	public void setTitlePane(Accordion list, String[] parsedArea)
	{
		for (int i = 0; i < parsedArea.length;i++)
		{
			if(parsedArea[i].contains(","))
			{
				String[] orClass = parser.or(parsedArea[i]);
				for(int o = 0; o < orClass.length; o++)
				{
					TextArea desc = new TextArea();
					TitledPane titleOrArea = new TitledPane(orClass[o], desc);
					list.getPanes().addAll(titleOrArea);
				}
			}
			else
			{
				TextArea descr = new TextArea();
				TitledPane titleArea = new TitledPane(parsedArea[i], descr);
				list.getPanes().addAll(titleArea);
				
			}
		}
	}
	
	public String[] getCourseInfo() throws Exception
	{
		String[] course = new String[2];
		Connection con = IlearnDBConfig.getConnection();
		Statement stmt = con.createStatement();
		String getCourseName = "select courseName from course where courseId='Math 1450'";
		ResultSet r = stmt.executeQuery(getCourseName);
		while(r.next())
		{
			course[0] = r.getString("courseName");
			course[1] = r.getString("description");
		}
		con.close();
		return course;
	}
	
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

}
