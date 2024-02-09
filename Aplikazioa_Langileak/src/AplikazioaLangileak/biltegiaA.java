package AplikazioaLangileak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class biltegiaA extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					biltegiaA frame = new biltegiaA();
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
	public biltegiaA() {
		setBackground(new Color(2, 46, 72));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 629);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 46, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 122, 626, 19);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(222, 152, 96, 19);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(328, 152, 96, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(434, 152, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(540, 152, 96, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(646, 152, 96, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(752, 152, 96, 19);
		contentPane.add(textField_5);
		
		
		
		btnNewButton = new JButton("Aldatu\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.6.1:3306/reborn", "usuarioa", "@1WMg2023")) {
		            if (connection != null) {	                
					 try {
				            String sql = "UPDATE reborn.biltegia SET Produktua=? , Deskribapena=? , Stock=? , Stock_kantitatea=? , Produktuaren_KG=? WHERE id=?";
				            PreparedStatement preparedStatement = connection.prepareStatement(sql);
				            preparedStatement.setString(1, textField.getText());
				            preparedStatement.setString(2, textField_2.getText());
				            int Stock = Integer.parseInt(textField_3.getText());
				            preparedStatement.setInt(3, Stock);
				            int Stock_kantitatea = Integer.parseInt(textField_4.getText());
		                     preparedStatement.setInt(4, Stock_kantitatea);
		                     int Produktuaren_KG = Integer.parseInt(textField_5.getText());
		                     preparedStatement.setInt(5, Produktuaren_KG);
		                     int id = Integer.parseInt(textField_1.getText());
		                     preparedStatement.setInt(6, id);
		                     
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
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		}		
		});
		btnNewButton.setForeground(new Color(255, 128, 0));
		btnNewButton.setBounds(222, 213, 626, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Atzera");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				dispose();
				pan1.main(null);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 128, 0));
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Komillen artean jarri");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setBounds(222, 179, 96, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblKomillenArteanJarri = new JLabel("Komillen artean jarri");
		lblKomillenArteanJarri.setForeground(new Color(255, 128, 0));
		lblKomillenArteanJarri.setBounds(434, 181, 96, 24);
		contentPane.add(lblKomillenArteanJarri);
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reborn", "usuarioa", "@1WMG2023")) {
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
		
		//String rutaImagen = "/AplikazioaLangileak/rebornIcon.png"; // Ajusta el nombre de la imagen según el que tengas en la carpeta "bin"
		
		// Luego, puedes usar la ruta relativa al recurso de la siguiente manera:
			//java.net.URL url = getClass().getResource(rutaImagen);
			
			//setIconImage(Toolkit.getDefaultToolkit().getImage(url));
		
	}
}
