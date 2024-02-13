package Main;

import java.sql.Connection;
import Conexion.Conexion;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import Taulak.Taulak;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import Main.sarrera;

public class funtzioak {
	
	public static int sartu( String pasahitza, String izena) {
		
		
		try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
			
			if (connection != null) {
               
				
				Statement stat=connection.createStatement();   
	    	    ResultSet res=stat.executeQuery("select * from usuarios;");
	    	    ResultSetMetaData rsmd = res.getMetaData();
	    	 
				baimenak(connection, izena, pasahitza, res);
				
            }	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
		
	}
	
	public static int baimenak(Connection connection, String izena, String pasahitza, ResultSet res) {
		// TODO Auto-generated method stub
		DefaultTableModel taula = new DefaultTableModel();
		taula.addColumn("Id");
	    taula.addColumn("Usuario");
	    taula.addColumn("Contraseña");
	    taula.addColumn("Permiso");
	    
		 String[] array = new String[4];
		 
		
		    try {
				while(res.next())
				{
					
					    array[1] = res.getString(1 + 1);
					    array[2] = res.getString(2 + 1);
					    array[3] = res.getString(3 + 1);
					
					    
					if(izena.equals(array[1]) && pasahitza.equals(array[2]) && array[3].equals("1")) {
						System.out.println("PERMISO");
						Taulak.main(1);
						return 1;				
					}else if(izena.equals(array[1]) && pasahitza.equals(array[2]) && array[3] != "0") {
						System.out.println("SIN PERMISO");
						Taulak.main(0);
						return 1;
					}
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    return 0;
		   
	}
}
