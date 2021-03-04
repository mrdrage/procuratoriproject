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

public class M_ErroreDataClub extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public M_ErroreDataClub() {
		setBounds(100, 100, 450, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 235, 215));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ErroreDataClub_L = new JLabel("Le date inserite non sono corrette.");
			ErroreDataClub_L.setHorizontalAlignment(SwingConstants.CENTER);
			ErroreDataClub_L.setFont(new Font("Verdana", Font.PLAIN, 23));
			ErroreDataClub_L.setBounds(0, -11, 434, 72);
			contentPanel.add(ErroreDataClub_L);
		}
		{
			JButton Ok_B = new JButton("Ok");
			Ok_B.setBounds(379, 68, 45, 23);
			contentPanel.add(Ok_B);
		}
	}

}
