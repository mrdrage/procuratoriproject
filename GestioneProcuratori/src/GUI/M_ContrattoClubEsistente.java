package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_ContrattoClubEsistente extends JFrame {
	
	Controller controller = null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_ContrattoClubEsistente(Controller c) {
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 164);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ContrattoClubEsistente_L = new JLabel("L'atleta selezionato ha gi\u00E1 un contratto di tipo club.");
		ContrattoClubEsistente_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ContrattoClubEsistente_L.setHorizontalAlignment(SwingConstants.CENTER);
		ContrattoClubEsistente_L.setBounds(10, 11, 587, 42);
		contentPane.add(ContrattoClubEsistente_L);
		
		JLabel ContrattoClubEsistente1_L = new JLabel("Aggiungerne uno nuovo?");
		ContrattoClubEsistente1_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ContrattoClubEsistente1_L.setHorizontalAlignment(SwingConstants.CENTER);
		ContrattoClubEsistente1_L.setBounds(20, 48, 577, 30);
		contentPane.add(ContrattoClubEsistente1_L);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.IniziaInserimentoContrattoClub();
			}
		});
		Avanti_B.setBounds(525, 89, 72, 23);
		contentPane.add(Avanti_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBounds(443, 89, 72, 23);
		contentPane.add(Indietro_B);
	}

}
