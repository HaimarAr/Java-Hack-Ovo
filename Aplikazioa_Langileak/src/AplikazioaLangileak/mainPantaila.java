package AplikazioaLangileak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Toolkit;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;

public class mainPantaila extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPasswordField txtPasa;
	public String usuario = new String();
	public String pasahitza = new String();
	public String permiso = "1";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainPantaila frame = new mainPantaila();
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
	public mainPantaila() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1166, 633);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 46, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitza:");
		lblNewLabel_1.setBounds(234, 269, 127, 46);
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setBackground(Color.ORANGE);
		contentPane.add(lblNewLabel_1);
		
		
		txtPasa = new JPasswordField();
		txtPasa.setBounds(335, 269, 184, 46);
		contentPane.add(txtPasa);
		
		JLabel lblNewLabel = new JLabel("Erabiltzailea:");
		lblNewLabel.setBounds(232, 213, 129, 46);
		lblNewLabel.setForeground(new Color(255, 128, 0));
		contentPane.add(lblNewLabel);
		
		JTextPane txtErabil = new JTextPane();
		txtErabil.setToolTipText("");
		txtErabil.setBounds(335, 213, 184, 46);
		contentPane.add(txtErabil);
		
		
		
		JButton btnNewButton = new JButton("Sartu");
		btnNewButton.setBounds(234, 357, 285, 59);
		btnNewButton.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
			            if (connection != null) {
			               
							
							String izena = txtErabil.getText();
							String pasahitza = txtPasa.getText();
							Statement stat=connection.createStatement();   
				    	    ResultSet res=stat.executeQuery("select * from usuarios;");
				    	    ResultSetMetaData rsmd = res.getMetaData();
				    	 
							Baimenak(connection, izena, pasahitza, res);
							dispose();
			            }	
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				private void Baimenak(Connection connection, String izena, String pasahitza, ResultSet res) {
					// TODO Auto-generated method stub
					DefaultTableModel taula = new DefaultTableModel();
					taula.addColumn("Id");
				    taula.addColumn("Usuario");
				    taula.addColumn("Contraseña");
				    taula.addColumn("Permiso");
				    
					 String[] array = new String[4];
					 
					
					    try {
							while(res.next())
							{
								
								    array[1] = res.getString(1 + 1);
								    array[2] = res.getString(2 + 1);
								    array[3] = res.getString(3 + 1);
								    
								if(izena.equals(array[1]) && pasahitza.equals(array[2]) && array[3].equals(permiso)) {
									setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
									pan2.main(null,1);
									
									break;
									
								}else if(izena.equals(array[1]) && pasahitza.equals(array[2]) && array[3] != permiso) {
									setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
									pan2.main(null,0);
									break;
								}
								
							}
							
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					   
				}
				
			});
		
			//String rutaImagen = "/AplikazioaLangileak/rebornIcon.png"; // Ajusta el nombre de la imagen según el que tengas en la carpeta "bin"
			
		// Luego, puedes usar la ruta relativa al recurso de la siguiente manera:
			//java.net.URL url = getClass().getResource(rutaImagen);
			
			//setIconImage(Toolkit.getDefaultToolkit().getImage(url));

			btnNewButton.setForeground(new Color(255, 128, 0));
			contentPane.add(btnNewButton);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon());
			lblNewLabel_2.setBounds(671, 84, 423, 417);
			contentPane.add(lblNewLabel_2);
	
			
		}
	}
