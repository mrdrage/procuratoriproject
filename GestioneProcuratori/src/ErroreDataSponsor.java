import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ErroreDataSponsor extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ErroreDataSponsor() {
		setBounds(100, 100, 450, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 235, 215));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Le date inserite non sono corrette.");
			lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
			lblNewLabel.setBounds(10, 11, 414, 94);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton Ok_B = new JButton("Ok");
			Ok_B.setBackground(new Color(0, 0, 0));
			Ok_B.setBounds(379, 116, 45, 23);
			contentPanel.add(Ok_B);
		}
	}

}
