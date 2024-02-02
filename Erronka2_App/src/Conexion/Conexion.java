package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JTextField;

public class Conexion {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/hackovo";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "1WMG2023";
	public static Connection dbConexioa() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
    
}
