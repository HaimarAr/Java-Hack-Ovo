package Faktura;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;
import Menu.funtzioak;
import Taulak.Filtratu;
import Taulak.Taulak;
import Faktura.Joina;

public class Faktura extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable table;
	public static JTextField textFieldBetween;
	public static JTextField textFieldColumn;
	public static String value = "faktura";
	private JTextField id = new JTextField();
	public static DefaultTableModel taula = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String value) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faktura frame = new Faktura(value);
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
	public Faktura(String value) {
setTitle("Hack-Ovo");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 46, 72));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Taula erakutsi");
		btnNewButton.setBounds(59, 12, 120, 21);
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
		
		JButton Join = new JButton("Faktura osoa ikusi");
		Join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
		            if (connection != null) {
		            	Joina.JoinaEgin(id, connection, table, taula);
		            }
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Join.setBounds(651, 392, 181, 21);
		contentPane.add(Join);
		
		id = new JTextField();
		id.setBounds(651, 363, 181, 19);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton Pdf = new JButton("Pdf-a sortu");
		Pdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
		            if (connection != null) {
		            	Joina.PdfSortu(id, connection, table, taula);
		            }
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Pdf.setBounds(59, 423, 85, 21);
		contentPane.add(Pdf);
		
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
