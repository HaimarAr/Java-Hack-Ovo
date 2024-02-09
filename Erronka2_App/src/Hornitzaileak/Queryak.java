package Hornitzaileak;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

public class Queryak {
	
	public static void Borratu(JTextField id) {
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {
            	try {
                    String sql = "DELETE FROM hornitzaileformulario WHERE NAN=?";
                    
           		                    
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    String id2 = id.getText();
                    preparedStatement.setString(1, id2);
                    int affectedRows = preparedStatement.executeUpdate();
                    if (affectedRows > 0) {
                        System.out.println("Erabiltzailea ezabatuta dago.");
                    } else {
                        System.out.println("Erabiltzailea ez da topatu.");
                    }
                    preparedStatement.close();
                } catch (SQLException e1) {
                    System.err.println("Errorea erabiltzailea ezabatzerakoan: " + e1.getMessage());
                }
        }
	} catch (SQLException a) {
        System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
    }
}

	public static void Update(JTextField telZenbakia, JTextField NAN, JTextField izena, JTextField hornitzaileMota,
			JTextField helbidea, JTextField zerbitzua) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {	                
			 try {
		            String sql = "UPDATE hornitzaileformulario SET TelZenbakia=? , Izena=? , HornitzaileMota=? , Helbidea=?, Zerbitzua=? WHERE NAN=?";
		            
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            
		            preparedStatement.setString(1, telZenbakia.getText());
		            
		            preparedStatement.setString(2, izena.getText());
		            
		            preparedStatement.setString(3, hornitzaileMota.getText());
		            
                    preparedStatement.setString(4, helbidea.getText()); 
                    
                    preparedStatement.setString(5, zerbitzua.getText());
                    
                    preparedStatement.setString(6, NAN.getText()); 
                     
               
            
                     
                     int affectedRows = preparedStatement.executeUpdate();
	                    if (affectedRows > 0) {
	                        System.out.println("Erabiltzailea ezabatuta dago.");
	                    } else {
	                        System.out.println("Erabiltzailea ez da topatu.");
	                    }
	                    preparedStatement.close();

		            
		        } catch (SQLException e1) {
		            System.err.println("Errorea erabiltzailea aldatzerakoan: " + e1.getMessage());
		        }
            }
		}
	}

	public static void Gehitu(JTextField telZenbakia, JTextField NAN, JTextField izena, JTextField hornitzaileMota,
			JTextField helbidea, JTextField zerbitzua) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {	                
			 try {
		            String sql = "INSERT INTO hornitzaileformulario (TelZenbakia, Izena, NAN, HornitzaileMota, Helbidea, Zerbitzua) VALUES (?, ?, ?, ?, ?, ?)";
		            
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            
		            preparedStatement.setString(1, telZenbakia.getText());
		            
		            preparedStatement.setString(2, izena.getText());
		            
		            preparedStatement.setString(3, NAN.getText()); 
		            
		            preparedStatement.setString(4, hornitzaileMota.getText());
		            
                    preparedStatement.setString(5, helbidea.getText()); 
                    
                    preparedStatement.setString(6, zerbitzua.getText());
                    
                    
                     
               
            
                     
                     int affectedRows = preparedStatement.executeUpdate();
	                    if (affectedRows > 0) {
	                        System.out.println("Erabiltzailea ezabatuta dago.");
	                    } else {
	                        System.out.println("Erabiltzailea ez da topatu.");
	                    }
	                    preparedStatement.close();

		            
		        } catch (SQLException e1) {
		            System.err.println("Errorea erabiltzailea aldatzerakoan: " + e1.getMessage());
		        }
            }
		}
	}
	
}

