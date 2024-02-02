package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import Conexion.Conexion;
import Menu.funtzioak;
import Taulak.Taulak;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class Menu extends JFrame {

	private static final int Aldatu = 3;
	private static final int Gehitu = 2;
	private static final int Kendu = 1;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Reborn (Edit)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(2, 46, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		comboBox.setForeground(new Color(255, 128, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"almazena", "usuarios", "langileak"}));
		comboBox.setBounds(572, 168, 181, 38);
		contentPane.add(comboBox);
		
		String value= comboBox.getSelectedItem().toString();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Kendu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					 
					setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					dispose();
					funtzioak.aukeratu(value, Kendu);
					
						
			    		
		    	    
		    	  
			}
		});
		btnNewButton.setForeground(new Color(255, 128, 0));
		btnNewButton.setBounds(75, 155, 422, 64);
		contentPane.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Gehitu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						 setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						dispose();
						funtzioak.aukeratu(value, Gehitu);
		        }
				
			});		
		btnNewButton_1.setForeground(new Color(255, 128, 0));
		btnNewButton_1.setBounds(75, 84, 422, 61);
		contentPane.add(btnNewButton_1);
		
		JButton btnAldatu = new JButton("Aldatu");
		btnAldatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					
					setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					dispose();
					funtzioak.aukeratu(value, Aldatu);
					
						
			    		
		    
		    	    
			}
		});
		btnAldatu.setForeground(new Color(255, 128, 0));
		btnAldatu.setBounds(75, 229, 422, 64);
		contentPane.add(btnAldatu);
		
		JButton btnNewButton_2 = new JButton("Atzera");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				dispose();
				Taulak.main(1);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 128, 0));
		btnNewButton_2.setBounds(47, 23, 85, 21);
		contentPane.add(btnNewButton_2);
		
		
			
		
		
	}
}
