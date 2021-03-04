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

public class M_ErroreCollaborazionePresente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public M_ErroreCollaborazionePresente() {
		setBounds(100, 100, 395, 115);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 240, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ErroreCollaborazionePresente_L = new JLabel("La collaborazione \u00E9 gi\u00E1 presente.");
			ErroreCollaborazionePresente_L.setFont(new Font("Verdana", Font.PLAIN, 20));
			ErroreCollaborazionePresente_L.setBounds(10, -12, 414, 55);
			contentPanel.add(ErroreCollaborazionePresente_L);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(250, 240, 230));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Ok_B = new JButton("OK");
				Ok_B.setBackground(new Color(0, 0, 0));
				Ok_B.setActionCommand("OK");
				buttonPane.add(Ok_B);
				getRootPane().setDefaultButton(Ok_B);
			}
			{
				JButton Cancel_B = new JButton("Cancel");
				Cancel_B.setBackground(new Color(0, 0, 0));
				Cancel_B.setActionCommand("Cancel");
				buttonPane.add(Cancel_B);
			}
		}
	}

}
