package Almazena;

import java.awt.EventQueue;
import Conexion.Conexion;
import Menu.funtzioak;
import Almazena.Queryak;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Button;
import Taulak.Filtratu;

public class Almazena extends JFrame {

	public static final long serialVersionUID = 1L;
	protected static final String DatuBasea = null;
	public JPanel contentPane;
	public JTable table;
	public static JTextField textFieldBetween;
	public static JTextField textFieldColumn;
	public static JTextField id;
	public static String value = "almazena";
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String value) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almazena frame = new Almazena();
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
	public Almazena() {
	
		setTitle("Hack-Ovo");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 46, 72));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Taula erakutsi");
		btnNewButton.setBounds(59, 10, 120, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = Conexion.dbConexioa()) {
			            if (connection != null) {
			            	
			                
			                Filtratu.erabiltzaileZerrendaErakutsi(connection, value, table);
			        }
				} catch (SQLException a) {
		            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
		        }
			}
		});
		
		btnNewButton.setForeground(new Color(255, 128, 0));
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(59, 43, 556, 370);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(255, 128, 0));
		
		JButton between = new JButton("Between");
		between.setForeground(new Color(255, 128, 0));
		between.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
			            if (connection != null) {
			            
			                
			                
			                Filtratu.taulabetween(connection, value, table, textFieldBetween, textFieldColumn);
			        }
				} catch (SQLException a) {
		            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
		        }
			}
		});
		between.setBounds(651, 59, 71, 21);
		contentPane.add(between);
		
		textFieldBetween = new JTextField();
		textFieldBetween.setBounds(733, 91, 158, 19);
		contentPane.add(textFieldBetween);
		textFieldBetween.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("#### and ####");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setBounds(775, 63, 161, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldColumn = new JTextField();
		textFieldColumn.setColumns(10);
		textFieldColumn.setBounds(733, 33, 158, 19);
		contentPane.add(textFieldColumn);
		
		JButton btnNewButton_1 = new JButton("In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
			            if (connection != null) {
			            
			                
			                Filtratu.taulain(connection, value, table, textFieldBetween, textFieldColumn);
			        }
				} catch (SQLException a) {
		            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
		        }
			}
		});
		btnNewButton_1.setForeground(new Color(255, 128, 0));
		btnNewButton_1.setBounds(651, 120, 71, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Zutabea :");
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setBounds(651, 36, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Informazioa :");
		lblNewLabel_3.setForeground(new Color(255, 128, 0));
		lblNewLabel_3.setBounds(651, 94, 71, 13);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Asc");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
			            if (connection != null) {
			            
			                
			                Filtratu.taulaasc(connection, value, table, textFieldBetween, textFieldColumn);
			        }
				} catch (SQLException a) {
		            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
		        }
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 128, 0));
		btnNewButton_2.setBounds(651, 151, 71, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Desc");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
			            if (connection != null) {
			            
			                Filtratu.tauladesc(connection, value, table, textFieldBetween, textFieldColumn);
			        }
				} catch (SQLException a) {
		            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
		        }
			}
		});
		btnNewButton_3.setForeground(new Color(255, 128, 0));
		btnNewButton_3.setBounds(651, 182, 71, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Zutabea eta Taula aukeratu");
		lblNewLabel_4.setForeground(new Color(255, 128, 0));
		lblNewLabel_4.setBounds(738, 151, 153, 52);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("Count");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
			            if (connection != null) {
			            
			                Filtratu.taulacount(connection, value, table, textFieldBetween, textFieldColumn);
			        }
				} catch (SQLException a) {
		            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
		        }
			}
		});
		btnNewButton_4.setForeground(new Color(255, 128, 0));
		btnNewButton_4.setBounds(651, 213, 71, 21);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Like");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
		            if (connection != null) {
		            
		                Filtratu.taulalike(connection, value, table, textFieldBetween, textFieldColumn);
		        }
			} catch (SQLException a) {
	            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
	        }
			}
		});
		btnNewButton_5.setForeground(new Color(255, 128, 0));
		btnNewButton_5.setBounds(651, 244, 71, 21);
		contentPane.add(btnNewButton_5);
		
		JButton Kendu = new JButton("Kendu");
		Kendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Queryak.Borratu(id);
			}
		});
		Kendu.setBounds(806, 407, 85, 21);
		contentPane.add(Kendu);
		
		JLabel ID = new JLabel("ID:");
		ID.setForeground(new Color(255, 128, 64));
		ID.setBounds(651, 376, 96, 52);
		contentPane.add(ID);
		
		id = new JTextField();
		id.setBounds(675, 393, 96, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Queryak.Update(textField_1, id, textField_2, textField_3, textField_4, textField_5, textField, textField_6, textField_7, textField_8);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Update.setBounds(806, 361, 85, 21);
		contentPane.add(Update);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(59, 423, 97, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(166, 423, 38, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(214, 423, 30, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(254, 423, 55, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(319, 423, 45, 19);
		contentPane.add(textField_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(374, 423, 45, 19);
		contentPane.add(textField);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(429, 423, 21, 19);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(460, 423, 115, 19);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(585, 423, 30, 19);
		contentPane.add(textField_8);
		
		JButton Gehitu = new JButton("Gehitu");
		Gehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Queryak.Gehitu(textField_1, id, textField_2, textField_3, textField_4, textField_5, textField, textField_6, textField_7, textField_8);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Gehitu.setBounds(806, 448, 85, 21);
		contentPane.add(Gehitu);
				
		
		
	}
}
