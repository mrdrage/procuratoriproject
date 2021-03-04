package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class M_NuovoAtletaCollab extends JFrame {

	private JPanel contentPane;
	private JTextField Nome_TF;
	private JTextField Cognome_TF;
	private JTextField Nazione_TF;
	private JTextField CodiceFisclae_TF;
	private JTextField Sport_TF;
	private JTextField ClubAttuale_TF;
	private JTextField SerieClub_TF;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_NuovoAtletaCollab() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel AggiungiAtleta_L = new JLabel("Aggiungi un atleta");
		AggiungiAtleta_L.setFont(new Font("Verdana", Font.PLAIN, 18));
		AggiungiAtleta_L.setBounds(27, 11, 258, 27);
		contentPane.add(AggiungiAtleta_L);
		
		JLabel Nome_L = new JLabel("Nome:");
		Nome_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nome_L.setBounds(10, 58, 100, 20);
		contentPane.add(Nome_L);
		
		JLabel Cognome_L = new JLabel("Cognome:");
		Cognome_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Cognome_L.setBounds(10, 89, 111, 20);
		contentPane.add(Cognome_L);
		
		JLabel Nazione_L = new JLabel("Nazione:");
		Nazione_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nazione_L.setBounds(10, 120, 111, 20);
		contentPane.add(Nazione_L);
		
		JLabel CodiceFiscale_L = new JLabel("Codice Fiscale:");
		CodiceFiscale_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CodiceFiscale_L.setBounds(10, 154, 111, 27);
		contentPane.add(CodiceFiscale_L);
		
		JLabel Sport_L = new JLabel("Sport:");
		Sport_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Sport_L.setBounds(10, 192, 111, 27);
		contentPane.add(Sport_L);
		
		JLabel ClubAttuale_L = new JLabel("Club attuale:");
		ClubAttuale_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ClubAttuale_L.setBounds(10, 230, 100, 27);
		contentPane.add(ClubAttuale_L);
		
		JLabel SerieClub_L = new JLabel("Serie Club:");
		SerieClub_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SerieClub_L.setBounds(10, 268, 100, 27);
		contentPane.add(SerieClub_L);
		
		Nome_TF = new JTextField();
		Nome_TF.setBackground(new Color(255, 255, 255));
		Nome_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nome_TF.setBounds(129, 58, 119, 20);
		contentPane.add(Nome_TF);
		Nome_TF.setColumns(10);
		
		Cognome_TF = new JTextField();
		Cognome_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Cognome_TF.setBounds(131, 89, 117, 20);
		contentPane.add(Cognome_TF);
		Cognome_TF.setColumns(10);
		
		Nazione_TF = new JTextField();
		Nazione_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nazione_TF.setBounds(131, 120, 117, 20);
		contentPane.add(Nazione_TF);
		Nazione_TF.setColumns(10);
		
		CodiceFisclae_TF = new JTextField();
		CodiceFisclae_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CodiceFisclae_TF.setBounds(131, 157, 117, 20);
		contentPane.add(CodiceFisclae_TF);
		CodiceFisclae_TF.setColumns(10);
		
		Sport_TF = new JTextField();
		Sport_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Sport_TF.setBounds(131, 195, 117, 20);
		contentPane.add(Sport_TF);
		Sport_TF.setColumns(10);
		
		ClubAttuale_TF = new JTextField();
		ClubAttuale_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ClubAttuale_TF.setBounds(131, 233, 117, 20);
		contentPane.add(ClubAttuale_TF);
		ClubAttuale_TF.setColumns(10);
		
		SerieClub_TF = new JTextField();
		SerieClub_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SerieClub_TF.setBounds(129, 268, 119, 20);
		contentPane.add(SerieClub_TF);
		SerieClub_TF.setColumns(10);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(100, 334, 71, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Avanti");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(186, 334, 71, 23);
		contentPane.add(btnNewButton_1);
	}

}
