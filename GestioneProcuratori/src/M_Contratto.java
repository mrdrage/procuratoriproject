import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class M_Contratto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public M_Contratto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 286);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton VisualizzaContratti_B = new JButton("Visualizza contratti");
		VisualizzaContratti_B.setBackground(new Color(0, 0, 0));
		VisualizzaContratti_B.setFont(new Font("Tahoma", Font.PLAIN, 18));
		VisualizzaContratti_B.setBounds(35, 32, 348, 51);
		contentPane.add(VisualizzaContratti_B);
		
		JButton InserisciContrattoClub_B = new JButton("Inserisci contratto Club");
		InserisciContrattoClub_B.setBackground(new Color(0, 0, 0));
		InserisciContrattoClub_B.setFont(new Font("Tahoma", Font.PLAIN, 18));
		InserisciContrattoClub_B.setBounds(35, 99, 348, 51);
		contentPane.add(InserisciContrattoClub_B);
		
		JButton InserisciContrattoSponsor_B = new JButton("Inserisci contratto Sponsor");
		InserisciContrattoSponsor_B.setBackground(new Color(0, 0, 0));
		InserisciContrattoSponsor_B.setFont(new Font("Tahoma", Font.PLAIN, 18));
		InserisciContrattoSponsor_B.setBounds(35, 161, 348, 51);
		contentPane.add(InserisciContrattoSponsor_B);
	}

}
