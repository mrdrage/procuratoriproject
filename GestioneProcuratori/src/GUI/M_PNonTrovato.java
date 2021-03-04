package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class M_PNonTrovato extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public M_PNonTrovato() {
		setBounds(100, 100, 292, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(253, 245, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel PNonTrovato_L = new JLabel("Procuratore non trovato!");
			PNonTrovato_L.setForeground(new Color(0, 0, 0));
			PNonTrovato_L.setBounds(10, 0, 273, 86);
			PNonTrovato_L.setFont(new Font("Verdana", Font.ITALIC, 20));
			contentPanel.add(PNonTrovato_L);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(253, 245, 230));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ok_B = new JButton("OK");
				ok_B.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				ok_B.setActionCommand("OK");
				buttonPane.add(ok_B);
				getRootPane().setDefaultButton(ok_B);
			}
			{
				JButton cancel_B = new JButton("Cancel");
				cancel_B.setActionCommand("Cancel");
				buttonPane.add(cancel_B);
			}
		}
	}

}
