package AplikazioaLangileak;

import AplikazioaLangileak.pan2;
import AplikazioaLangileak.pan1;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MySQLConexion {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/reborn";
    public static final String DB_USER = "usuarioa";
    public static final String DB_PASSWORD = "@1WMG2023";

    public static void mainSQL(String[] args) {
    }

    public static void erabiltzaileZerrendaErakutsi(Connection connection, String value, JTable table) {
        // Hemen exekutatu SELECT kontsulta datu basean
        // Erabiltzaile zerrenda datu baseatik lortu eta erakutsi
    	try 
    	{
    	    Statement stat=connection.createStatement(); 
    	    ResultSet res=stat.executeQuery("select * from " + value + ";");
    	    ResultSetMetaData rsmd = res.getMetaData();
     	    DefaultTableModel taula = new DefaultTableModel();
    		
    	    if(value.equals("biltegia")) {
	    		biltegiaikusi(taula, table, res);
    	    }
    	    else if(value.equals("langileak")) {
    	    	langileakikusi(taula, table , res);

    	    }
    	    else if(value.equals("hornitzailea")) {
    	    	hornitzaileakikusi(taula,table,res);
    	    }
    	    else if(value.equals("bezeroa")) {
    	    	bezeroakikusi(taula,table,res);
    	    }
    	    else if(value.equals("logistika")) {
    	    	logistikaikusi(taula,table,res);
    	    }
    	}
    	catch(Exception ex)
    	{       
    	    System.out.println(ex);
    	}
   
    	    
    }

	private static void logistikaikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
    	taula.addColumn("Produktuen_xehetasunak");
	    taula.addColumn("Eskaera_zenbakia");
	    taula.addColumn("Aberia");
	    taula.addColumn("Kostuak");
	    
	    String[] array = new String[4];
	    
	    table.setModel(taula);
	    try {
			while(res.next())
			{
				int i=0;
				while(i < 4) {	
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

	private static void bezeroakikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		taula.addColumn("Izena");
	    taula.addColumn("Abizena");
	    taula.addColumn("DNI");
	    taula.addColumn("Telefono_zenbakia");
	    taula.addColumn("Helbidea");
	    taula.addColumn("Generoa");
	    taula.addColumn("Probintzia");
	    taula.addColumn("Herria");
	    taula.addColumn("Kalea");
	    taula.addColumn("Pisua");
	    taula.addColumn("Pk");
	    taula.addColumn("Kontu_korrontea");





	    
	    String[] array = new String[12];
	    
	    table.setModel(taula);
	    try {
			while(res.next())
			{
				int i=0;
				while(i < 12) {	
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

	private static void hornitzaileakikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		taula.addColumn("Enpresa");
	    taula.addColumn("Materiala");
	    taula.addColumn("Webgunea");
	    taula.addColumn("Kontu korrontea");
	    taula.addColumn("Telefono zenb");
	    taula.addColumn("Gmail");
	    
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

	private static void langileakikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
    	taula.addColumn("Izena");
	    taula.addColumn("Abizena");
	    taula.addColumn("DNI");
	    taula.addColumn("Jaiotze_data");
	    taula.addColumn("Hizkuntzak");
	    taula.addColumn("Soldata");
	    taula.addColumn("Helbidea");
	    taula.addColumn("Generoa");
	    taula.addColumn("Telefono_zenbakia");
	    taula.addColumn("Gmail_helbidea");
	    taula.addColumn("Id");
	    
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

	private static void biltegiaikusi(DefaultTableModel taula, JTable table, ResultSet res) {
		// TODO Auto-generated method stub
		
		taula.addColumn("Produktua");
	    taula.addColumn("id");
	    taula.addColumn("Deskribapena");
	    taula.addColumn("Stock");
	    taula.addColumn("Stock_kantitatea");
	    taula.addColumn("Produktuaren_KG");
	   


	    
	    
	    String[] array = new String[10];
	    
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

	public static void erabiltzaileakAldatu(Connection connection, String value, JTable table) {
        // Hemen exekutatu UPDATE kontsulta datu basean
        // Erabiltzaileak aldatu datu basean
    	erabiltzaileZerrendaErakutsi(connection, value, table);
        System.out.println("Aldatu nahi duzun erabiltzailearen id-a sartu:");
        String id = new Scanner(System.in).nextLine();
        System.out.println("Aldatu nahi duzun erabiltzailearen Izena sartu:");
        String izena = new Scanner(System.in).nextLine();
        System.out.println("Aldatu nahi duzun erabiltzailearen Abizena sartu:");
        String abizena = new Scanner(System.in).nextLine();
        System.out.println("Aldatu nahi duzun erabiltzailearen PK sartu:");
        String pk = new Scanner(System.in).nextLine();
        

        try {
            String sql = "UPDATE " + value + " SET Izena=? , Abizena=? , KodigoPostala=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, izena);
            preparedStatement.setString(2, abizena);
            preparedStatement.setString(3, pk);
            preparedStatement.setString(4, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Erabiltzailearen datuak aldatu dira.");
            } else {
                System.out.println("Ez da id-a topatu.");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Errorea erabiltzailea aldatzerakoan: " + e.getMessage());
        }
    }
    

    public static void erabiltzaileBerriaGehitu(Connection connection, String datuBasea) {
        // Hemen exekutatu INSERT kontsulta datu basean
        // Erabiltzaile berria gehitu datu basean
    	System.out.println("Erabiltzaile berriaren id-a sartu:");
        String id = new Scanner(System.in).nextLine();
        System.out.println("Erabiltzailearen izena sartu:");
        String izena = new Scanner(System.in).nextLine();
        System.out.println("Erabiltzailearen abizena sartu:");
        String abizena = new Scanner(System.in).nextLine();
        System.out.println("Erabiltzailearen PostaKodea sartu:");
        String pk = new Scanner(System.in).nextLine();

        
        try {
            String sql = "INSERT INTO " + datuBasea + " (id, Izena, Abizena, KodigoPostala) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, izena);
            preparedStatement.setString(3, abizena);
            preparedStatement.setString(4, pk);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Erabiltzailea ongi gehitu da.");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Errorea erabiltzaile berria gehitzerakoan: " + e.getMessage());
        }
    }

    public static void erabiltzaileaEzabatu(Connection connection,String value, JTable table) {
        // Hemen exekutatu DELETE kontsulta datu basean
        // Erabiltzailea ezabatu datu basean
    	erabiltzaileZerrendaErakutsi(connection, value, table);
        System.out.println("Ezabatu nahi duzun erabiltzailearen id-a sartu:");
        String id = new Scanner(System.in).nextLine();

        try {
            String sql = "DELETE FROM " + value  + " WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Erabiltzailea ezabatuta dago.");
            } else {
                System.out.println("Erabiltzailea ez da topatu.");
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Errorea erabiltzailea ezabatzerakoan: " + e.getMessage());
        }

	
    }

	public static void taulabetween(Connection connection, String value, JTable table, JTextField textFieldBetween , JTextField textFieldColumn) {
		// TODO Auto-generated method stub
	    Statement stat;
		try {
			 String valueColumn= textFieldColumn.getText();
			 String valueBetween= textFieldBetween.getText();
			stat = connection.createStatement();
			ResultSet res=stat.executeQuery("select * from " + value + " where " + valueColumn +  " BETWEEN " + valueBetween +";");
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
		if(value.equals("biltegia")) {
    		biltegiaikusi(taula, table, res);
	    }
	    else if(value.equals("langileak")) {
	    	langileakikusi(taula, table , res);

	    }
	    else if(value.equals("hornitzailea")) {
	    	hornitzaileakikusi(taula,table,res);
	    }
	    else if(value.equals("bezeroa")) {
	    	bezeroakikusi(taula,table,res);
	    }
	    else if(value.equals("logistika")) {
	    	logistikaikusi(taula,table,res);
	    }
	}

	public static void taulain(Connection connection, String value, JTable table, JTextField textFieldBetween , JTextField textFieldColumn) {
		// TODO Auto-generated method stub
	    Statement stat;
		try {
			 String valueColumn= textFieldColumn.getText();
			 String valueBetween= textFieldBetween.getText();
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
		if(value.equals("biltegia")) {
    		biltegiaikusi(taula, table, res);
	    }
	    else if(value.equals("langileak")) {
	    	langileakikusi(taula, table , res);

	    }
	    else if(value.equals("hornitzailea")) {
	    	hornitzaileakikusi(taula,table,res);
	    }
	    else if(value.equals("bezeroa")) {
	    	bezeroakikusi(taula,table,res);
	    }
	    else if(value.equals("logistika")) {
	    	logistikaikusi(taula,table,res);
	    }
	}

	
	public static void taulaasc(Connection connection, String value, JTable table, JTextField textFieldBetween,
			JTextField textFieldColumn) {
		// TODO Auto-generated method stub
		 Statement stat;
			try {
				 String valueColumn= textFieldColumn.getText();
				 String valueBetween= textFieldBetween.getText();
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
			 String valueBetween= textFieldBetween.getText();
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
				 String valueColumn= textFieldColumn.getText();
				 String valueBetween= textFieldBetween.getText();
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

