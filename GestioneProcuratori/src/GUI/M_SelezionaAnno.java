package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class M_SelezionaAnno extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_SelezionaAnno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 195);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ScegliAnno_L = new JLabel("Seleziona l'anno");
		ScegliAnno_L.setHorizontalAlignment(SwingConstants.CENTER);
		ScegliAnno_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ScegliAnno_L.setBounds(10, 11, 244, 36);
		contentPane.add(ScegliAnno_L);
		
		JComboBox ScegliAnno_CO = new JComboBox();
		ScegliAnno_CO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ScegliAnno_CO.setBounds(10, 76, 131, 22);
		contentPane.add(ScegliAnno_CO);
		
		JButton Annulla_B = new JButton("Annulla");
		Annulla_B.setBounds(187, 122, 67, 23);
		contentPane.add(Annulla_B);
	}

}
