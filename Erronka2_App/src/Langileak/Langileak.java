package Langileak;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Conexion.Conexion;
import Langileak.Querya;
import Taulak.Filtratu;
import Taulak.Taulak;

public class Langileak extends JFrame {

	public static final long serialVersionUID = 1L;
	protected static final String DatuBasea = null;
	public JPanel contentPane;
	public JTable table;
	public static JTextField textFieldBetween;
	public static JTextField textFieldColumn;
	public static JTextField NAN;
	public static String value = "langileak";
	private JTextField textField;
	private JTextField izena;
	private JTextField abizena;
	private JTextField email;
	private JTextField telefonoa;
	private JTextField helbidea;
	private JTextField PK;
	private JTextField postua;
	private JTextField jaiotzeData;
	private JTextField KK;

	/**
	 * Launch the application.
	 */
	public static void main(String value) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Langileak frame = new Langileak();
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
	public Langileak() {
		
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
		scrollPane.setBounds(59, 43, 582, 401);
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
		between.setBounds(675, 60, 71, 21);
		contentPane.add(between);
		
		textFieldBetween = new JTextField();
		textFieldBetween.setBounds(757, 91, 158, 19);
		contentPane.add(textFieldBetween);
		textFieldBetween.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("#### and ####");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setBounds(775, 63, 161, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldColumn = new JTextField();
		textFieldColumn.setColumns(10);
		textFieldColumn.setBounds(757, 34, 158, 19);
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
		btnNewButton_1.setBounds(675, 120, 71, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Zutabea :");
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setBounds(675, 37, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Informazioa :");
		lblNewLabel_3.setForeground(new Color(255, 128, 0));
		lblNewLabel_3.setBounds(675, 94, 71, 13);
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
		btnNewButton_2.setBounds(675, 151, 71, 21);
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
		btnNewButton_3.setBounds(675, 182, 71, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Zutabea eta Taula aukeratu");
		lblNewLabel_4.setForeground(new Color(255, 128, 0));
		lblNewLabel_4.setBounds(762, 151, 153, 52);
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
		btnNewButton_4.setBounds(675, 213, 71, 21);
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
		btnNewButton_5.setBounds(675, 244, 71, 21);
		contentPane.add(btnNewButton_5);
		
		JButton Kendu = new JButton("Kendu");
		Kendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Querya.Borratu(NAN);
			}
		});
		Kendu.setBounds(830, 392, 85, 21);
		contentPane.add(Kendu);
		
		JLabel ID = new JLabel("NAN:");
		ID.setForeground(new Color(255, 128, 64));
		ID.setBounds(661, 376, 120, 52);
		contentPane.add(ID);
		
		NAN = new JTextField();
		NAN.setBounds(699, 393, 96, 19);
		contentPane.add(NAN);
		NAN.setColumns(10);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Querya.Update(izena, NAN, abizena, email, telefonoa, helbidea, PK, postua,jaiotzeData, KK );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Update.setBounds(830, 361, 85, 21);
		contentPane.add(Update);
		
		JButton Gehitu = new JButton("Gehitu");
		Gehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Querya.Gehitu(izena, NAN, abizena, email, telefonoa, helbidea, PK, postua, jaiotzeData, KK );
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		Gehitu.setBounds(830, 423, 85, 21);
		contentPane.add(Gehitu);
			
		izena = new JTextField();
		izena.setColumns(10);
		izena.setBounds(109, 451, 45, 19);
		contentPane.add(izena);
		
		abizena = new JTextField();
		abizena.setColumns(10);
		abizena.setBounds(164, 451, 60, 19);
		contentPane.add(abizena);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(234, 451, 52, 19);
		contentPane.add(email);
		
		telefonoa = new JTextField();
		telefonoa.setColumns(10);
		telefonoa.setBounds(296, 451, 51, 19);
		contentPane.add(telefonoa);
		
		helbidea = new JTextField();
		helbidea.setColumns(10);
		helbidea.setBounds(357, 452, 39, 19);
		contentPane.add(helbidea);
		
		PK = new JTextField();
		PK.setColumns(10);
		PK.setBounds(406, 452, 57, 19);
		contentPane.add(PK);
		
		postua = new JTextField();
		postua.setColumns(10);
		postua.setBounds(473, 451, 53, 19);
		contentPane.add(postua);
		
		jaiotzeData = new JTextField();
		jaiotzeData.setColumns(10);
		jaiotzeData.setBounds(536, 451, 45, 19);
		contentPane.add(jaiotzeData);
		
		KK = new JTextField();
		KK.setColumns(10);
		KK.setBounds(596, 454, 45, 19);
		contentPane.add(KK);
		
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
