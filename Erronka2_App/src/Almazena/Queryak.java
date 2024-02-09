package Almazena;

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
                    String sql = "DELETE FROM almazena WHERE ErregistroID=?";
                    
           		                    
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    int id2 = Integer.parseInt(id.getText());
                    preparedStatement.setInt(1, id2);
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

	public static void Update(JTextField izena, JTextField id, JTextField kantitatea, JTextField modeloa, JTextField marka, JTextField prezioaE, JTextField prezioaS, JTextField berria, JTextField Irudia, JTextField balorazioa ) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {	                
			 try {
		            String sql = "UPDATE hackovo.almazena SET izena=? , kantitatea=? , modeloa=? , marka=?, prezioaE=? , prezioaS=? , berria=?, Irudia=?, balorazioa=? WHERE ErregistroID=?";
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            
		            preparedStatement.setString(1, izena.getText());
		            
		            int kantitatea1 = Integer.parseInt(kantitatea.getText());
		            preparedStatement.setInt(2, kantitatea1);
		            
		            preparedStatement.setString(3, modeloa.getText());
		            
		            preparedStatement.setString(4, marka.getText());
		            
		            int prezioaE1 = Integer.parseInt(prezioaE.getText());
                     preparedStatement.setInt(5, prezioaE1);
                     
                     int prezioaS1 = Integer.parseInt(prezioaS.getText());
                     preparedStatement.setInt(6, prezioaS1); 
                     
                     int berria1 = Integer.parseInt(berria.getText());
                     preparedStatement.setInt(7, berria1); 
                     
                    
                     preparedStatement.setString(8, Irudia.getText()); 
                     
                     int balorazioa1 = Integer.parseInt(balorazioa.getText());
                     preparedStatement.setInt(9, balorazioa1); 
                     
                     preparedStatement.setString(10, id.getText());
                     
                     
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

	public static void Gehitu(JTextField izena, JTextField id, JTextField kantitatea, JTextField modeloa, JTextField marka, JTextField prezioaE, JTextField prezioaS, JTextField berria, JTextField Irudia, JTextField balorazioa) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {	                
			 try {
                 	String sql = "INSERT INTO almazena (ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS, berria, Irudia, balorazioa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            

                    preparedStatement.setString(1, id.getText());
                    
		            preparedStatement.setString(2, izena.getText());
		            
		            int kantitatea1 = Integer.parseInt(kantitatea.getText());
		            preparedStatement.setInt(3, kantitatea1);
		            
		            preparedStatement.setString(4, modeloa.getText());
		            
		            preparedStatement.setString(5, marka.getText());
		            
		            int prezioaE1 = Integer.parseInt(prezioaE.getText());
                     preparedStatement.setInt(6, prezioaE1);
                     
                     int prezioaS1 = Integer.parseInt(prezioaS.getText());
                     preparedStatement.setInt(7, prezioaS1); 
                     
                     int berria1 = Integer.parseInt(berria.getText());
                     preparedStatement.setInt(8, berria1); 
                     
                    
                     preparedStatement.setString(9, Irudia.getText()); 
                     
                     int balorazioa1 = Integer.parseInt(balorazioa.getText());
                     preparedStatement.setInt(10, balorazioa1); 
                                     
                     
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

