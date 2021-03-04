import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class M_ContrattoClubInserito extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public M_ContrattoClubInserito() {
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
			Ok_B.setBackground(new Color(0, 0, 0));
			Ok_B.setBounds(430, 83, 45, 23);
			contentPanel.add(Ok_B);
		}
	}

}
