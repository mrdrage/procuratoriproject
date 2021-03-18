package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_SelezionaAtletaContratto extends JFrame {
	Controller controller = null;

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public M_SelezionaAtletaContratto(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 245);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ScegliAtleta_L = new JLabel("Seleziona un atleta: ");
		ScegliAtleta_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ScegliAtleta_L.setHorizontalAlignment(SwingConstants.CENTER);
		ScegliAtleta_L.setBounds(10, 0, 414, 51);
		contentPane.add(ScegliAtleta_L);
		
		JComboBox ScegliAtleta_CO = new JComboBox();
		ScegliAtleta_CO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ScegliAtleta_CO.setBounds(10, 62, 414, 32);
		contentPane.add(ScegliAtleta_CO);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBackground(new Color(0, 0, 0));
		Indietro_B.setBounds(345, 177, 71, 23);
		contentPane.add(Indietro_B);
		
		JButton VisualizzaContratti_B = new JButton("Visualizza i contratti");
		VisualizzaContratti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.iniziaRicercaContrattiAtleta();
				//Apre la finestra SelezionaAtletaContratto, caricando prima i contratti relativi a quell'atleta
				//setVisible(false);
			}
		});
		VisualizzaContratti_B.setBackground(new Color(0, 0, 0));
		VisualizzaContratti_B.setBounds(10, 109, 127, 23);
		contentPane.add(VisualizzaContratti_B);
		
		JButton InserisciContrattoClub_B = new JButton("Inserisci contratto Club");
		InserisciContrattoClub_B.setBackground(new Color(0, 0, 0));
		InserisciContrattoClub_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Apre la finestra AggiungiContrattoClub
				//setVisible(false);
			}
		});
		InserisciContrattoClub_B.setBounds(10, 143, 144, 23);
		contentPane.add(InserisciContrattoClub_B);
		
		JButton InserisciContrattoSponsor_B = new JButton("Inserisci contratto Sponsor");
		InserisciContrattoSponsor_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Apre la finestra AggiungiContrattoSponsor
				//setVisible(false);
			}
		});
		InserisciContrattoSponsor_B.setBackground(new Color(0, 0, 0));
		InserisciContrattoSponsor_B.setBounds(10, 177, 161, 23);
		contentPane.add(InserisciContrattoSponsor_B);
	}

}
