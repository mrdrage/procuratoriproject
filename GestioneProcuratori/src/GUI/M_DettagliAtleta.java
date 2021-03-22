package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;
import entita.Atleti;
import entita.Procuratori;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class M_DettagliAtleta extends JFrame {

	Controller controller;
	
	private JPanel contentPane;
	private JTextField Nome_TF;
	private JTextField Cognome_TF;
	private JTextField Nazione_TF;
	private JTextField CodiceFiscale_TF;
	private JTextField Sport_TF;
	private JTextField ClubAttuale_TF;
	private JTextField SerieClub_TF;

	/**
	 * Create the frame.
	 */
	
	public M_DettagliAtleta(Controller c) {
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DettagliAtleta = new JLabel("Ecco i dettagli dell'atleta: ");
		DettagliAtleta.setHorizontalAlignment(SwingConstants.CENTER);
		DettagliAtleta.setFont(new Font("Verdana", Font.PLAIN, 20));
		DettagliAtleta.setBounds(10, 11, 465, 35);
		contentPane.add(DettagliAtleta);
		
		JLabel Nome_L = new JLabel("Nome:");
		Nome_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nome_L.setBounds(10, 65, 102, 14);
		contentPane.add(Nome_L);
		
		JLabel Cognome_L = new JLabel("Cognome:");
		Cognome_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Cognome_L.setBounds(10, 107, 102, 14);
		contentPane.add(Cognome_L);
		
		JLabel Nazione_L = new JLabel("Nazione:");
		Nazione_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nazione_L.setBounds(10, 148, 102, 14);
		contentPane.add(Nazione_L);
		
		JLabel CodiceFiscale_L = new JLabel("Codice Fiscale:");
		CodiceFiscale_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CodiceFiscale_L.setBounds(10, 188, 171, 14);
		contentPane.add(CodiceFiscale_L);
		
		JLabel Sport_L = new JLabel("Sport:");
		Sport_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Sport_L.setBounds(10, 233, 171, 14);
		contentPane.add(Sport_L);
		
		JLabel ClubAttuale_L = new JLabel("Club attuale:");
		ClubAttuale_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ClubAttuale_L.setBounds(10, 277, 171, 14);
		contentPane.add(ClubAttuale_L);
		
		JLabel SerieClub_L = new JLabel("Serie Club");
		SerieClub_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SerieClub_L.setBounds(10, 329, 171, 14);
		contentPane.add(SerieClub_L);
		
		Nome_TF = new JTextField();
		Nome_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nome_TF.setEditable(false);
		Nome_TF.setBounds(210, 62, 150, 20);
		contentPane.add(Nome_TF);
		Nome_TF.setColumns(10);
		
		Cognome_TF = new JTextField();
		Cognome_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Cognome_TF.setEditable(false);
		Cognome_TF.setBounds(210, 104, 150, 20);
		contentPane.add(Cognome_TF);
		Cognome_TF.setColumns(10);
		
		Nazione_TF = new JTextField();
		Nazione_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nazione_TF.setEditable(false);
		Nazione_TF.setBounds(210, 145, 150, 20);
		contentPane.add(Nazione_TF);
		Nazione_TF.setColumns(10);
		
		CodiceFiscale_TF = new JTextField();
		CodiceFiscale_TF.setEditable(false);
		CodiceFiscale_TF.setBounds(210, 185, 150, 20);
		contentPane.add(CodiceFiscale_TF);
		CodiceFiscale_TF.setColumns(10);
		
		Sport_TF = new JTextField();
		Sport_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Sport_TF.setEditable(false);
		Sport_TF.setBounds(210, 230, 150, 20);
		contentPane.add(Sport_TF);
		Sport_TF.setColumns(10);
		
		ClubAttuale_TF = new JTextField();
		ClubAttuale_TF.setEditable(false);
		ClubAttuale_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ClubAttuale_TF.setBounds(210, 274, 150, 20);
		contentPane.add(ClubAttuale_TF);
		ClubAttuale_TF.setColumns(10);
		
		SerieClub_TF = new JTextField();
		SerieClub_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SerieClub_TF.setEditable(false);
		SerieClub_TF.setBounds(210, 326, 150, 20);
		contentPane.add(SerieClub_TF);
		SerieClub_TF.setColumns(10);
		
		JButton Ok_B = new JButton("Ok");
		Ok_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.TornaAllaGestioneProcuratore();
			}
		});
		
		Ok_B.setBackground(new Color(0, 0, 0));
		Ok_B.setBounds(423, 444, 52, 23);
		contentPane.add(Ok_B);
		
		JButton GestisciGettoneNazionale_B = new JButton("Visualizza gettoni nazionale");
		GestisciGettoneNazionale_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Apre la finestra GestioneGettoneNazionale, caricando prima i dati del gettone relativo all'atleta di cui si stanno guardando i dettagli
				try {
					controller.VisualizzaGettoniNazionale();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		GestisciGettoneNazionale_B.setBackground(new Color(0, 0, 0));
		GestisciGettoneNazionale_B.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GestisciGettoneNazionale_B.setBounds(108, 392, 253, 35);
		contentPane.add(GestisciGettoneNazionale_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBounds(10, 438, 117, 29);
		contentPane.add(Indietro_B);
	}
	
	public void setAtleta (Atleti atleta) {
		
		Nome_TF.setText(atleta.getNome());
		Cognome_TF.setText(atleta.getCognome());
		Nazione_TF.setText(atleta.getNazione());
		CodiceFiscale_TF.setText(atleta.getCodiceFiscale());
		Sport_TF.setText(atleta.getSport());
		ClubAttuale_TF.setText(atleta.getClubAttuale());
		SerieClub_TF.setText(atleta.getSerieClub());
        
				
		
	}
}
