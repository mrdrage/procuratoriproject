package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class M_ErroreDataInserita extends JDialog {
	
	Controller controller;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	
	public M_ErroreDataInserita(Controller c) {
		
		controller = c;
		
		setType(Type.POPUP);
		setAlwaysOnTop(true);
		
		setBounds(100, 100, 450, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 235, 215));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ErroreDataInserita_L = new JLabel("Le date inserite non sono corrette.");
			ErroreDataInserita_L.setHorizontalAlignment(SwingConstants.CENTER);
			ErroreDataInserita_L.setFont(new Font("Verdana", Font.PLAIN, 23));
			ErroreDataInserita_L.setBounds(0, -11, 434, 72);
			contentPanel.add(ErroreDataInserita_L);
		}
		{
			JButton Ok_B = new JButton("Ok");
			Ok_B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					setVisible(false);
				}
			});
			
			Ok_B.setBounds(379, 68, 45, 23);
			contentPanel.add(Ok_B);
		}
	}

}
