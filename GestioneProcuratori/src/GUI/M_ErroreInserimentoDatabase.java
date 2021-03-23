package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_ErroreInserimentoDatabase extends JDialog {
    
    Controller controller;
     
	private final JPanel contentPanel = new JPanel();
   
	
	/**
	 * Create the dialog.
	 */
	
	public M_ErroreInserimentoDatabase(Controller c) {
		setResizable(false);
		setAlwaysOnTop(true);
		controller = c;
		setBounds(100, 100, 412, 157);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ErroreDatabase_L = new JLabel("Attenzione, inserimento errato.");
			ErroreDatabase_L.setHorizontalAlignment(SwingConstants.CENTER);
			ErroreDatabase_L.setFont(new Font("Verdana", Font.PLAIN, 20));
			ErroreDatabase_L.setBounds(10, 0, 376, 50);
			contentPanel.add(ErroreDatabase_L);
		}
		{
			JButton Ok_B = new JButton("Ok");
			Ok_B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			
			Ok_B.setBackground(Color.WHITE);
			Ok_B.setBounds(332, 84, 54, 23);
			contentPanel.add(Ok_B);
		}
		
		JLabel ErroreDatabase1_L = new JLabel("Controlla i dati e riprova.");
		ErroreDatabase1_L.setHorizontalAlignment(SwingConstants.CENTER);
		ErroreDatabase1_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ErroreDatabase1_L.setBounds(10, 44, 376, 23);
		contentPanel.add(ErroreDatabase1_L);
	}
}
