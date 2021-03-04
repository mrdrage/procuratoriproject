package GUI;

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

public class M_NessunaCollaborazione extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public M_NessunaCollaborazione() {
		setBounds(100, 100, 393, 166);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 240, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel NoCollaboration_L = new JLabel("Nessuna collaborazione trovata.");
			NoCollaboration_L.setVerticalAlignment(SwingConstants.TOP);
			NoCollaboration_L.setHorizontalAlignment(SwingConstants.LEFT);
			NoCollaboration_L.setFont(new Font("Verdana", Font.PLAIN, 20));
			NoCollaboration_L.setBounds(20, 22, 360, 33);
			contentPanel.add(NoCollaboration_L);
		}
		{
			JLabel NoCollaboration1_L = new JLabel("Aggiungerne una nuova ?");
			NoCollaboration1_L.setFont(new Font("Verdana", Font.PLAIN, 20));
			NoCollaboration1_L.setBounds(50, 45, 361, 33);
			contentPanel.add(NoCollaboration1_L);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(250, 240, 230));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Annulla_B = new JButton("Annulla");
				Annulla_B.setBackground(new Color(0, 0, 0));
				Annulla_B.setActionCommand("OK");
				buttonPane.add(Annulla_B);
				getRootPane().setDefaultButton(Annulla_B);
			}
			{
				JButton Avanti_B = new JButton("Avanti");
				Avanti_B.setBackground(new Color(0, 0, 0));
				Avanti_B.setActionCommand("Cancel");
				buttonPane.add(Avanti_B);
			}
		}
	}

}
