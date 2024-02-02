package Gehitu;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Conexion.Conexion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class GehituAlmazena extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GehituAlmazena frame = new GehituAlmazena();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GehituAlmazena() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 46, 72));
		contentPane.setForeground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 193, 630, 20);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(146, 238, 54, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(210, 238, 54, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(274, 238, 54, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(338, 238, 54, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(402, 238, 54, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(466, 238, 54, 19);
		contentPane.add(textField_5);
		
		JButton Gehitu = new JButton("Gehitu");
		Gehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = dbConexioa()) {
		            if (connection != null) {
		            	
		            	 try {
		                     String sql = "INSERT INTO alamazena (ErregistroID, izena, kantitatea, modeloa, marka, prezioaE, prezioaS, berria, Irudia, balorazioa) VALUES (?, ?, ?, ?, ?, ?)";
		            		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
		            		 	                              
		                     int id = Integer.parseInt(textField.getText());
		                     preparedStatement.setInt(1, id);
		                     
		                     preparedStatement.setString(2, textField_1.getText());	
		                     
		                     int kantitatea = Integer.parseInt(textField_2.getText());
		                     preparedStatement.setInt(3, kantitatea);
		                     
		                     preparedStatement.setString(4, textField_3.getText());
		                     
		                     preparedStatement.setString(5, textField_4.getText());
		                     
		                     
		                     Double prezioaE = Double.valueOf(textField_5.getText());
		                     preparedStatement.setDouble(6, prezioaE);
		                     
		                     Double prezioaS = Double.valueOf(textField_6.getText());
		                     preparedStatement.setDouble(7, prezioaS);
		                     
		                     
		                     
		                     int affectedRows = preparedStatement.executeUpdate();
		                     if (affectedRows > 0) {
		                         System.out.println("Erabiltzailea ongi gehitu da.");
		                     }
		                     preparedStatement.close();
		                 } catch (SQLException e1) {
		                     System.err.println("Errorea erabiltzaile berria gehitzerakoan: " + e1.getMessage());
		                 }
		        }
			} catch (SQLException a) {
	            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
	        }
				
			}

			public static Connection dbConexioa() throws SQLException {
				return DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD);
			}

		});
		Gehitu.setForeground(new Color(255, 128, 0));
		Gehitu.setBounds(146, 289, 630, 21);
		contentPane.add(Gehitu);
		
		JButton btnNewButton_1 = new JButton("Atzera\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				dispose();
				//pan1.main(null);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 128, 0));
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(530, 238, 54, 19);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(594, 238, 54, 19);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(658, 238, 54, 19);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(722, 238, 54, 19);
		contentPane.add(textField_9);
		
		JLabel lblNewLabel = new JLabel("ALMAZENA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(146, 126, 71, 57);
		contentPane.add(lblNewLabel);
		
		try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
	            if (connection != null) {
	            	
	            	
					DefaultTableModel taula = new DefaultTableModel();
					
					taula.addColumn("ErregistroID");
				    taula.addColumn("izena");
				    taula.addColumn("kantitatea");
				    taula.addColumn("modeloa");
				    taula.addColumn("marka");
				    taula.addColumn("prezioaE");
				    taula.addColumn("prezioaS");
				    taula.addColumn("berria");
				    taula.addColumn("Irudia");
				    taula.addColumn("balorazioa");
				   
	        	    
	        	    String[] array = new String[10];
	        	    
	        	    table.setModel(taula);
	        }
		} catch (SQLException a) {
	        System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
	    }
				

	}
}
