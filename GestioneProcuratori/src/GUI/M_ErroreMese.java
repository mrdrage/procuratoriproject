package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class M_ErroreMese extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public M_ErroreMese() {
		setBounds(100, 100, 450, 163);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 245, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ErroreMese_L = new JLabel("Il mese selezionato non ha prodotto risultati.");
			ErroreMese_L.setHorizontalAlignment(SwingConstants.CENTER);
			ErroreMese_L.setFont(new Font("Verdana", Font.PLAIN, 18));
			ErroreMese_L.setBounds(10, -14, 414, 102);
			contentPanel.add(ErroreMese_L);
		}
		{
			JButton Indietro_B = new JButton("Indietro");
			Indietro_B.setBackground(new Color(0, 0, 0));
			Indietro_B.setBounds(353, 90, 71, 23);
			contentPanel.add(Indietro_B);
		}
	}

}
