package GUI;

import Starter.Controller;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class M_Benvenuto extends JFrame {

	Controller controller;

	private JPanel contentPane;
	
	

	/**
	 * Create the frame.
	 */
	
	public M_Benvenuto(Controller c) {
		setResizable(false);
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 224);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Benvenuto_L = new JLabel("Benvenuto !");
		Benvenuto_L.setHorizontalAlignment(SwingConstants.CENTER);
		Benvenuto_L.setFont(new Font("Verdana", Font.PLAIN, 25));
		Benvenuto_L.setBounds(10, 11, 325, 47);
		contentPane.add(Benvenuto_L);
		
		JButton InserisciProcuratore_B = new JButton("Inserisci Procuratore");
		InserisciProcuratore_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
     			controller.IniziaInserimentoProcuratore();
    
			}
		});
		
		InserisciProcuratore_B.setToolTipText("");
		InserisciProcuratore_B.setForeground(new Color(0, 0, 0));
		InserisciProcuratore_B.setFont(new Font("Tahoma", Font.PLAIN, 11));
		InserisciProcuratore_B.setBackground(new Color(255, 255, 255));
		InserisciProcuratore_B.setBounds(78, 72, 179, 32);
		contentPane.add(InserisciProcuratore_B);
		
		JButton CercaProcuratore_B = new JButton("Cerca procuratore");
		CercaProcuratore_B.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CercaProcuratore_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Caricare tutti i procuratori nella combobox
				try {
				    controller.RicercaProcuratori();
				    
			    }catch(SQLException E) {
			    	
				   controller.ErroreLetturaDatabase();
				   E.printStackTrace();
			    }
 			}
		});
		
		CercaProcuratore_B.setBackground(new Color(255, 255, 255));
		CercaProcuratore_B.setBounds(78, 113, 179, 32);
		contentPane.add(CercaProcuratore_B);
		
		
		
	}
}


