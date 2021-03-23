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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_ErroreLetturaDatabase extends JDialog {
	
	Controller contoller;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public M_ErroreLetturaDatabase(Controller c) {
		setResizable(false);
		
		contoller = c;
		
		setBounds(100, 100, 450, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel ErroreDatabase_L = new JLabel("Errore Database");
		ErroreDatabase_L.setHorizontalAlignment(SwingConstants.CENTER);
		ErroreDatabase_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ErroreDatabase_L.setBounds(10, 21, 417, 38);
		contentPanel.add(ErroreDatabase_L);
		
		JLabel ErroreDatabase1_L = new JLabel("Si \u00E9 verificato un errore durante la lettura dei dati, riprovare");
		ErroreDatabase1_L.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ErroreDatabase1_L.setBounds(10, 67, 417, 72);
		contentPanel.add(ErroreDatabase1_L);
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(365, 150, 59, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
	}
}
