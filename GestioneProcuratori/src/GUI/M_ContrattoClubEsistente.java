package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class M_ContrattoClubEsistente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_ContrattoClubEsistente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 164);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ContrattoClubEsistente_L = new JLabel("Contratto Club gi\u00E1 esistente.");
		ContrattoClubEsistente_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ContrattoClubEsistente_L.setHorizontalAlignment(SwingConstants.CENTER);
		ContrattoClubEsistente_L.setBounds(10, 11, 414, 42);
		contentPane.add(ContrattoClubEsistente_L);
		
		JLabel ContrattoClubEsistente1_L = new JLabel("Sovrascrivere?");
		ContrattoClubEsistente1_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ContrattoClubEsistente1_L.setHorizontalAlignment(SwingConstants.CENTER);
		ContrattoClubEsistente1_L.setBounds(20, 48, 392, 30);
		contentPane.add(ContrattoClubEsistente1_L);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.setBounds(340, 89, 72, 23);
		contentPane.add(Avanti_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBounds(258, 89, 72, 23);
		contentPane.add(Indietro_B);
	}

}
