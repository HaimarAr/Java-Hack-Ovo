package Main;

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
import Main.funtzioak;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;

public class sarrera extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPasswordField txtPasa;
	public Langilea data = new Langilea(new String(), new String(), "1");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sarrera frame = new sarrera();
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
	public sarrera() {
		
		
		
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
					
					if(Main.funtzioak.sartu(txtPasa.getText(), txtErabil.getText()) == 1) {
						setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						dispose();
					}
				}
				
			});

			btnNewButton.setForeground(new Color(255, 128, 0));
			contentPane.add(btnNewButton);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon());
			lblNewLabel_2.setBounds(671, 84, 423, 417);
			contentPane.add(lblNewLabel_2);
	
			
		}
	}

