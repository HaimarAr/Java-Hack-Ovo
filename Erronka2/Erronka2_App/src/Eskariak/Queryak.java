package Eskariak;

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
                    String sql = "DELETE FROM eskariak WHERE id_eskaria=?";
                    
           		                    
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

	public static void Update(JTextField id) throws SQLException {
		// TODO Auto-generated method stub
		try (Connection connection = Conexion.dbConexioa()) {
            if (connection != null) {	                
			 try {
		            String sql = "UPDATE hackovo.eskariak SET egoera='onartuta'  WHERE id_eskaria=?";
		            PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            
		            
                     preparedStatement.setString(1, id.getText());
                     
                     
                     int affectedRows = preparedStatement.executeUpdate();
	                    if (affectedRows > 0) {
	                        System.out.println("Erabiltzailea ezabatuta dago.");
	                    } else {
	                        System.out.println("Erabiltzailea ez da topatu.");
	                    }
	                    preparedStatement.close();

	                    String sql2 = "UPDATE hackovo.almazena SET kantitatea=''  WHERE id_eskaria=?";
			            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			            
			            
	                     preparedStatement2.setString(1, id.getText());
	                     
	                     
	                     int affectedRows2 = preparedStatement.executeUpdate();
		                    if (affectedRows2 > 0) {
		                        System.out.println("Erabiltzailea ezabatuta dago.");
		                    } else {
		                        System.out.println("Erabiltzailea ez da topatu.");
		                    }
		                    preparedStatement2.close();
		                    
		        } catch (SQLException e1) {
		            System.err.println("Errorea erabiltzailea aldatzerakoan: " + e1.getMessage());
		        }
            }
		}
	}

	
	
	
}

