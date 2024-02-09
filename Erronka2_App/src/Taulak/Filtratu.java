package Taulak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Filtratu {

	public static void erabiltzaileZerrendaErakutsi(Connection connection, String value, JTable table) {
        // Hemen exekutatu SELECT kontsulta datu basean
        // Erabiltzaile zerrenda datu baseatik lortu eta erakutsi
    	try 
    	{
    	    Statement stat=connection.createStatement(); 
    	    ResultSet res=stat.executeQuery("select * from " + value + ";");
    	    ResultSetMetaData rsmd = res.getMetaData();
     	    DefaultTableModel taula = new DefaultTableModel();
    		
     	    
    	    if(value.equals("almazena")) {
    	    	//Eginda
    	    	almazenaikusi(taula, table, res);
    	    }
    	    else if(value.equals("bezeroak")) {
    	    	//Eginda
    	    	bezeroakikusi(taula,table,res);
    	    }
    	    else if(value.equals("eskariak")) {
    	    	//Eginda
    	    	eskariakikusi(taula,table,res);
    	    }
    	    else if(value.equals("faktura")) {
    	    	//Eginda
    	    	fakturaikusi(taula,table,res);
    	    }
    	    else if(value.equals("hornitzaileformulario")) {
    	    	//Eginda
    	    	hornitzaileformularioikusi(taula,table,res);
    	    }
    	    else if(value.equals("langileak")) {
    	    	//Eginda
    	    	langileakikusi(taula,table,res);
    	    }
    	    else if(value.equals("eskariak")) {
    	    	//Eginda
    	    	langileakikusi(taula,table,res);
    	    }
    	    else if(value.equals("faktura")) {
    	    	//Eginda
    	    	fakturaikusi(taula,table,res);
    	    }
    	}
    	catch(Exception ex)
    	{       
    	    System.out.println(ex);
    	}
   
    	    
    }

	//Eginda
	private static void eskariakikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		taula.addColumn("id_eskaria");
	    taula.addColumn("NAN");
	    taula.addColumn("egoera");
	   

	    String[] array = new String[3];
	    
	    table.setModel(taula);
	    try {
			while(res.next())
			{
				int i=0;
				while(i < 3) {	
			    array[i] = res.getString(i + 1);
			    i++;
				}
				taula.addRow(array);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    table.setModel(taula);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}	
	//Eginda
	private static void fakturaikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		taula.addColumn("id_eskaria");
	    taula.addColumn("ErregistroID");
	    taula.addColumn("kantitatea");
	   

	    String[] array = new String[3];
	    
	    table.setModel(taula);
	    try {
			while(res.next())
			{
				int i=0;
				while(i < 3) {	
			    array[i] = res.getString(i + 1);
			    i++;
				}
				taula.addRow(array);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    table.setModel(taula);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	//Eginda
	private static void bezeroakikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		taula.addColumn("NAN");
	    taula.addColumn("izena");
	    taula.addColumn("abizena");
	    taula.addColumn("telefonoa");
	    taula.addColumn("korreoa");
	    taula.addColumn("helbidea");
	    taula.addColumn("herria");
	    taula.addColumn("probintzia");
	    taula.addColumn("PK");
	    taula.addColumn("KK");
	    taula.addColumn("enpresa");






	    
	    String[] array = new String[11];
	    
	    table.setModel(taula);
	    try {
			while(res.next())
			{
				int i=0;
				while(i < 11) {	
			    array[i] = res.getString(i + 1);
			    i++;
				}
				taula.addRow(array);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	//Eginda
	private static void hornitzaileformularioikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		taula.addColumn("TelZenbakia");
	    taula.addColumn("Izena");
	    taula.addColumn("NAN");
	    taula.addColumn("HornitzaileMota");
	    taula.addColumn("Helbidea");
	    taula.addColumn("Zerbitzua");
	    
	    String[] array = new String[6];
	    
	    table.setModel(taula);
	    try {
			while(res.next())
			{
				int i=0;
				while(i < 6) {	
			    array[i] = res.getString(i + 1);
			    i++;
				}
				taula.addRow(array);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	//Eginda
	private static void langileakikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		taula.addColumn("NAN");
	    taula.addColumn("izena");
	    taula.addColumn("abizena");
	    taula.addColumn("email");
	    taula.addColumn("telefonoa");
	    taula.addColumn("helbidea");
	    taula.addColumn("PK");
	    taula.addColumn("postua");
	    taula.addColumn("jaiotzeData");
	    taula.addColumn("KK");
	    
	    String[] array = new String[10];
	  
	    table.setModel(taula);
	    try {
			while(res.next())
			{
				int i=0;
				while(i < 10) {	
			    array[i] = res.getString(i + 1);
			    i++;
				}
				taula.addRow(array);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}
	//Eginda
	private static void almazenaikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		
		taula.addColumn("ErregistroID");
		 taula.addColumn("prd_mota_id");
	    taula.addColumn("izena");
	    taula.addColumn("kantitatea");
	    taula.addColumn("modeloa");
	    taula.addColumn("marka");
	    taula.addColumn("prezioaE");
	    taula.addColumn("prezioaS");
	    taula.addColumn("berria");
	    taula.addColumn("Irudia");
	    taula.addColumn("balorazioa");
	   


	    
	    
	    String[] array = new String[11];
	    
	    table.setModel(taula);
	    try {
			while(res.next())
			{
				int i=0;
				while(i < 11) {	
			    array[i] = res.getString(i + 1);
			    i++;
				}
				taula.addRow(array);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
	//-------------------------------------------------------------------------------------------------------------------------------------------//
	
	public static void taulabetween(Connection connection, String value, JTable table, JTextField textFieldBetween , JTextField textFieldColumn) {
		// TODO Auto-generated method stub
	    Statement stat;
		try {
	
			stat = connection.createStatement();
			
			
			String valueBetween = textFieldBetween.getText();
			ResultSet res=stat.executeQuery("select * from " + value + " where " + textFieldColumn.getText() +  " BETWEEN " + valueBetween +";");
			
	 	    ResultSetMetaData rsmd = res.getMetaData();
	 	    DefaultTableModel taula = new DefaultTableModel();
			between(taula, table, res, value);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void between(DefaultTableModel taula, JTable table, ResultSet res, String value) {
		// TODO Auto-generated method stub
		if(value.equals("almazena")) {
	    	//Eginda
	    	almazenaikusi(taula, table, res);
	    }
	    else if(value.equals("bezeroak")) {
	    	//Eginda
	    	bezeroakikusi(taula,table,res);
	    }
	    else if(value.equals("eskariak")) {
	    	//Eginda
	    	eskariakikusi(taula,table,res);
	    }
	    else if(value.equals("faktura")) {
	    	//Eginda
	    	fakturaikusi(taula,table,res);
	    }
	    else if(value.equals("hornitzaileformulario")) {
	    	//Eginda
	    	hornitzaileformularioikusi(taula,table,res);
	    }
	    else if(value.equals("langileak")) {
	    	//Eginda
	    	langileakikusi(taula,table,res);
	    }
	}

	public static void taulain(Connection connection, String value, JTable table, JTextField textFieldBetween , JTextField textFieldColumn) {
		// TODO Auto-generated method stub
	    Statement stat;
		try {
			 String valueColumn = textFieldColumn.getText();
			 String valueBetween = textFieldBetween.getText();
			stat = connection.createStatement();
			ResultSet res=stat.executeQuery("SELECT * FROM " + value + " WHERE " + valueBetween + " IN (" + valueColumn + ");");
	 	    ResultSetMetaData rsmd = res.getMetaData();
	 	    DefaultTableModel taula = new DefaultTableModel();
			in(taula, table, res, value);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void in(DefaultTableModel taula, JTable table, ResultSet res, String value) {
		// TODO Auto-generated method stub
		if(value.equals("almazena")) {
	    	//Eginda
	    	almazenaikusi(taula, table, res);
	    }
	    else if(value.equals("bezeroak")) {
	    	//Eginda
	    	bezeroakikusi(taula,table,res);
	    }
	    else if(value.equals("eskariak")) {
	    	//Eginda
	    	eskariakikusi(taula,table,res);
	    }
	    else if(value.equals("faktura")) {
	    	//Eginda
	    	fakturaikusi(taula,table,res);
	    }
	    else if(value.equals("hornitzaileformulario")) {
	    	//Eginda
	    	hornitzaileformularioikusi(taula,table,res);
	    }
	    else if(value.equals("langileak")) {
	    	//Eginda
	    	langileakikusi(taula,table,res);
	    }
	}

	
	public static void taulaasc(Connection connection, String value, JTable table, JTextField textFieldBetween,
			JTextField textFieldColumn) {
		// TODO Auto-generated method stub
		 Statement stat;
			try {
				 String valueColumn= textFieldColumn.getText();
				stat = connection.createStatement();
				ResultSet res=stat.executeQuery("SELECT distinct * FROM "+ value + " order by " + valueColumn + " asc;");
		 	    ResultSetMetaData rsmd = res.getMetaData();
		 	    DefaultTableModel taula = new DefaultTableModel();
				in(taula, table, res, value);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public static void tauladesc(Connection connection, String value, JTable table, JTextField textFieldBetween,
			JTextField textFieldColumn) {
		// TODO Auto-generated method stub
		Statement stat;
		try {
			 String valueColumn= textFieldColumn.getText();
			stat = connection.createStatement();
			ResultSet res=stat.executeQuery("SELECT distinct * FROM "+ value + " order by " + valueColumn + " desc;");
	 	    ResultSetMetaData rsmd = res.getMetaData();
	 	    DefaultTableModel taula = new DefaultTableModel();
			in(taula, table, res, value);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void taulacount(Connection connection, String value, JTable table, JTextField textFieldBetween,
			JTextField textFieldColumn) {
			// TODO Auto-generated method stub
			Statement stat;
			try {
				stat = connection.createStatement();
				ResultSet res=stat.executeQuery("SELECT count(*) FROM " + value + ";");
		 	    ResultSetMetaData rsmd = res.getMetaData();
		 	    DefaultTableModel taula = new DefaultTableModel();
		 	    taula.addColumn("Zenbat:");
		 	    
		 	   String[] array = new String[1];
			    
			    table.setModel(taula);
			    try {
					while(res.next())
					{
						int i=0;
						while(i < 1) {	
					    array[i] = res.getString(i + 1);
					    i++;
						}
						taula.addRow(array);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 	
		 	   
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	
	public static void taulalike(Connection connection, String value, JTable table, JTextField textFieldBetween,
			JTextField textFieldColumn) {
		// TODO Auto-generated method stub
		Statement stat;
		try {
			 String valueColumn= textFieldColumn.getText();
			 String valueBetween= textFieldBetween.getText();
			stat = connection.createStatement();
			ResultSet res=stat.executeQuery("SELECT * FROM "+ value + " where " + valueColumn + " like '" + valueBetween +"%';");
	 	    ResultSetMetaData rsmd = res.getMetaData();
	 	    DefaultTableModel taula = new DefaultTableModel();
			in(taula, table, res, value);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
