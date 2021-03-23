package GUI;

import Starter.Controller;
import entita.Procuratori;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class M_CercaProcuratore extends JFrame {
    
	Controller controller;
 
	private JPanel contentPane;
	private JComboBox<String> CercaProcuratore_CO;
	
	TextField TF = new TextField();

	

	/**
	 * Create the frame.
	 */
	
	public M_CercaProcuratore(Controller c) {
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 174);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CercaProcuratore_L = new JLabel("Cerca un procuratore");
		CercaProcuratore_L.setFont(new Font("Verdana", Font.PLAIN, 18));
		CercaProcuratore_L.setBounds(105, 11, 192, 45);
		contentPane.add(CercaProcuratore_L);
		
		JButton CercaProcuratore_B = new JButton("Cerca");
		CercaProcuratore_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Apre GestioneProcuratore con i dati del procuratore inserito
				try {
				controller.VisualizzaInfoProcuratore((String) CercaProcuratore_CO.getSelectedItem());
				
				
				}catch (SQLException e3) {
					
					controller.ErroreLetturaDatabase();
					e3.printStackTrace();
				}
			}
		});
		
		CercaProcuratore_B.setBounds(329, 101, 69, 23);
		contentPane.add(CercaProcuratore_B);
		
		
	    CercaProcuratore_CO = new JComboBox <String>();
		CercaProcuratore_CO.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CercaProcuratore_CO.setBounds(85, 67, 234, 23);
		contentPane.add(CercaProcuratore_CO);
		
		
		
	}
	
	public void setProcuratoriComboBox (List<String> procuratori) {
		Iterator<String> i = procuratori.iterator();
		while (i.hasNext()) {
		     CercaProcuratore_CO.addItem(i.next()); 
		}
	}
	
	
  
}
