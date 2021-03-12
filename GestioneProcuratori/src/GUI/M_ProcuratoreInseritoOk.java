package GUI;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_ProcuratoreInseritoOk extends JDialog {

	Controller controller = null;
	
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	
	public M_ProcuratoreInseritoOk(Controller c) {
		controller = c;
		setBounds(100, 100, 383, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(253, 245, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel PInseritoOk_L = new JLabel("Procuratore inserito correttamente.");
			PInseritoOk_L.setFont(new Font("Verdana", Font.ITALIC, 20));
			PInseritoOk_L.setBounds(10, 0, 377, 95);
			contentPanel.add(PInseritoOk_L);
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
//					c.TornaAllaHome();
					setVisible(false);
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
