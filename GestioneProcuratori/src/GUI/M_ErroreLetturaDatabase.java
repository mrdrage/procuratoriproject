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

public class M_ErroreLetturaDatabase extends JDialog {
	
	Controller contoller;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public M_ErroreLetturaDatabase(Controller c) {
		
		contoller = c;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel ErroreDatabase_L = new JLabel("Errore Database");
		ErroreDatabase_L.setFont(new Font("Tahoma", Font.BOLD, 17));
		ErroreDatabase_L.setBounds(27, 21, 306, 38);
		contentPanel.add(ErroreDatabase_L);
		
		JLabel ErroreDatabase1_L = new JLabel("Si è verificato un errore durante la lettura dei dati, riprovare");
		ErroreDatabase1_L.setBounds(37, 71, 390, 72);
		contentPanel.add(ErroreDatabase1_L);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
