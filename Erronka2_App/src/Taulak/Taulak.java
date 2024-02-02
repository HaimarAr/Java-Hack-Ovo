package Taulak;

import java.awt.EventQueue;
import Conexion.Conexion;
import Menu.Menu;

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

public class Taulak extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable table;
	public static JTextField textFieldBetween;
	public static JTextField textFieldColumn;
	
	/**
	 * Launch the application.
	 */
	public static void main(int permiso) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taulak frame = new Taulak(permiso);
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
	public Taulak(int permiso) {
	
		setTitle("Reborn");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 563);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 46, 72));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox DatuBasea = new JComboBox();
		DatuBasea.setBounds(59, 12, 87, 21);
		DatuBasea.setForeground(new Color(255, 128, 0));
		DatuBasea.setModel(new DefaultComboBoxModel(new String[] {"almazena", "bezeroak", "eskariak", "faktura", "hornitzaileformulario", "langileak"}));
		DatuBasea.setBackground(new Color(255, 255, 255));
		DatuBasea.setToolTipText("DatuBasea");
		contentPane.add(DatuBasea);
		
		
		
		JLabel lblNewLabel = new JLabel("Taulak:");
		lblNewLabel.setBounds(10, 14, 57, 17);
		lblNewLabel.setForeground(new Color(255, 128, 0));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Taula erakutsi");
		btnNewButton.setBounds(156, 12, 120, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = Conexion.dbConexioa()) {
			            if (connection != null) {
			            	
			                String value= DatuBasea.getSelectedItem().toString();
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
		
		JButton edit = new JButton("Editatu");
		edit.setBounds(231, 453, 200, 62);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(permiso == 1) {
					
					setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					dispose();
					Menu.main();

				}else {
					JOptionPane.showMessageDialog(null, "Ez daukazu baimenik datuak editatzeko");
				}
			}
		});
		edit.setForeground(new Color(255, 128, 0));
		contentPane.add(edit);
		
		JButton between = new JButton("Between");
		between.setForeground(new Color(255, 128, 0));
		between.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection(Conexion.DB_URL, Conexion.DB_USER, Conexion.DB_PASSWORD)) {
			            if (connection != null) {
			            
			                String value= DatuBasea.getSelectedItem().toString();
			                
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
			            
			                String value= DatuBasea.getSelectedItem().toString();
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
			            
			                String value= DatuBasea.getSelectedItem().toString();
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
			            
			                String value= DatuBasea.getSelectedItem().toString();
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
			            
			                String value= DatuBasea.getSelectedItem().toString();
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
		            
		                String value= DatuBasea.getSelectedItem().toString();
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
				
	}
}
