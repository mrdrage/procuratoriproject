package GUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class M_ErroreAnno extends JDialog {

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public M_ErroreAnno() {
		getContentPane().setBackground(new Color(255, 245, 238));
		setBounds(100, 100, 450, 138);
		getContentPane().setLayout(null);
		
		JLabel ErroreAnno_L = new JLabel("L'anno selezionato non ha prodotto risultati.");
		ErroreAnno_L.setHorizontalAlignment(SwingConstants.CENTER);
		ErroreAnno_L.setFont(new Font("Verdana", Font.PLAIN, 18));
		ErroreAnno_L.setBounds(10, -12, 414, 81);
		getContentPane().add(ErroreAnno_L);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBackground(new Color(0, 0, 0));
		Indietro_B.setBounds(353, 66, 71, 23);
		getContentPane().add(Indietro_B);

	}
}
