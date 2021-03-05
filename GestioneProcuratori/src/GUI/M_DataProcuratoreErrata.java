package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class M_DataProcuratoreErrata extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public M_DataProcuratoreErrata() {
		setBounds(100, 100, 252, 154);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 240, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel DataProcuratoreErrata_L = new JLabel("Data inserita errata.");
			DataProcuratoreErrata_L.setFont(new Font("Verdana", Font.PLAIN, 20));
			DataProcuratoreErrata_L.setBounds(10, 11, 216, 70);
			contentPanel.add(DataProcuratoreErrata_L);
		}
		{
			JButton Ok_B = new JButton("Ok");
			Ok_B.setBackground(new Color(0, 0, 0));
			Ok_B.setBounds(178, 81, 48, 23);
			contentPanel.add(Ok_B);
		}
	}

}
