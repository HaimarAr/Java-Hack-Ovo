package Langileak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

import Conexion.Conexion;

public class Querya {

	public static void Borratu(JTextField id) {
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {
            	try {
                    String sql = "DELETE FROM langileak WHERE NAN=?";
                    
           		                    
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

	public static void Update(JTextField izena, JTextField NAN, JTextField abizena,
			JTextField email, JTextField telefonoa,JTextField helbidea, JTextField pK, JTextField postua, JTextField jaiotzeData, JTextField kK) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {	                
			 try {
		            String sql = "UPDATE langileak SET izena=? , abizena=? , email=?, telefonoa=?, helbidea=?, PK=?, postua=?, jaiotzeData=?, KK=? WHERE NAN=?";
		            
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);		          
		            
		            preparedStatement.setString(1, izena.getText());
		            
		            preparedStatement.setString(2, abizena.getText()); 
		            
		            preparedStatement.setString(3, email.getText());
		            
                    preparedStatement.setString(4, telefonoa.getText()); 
                    
                    preparedStatement.setString(5, helbidea.getText());
                    
                    preparedStatement.setString(6, pK.getText());
                    
                    preparedStatement.setString(7, postua.getText());
                    
                    preparedStatement.setString(8, jaiotzeData.getText());
                    
                    preparedStatement.setString(9, kK.getText()); 
                    
                    preparedStatement.setString(10, NAN.getText()); 
                     
               
            
                     
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

	public static void Gehitu(JTextField izena, JTextField NAN, JTextField abizena, JTextField email,
			JTextField telefonoa, JTextField helbidea, JTextField PK, JTextField postua,JTextField jaiotzeData, JTextField KK) throws SQLException {
		// TODO Auto-generated method stub izena, NAN, abizena, email, telefonoa, helbidea, PK, postua, KK 
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {	                
			 try {
		            String sql = "INSERT INTO langileak (NAN, izena, abizena, email, telefonoa, helbidea, PK, postua, jaiotzeData, KK) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		            
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            
		            preparedStatement.setString(1, NAN.getText());
		            
		            preparedStatement.setString(2, izena.getText());
		            
		            preparedStatement.setString(3, abizena.getText()); 
		            
		            preparedStatement.setString(4, email.getText());
		            
                    preparedStatement.setString(5, telefonoa.getText()); 
                    
                    preparedStatement.setString(6, helbidea.getText());
                    
                    preparedStatement.setString(7, PK.getText());
                    
                    preparedStatement.setString(8, postua.getText());
                    
                    preparedStatement.setString(9, jaiotzeData.getText());
                    
                    preparedStatement.setString(10, KK.getText());
                     
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
