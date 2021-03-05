package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class M_ErroreDatabase extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public M_ErroreDatabase() {
		setBounds(100, 100, 336, 134);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ErroreDatabase_L = new JLabel("Attenzione, errore database.");
			ErroreDatabase_L.setFont(new Font("Verdana", Font.PLAIN, 20));
			ErroreDatabase_L.setBounds(10, 0, 300, 50);
			contentPanel.add(ErroreDatabase_L);
		}
		{
			JButton Ok_B = new JButton("Ok");
			Ok_B.setBackground(new Color(0, 0, 0));
			Ok_B.setBounds(258, 61, 52, 23);
			contentPanel.add(Ok_B);
		}
	}

}
