package AplikazioaLangileak;

import java.awt.EventQueue;
import AplikazioaLangileak.MySQLConexion;
import AplikazioaLangileak.mainPantaila;

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

public class pan2 extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable table;
	public static final String DB_URL = "jdbc:mysql://192.168.6.1:3306/reborn";
	public static final String DB_USER = "usuarioa";
	public static final String DB_PASSWORD = "@1WMg2023";
	private JTextField textFieldBetween;
	private JTextField textFieldColumn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, int permiso) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pan2 frame = new pan2(permiso);
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
	public pan2(int permiso) {
	
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
		DatuBasea.setModel(new DefaultComboBoxModel(new String[] {"biltegia", "langileak", "hornitzailea", "bezeroa", "logistika"}));
		DatuBasea.setBackground(new Color(255, 255, 255));
		DatuBasea.setToolTipText("DatuBasea");
		contentPane.add(DatuBasea);
		
		
		
		JLabel lblNewLabel = new JLabel("Taulak :");
		lblNewLabel.setBounds(10, 14, 57, 17);
		lblNewLabel.setForeground(new Color(255, 128, 0));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Taula erakutsi");
		btnNewButton.setBounds(156, 12, 120, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
			            if (connection != null) {
			            	
			                String value= DatuBasea.getSelectedItem().toString();
			                MySQLConexion.erabiltzaileZerrendaErakutsi(connection, value, table);
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
					pan1.main(null);

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
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
			            if (connection != null) {
			            
			                String value= DatuBasea.getSelectedItem().toString();
			                MySQLConexion.taulabetween(connection, value, table, textFieldBetween, textFieldColumn);
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
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
			            if (connection != null) {
			            
			                String value= DatuBasea.getSelectedItem().toString();
			                MySQLConexion.taulain(connection, value, table, textFieldBetween, textFieldColumn);
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
				
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
			            if (connection != null) {
			            
			                String value= DatuBasea.getSelectedItem().toString();
			                MySQLConexion.taulaasc(connection, value, table, textFieldBetween, textFieldColumn);
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

				try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
			            if (connection != null) {
			            
			                String value= DatuBasea.getSelectedItem().toString();
			                MySQLConexion.tauladesc(connection, value, table, textFieldBetween, textFieldColumn);
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
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
			            if (connection != null) {
			            
			                String value= DatuBasea.getSelectedItem().toString();
			                MySQLConexion.taulacount(connection, value, table, textFieldBetween, textFieldColumn);
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
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
		            if (connection != null) {
		            
		                String value= DatuBasea.getSelectedItem().toString();
		                MySQLConexion.taulalike(connection, value, table, textFieldBetween, textFieldColumn);
		        }
			} catch (SQLException a) {
	            System.err.println("Errorea datu basearekin konexioa egiten: " + a.getMessage());
	        }
			}
		});
		btnNewButton_5.setForeground(new Color(255, 128, 0));
		btnNewButton_5.setBounds(651, 244, 71, 21);
		contentPane.add(btnNewButton_5);
		
		//String rutaImagen = "/AplikazioaLangileak/rebornIcon.png"; // Ajusta el nombre de la imagen según el que tengas en la carpeta "bin"
		
		// Luego, puedes usar la ruta relativa al recurso de la siguiente manera:
		//java.net.URL url = getClass().getResource(rutaImagen);
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage(url));
			
		
	}
}
