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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_ContrattoSponsorInserito extends JDialog {
	
	Controller controller;

	private final JPanel contentPanel = new JPanel();

	
	/**
	 * Create the dialog.
	 */
	
	public M_ContrattoSponsorInserito(Controller c) {
		setResizable(false);
		
		controller = c;
		
		setBounds(100, 100, 549, 152);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 235, 215));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ContrattoSponsorInserito_L = new JLabel("Contratto Sponsor inserito correttamente.");
			ContrattoSponsorInserito_L.setFont(new Font("Verdana", Font.PLAIN, 24));
			ContrattoSponsorInserito_L.setBounds(10, 11, 502, 58);
			contentPanel.add(ContrattoSponsorInserito_L);
		}
		{
			JButton Ok_B = new JButton("Ok");
			Ok_B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.TornaASelezionaAtletaContratto();
					setVisible(false);
				}
			});
			
			Ok_B.setBackground(Color.WHITE);
			Ok_B.setBounds(458, 80, 54, 23);
			contentPanel.add(Ok_B);
		}
	}

}
