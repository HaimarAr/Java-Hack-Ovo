package Gehitu;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Conexion.Conexion;
import Taulak.Taulak;

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

public class GehituLangileak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GehituLangileak frame = new GehituLangileak();
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
	public GehituLangileak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 46, 72));
		contentPane.setForeground(new Color(255, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
	
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 167, 626, 20);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(150, 197, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(256, 197, 96, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(362, 197, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(468, 197, 96, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(574, 197, 96, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(680, 197, 96, 19);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Gehitu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
		            if (connection != null) {
		            	
		            	 try {
		                     String sql = "INSERT INTO biltegia (Produktua, id, Deskribapena, Stock, Stock_kantitatea, Produktuaren_KG) VALUES (?, ?, ?, ?, ?, ?)";
		            		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
		                     preparedStatement.setString(1, textField.getText());
		                     
		                     int id = Integer.parseInt(textField_1.getText());
		            
		                     preparedStatement.setInt(2, id);
		                     
		                    
		                     preparedStatement.setString(3, textField_2.getText());		                     
		                     preparedStatement.setString(4, textField_3.getText());
		                     int Stock_kantitatea = Integer.parseInt(textField_4.getText());
		                     preparedStatement.setInt(5, Stock_kantitatea);
		                     int Produktuaren_KG = Integer.parseInt(textField_5.getText());
		                     preparedStatement.setInt(6, Produktuaren_KG);
		                     
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

		});
		btnNewButton.setForeground(new Color(255, 128, 0));
		btnNewButton.setBounds(150, 258, 626, 21);
		contentPane.add(btnNewButton);
		
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
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
	            if (connection != null) {
	            	
	            	
					DefaultTableModel taula = new DefaultTableModel();
					
					taula.addColumn("Produktua");
				    taula.addColumn("id");
				    taula.addColumn("Deskribapena");
				    taula.addColumn("Stock");
				    taula.addColumn("Stock_kantitatea");
				    taula.addColumn("Produktuaren_KG");

				   
	        	    
	        	    String[] array = new String[6];
	        	    
	        	    table.setModel(taula);
	        }
		} catch (SQLException a) {
	        System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
	    }
				
		JButton btnNewButton_6 = new JButton("Hasiera");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Taulak.main(1);
			}
		});
		btnNewButton_6.setBounds(201, 10, 85, 21);
		contentPane.add(btnNewButton_6);
	}
}
