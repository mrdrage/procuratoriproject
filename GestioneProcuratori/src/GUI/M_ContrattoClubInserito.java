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

public class M_ContrattoClubInserito extends JDialog {
	Controller controller = null;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public M_ContrattoClubInserito(Controller c) {
		controller = c;
		
		setBounds(100, 100, 501, 148);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 235, 215));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ContrattoClubInserito_L = new JLabel("Contratto Club inserito correttamente.");
			ContrattoClubInserito_L.setHorizontalAlignment(SwingConstants.CENTER);
			ContrattoClubInserito_L.setFont(new Font("Verdana", Font.PLAIN, 24));
			ContrattoClubInserito_L.setBounds(10, 11, 465, 61);
			contentPanel.add(ContrattoClubInserito_L);
		}
		{
			JButton Ok_B = new JButton("Ok");
			Ok_B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.tornaGestioneProcuratoreIndietro();
					setVisible(false);
				}
			});
			Ok_B.setBackground(Color.WHITE);
			Ok_B.setBounds(420, 75, 55, 23);
			contentPanel.add(Ok_B);
		}
	}

}
