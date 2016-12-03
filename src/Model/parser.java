package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import application.IlearnDBConfig;

public class parser {

	public static String[] or(String area) {
		String delim = "[,]" + "[ ]";
		String[] parsed = area.split(delim);
		return parsed;
	}

	public static String[] and(String area)
	{
		String delim = "[;]" + "[ ]";
		String[] parsed = area.split(delim);
		return parsed;
	}
}


