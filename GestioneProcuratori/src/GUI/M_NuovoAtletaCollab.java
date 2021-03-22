package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class M_NuovoAtletaCollab extends JFrame {
	
	Controller controller = null;

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
	
	public M_NuovoAtletaCollab(Controller c) {
		setResizable(false);
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel AggiungiAtleta_L = new JLabel("Aggiungi un atleta");
		AggiungiAtleta_L.setHorizontalAlignment(SwingConstants.CENTER);
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
		Nome_TF.setBounds(129, 58, 156, 20);
		contentPane.add(Nome_TF);
		Nome_TF.setColumns(10);
		
		Cognome_TF = new JTextField();
		Cognome_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Cognome_TF.setBounds(131, 89, 154, 20);
		contentPane.add(Cognome_TF);
		Cognome_TF.setColumns(10);
		
		Nazione_TF = new JTextField();
		Nazione_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nazione_TF.setBounds(131, 120, 154, 20);
		contentPane.add(Nazione_TF);
		Nazione_TF.setColumns(10);
		
		CodiceFiscale_TF = new JTextField();
		CodiceFiscale_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CodiceFiscale_TF.setBounds(131, 157, 154, 20);
		contentPane.add(CodiceFiscale_TF);
		CodiceFiscale_TF.setColumns(10);
		
		Sport_TF = new JTextField();
		Sport_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Sport_TF.setBounds(131, 195, 154, 20);
		contentPane.add(Sport_TF);
		Sport_TF.setColumns(10);
		
		ClubAttuale_TF = new JTextField();
		ClubAttuale_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ClubAttuale_TF.setBounds(131, 233, 154, 20);
		contentPane.add(ClubAttuale_TF);
		ClubAttuale_TF.setColumns(10);
		
		SerieClub_TF = new JTextField();
		SerieClub_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SerieClub_TF.setBounds(129, 271, 156, 20);
		contentPane.add(SerieClub_TF);
		SerieClub_TF.setColumns(10);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			controller.TornaAListaCollaborazioni();
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(133, 334, 71, 23);
		contentPane.add(btnNewButton);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Se � gi� presente un atleta con i dati inseriti, appare la dialog ErroreAtletaPresente
				//oppure
				//Carica i dati inseriti nel database
				try {
					
					controller.InserisciAtleta(Nome_TF.getText(), Cognome_TF.getText(), Nazione_TF.getText(), 
							CodiceFiscale_TF.getText(), Sport_TF.getText(),ClubAttuale_TF.getText(), SerieClub_TF.getText());
					
					//svuoto i campi dopo che � stato premuto avanti
					Nome_TF.setText("");
					Cognome_TF.setText("");
					CodiceFiscale_TF.setText("");
					Sport_TF.setText("");
					ClubAttuale_TF.setText("");
					SerieClub_TF.setText("");
					
					
					
				} catch (SQLException e1) {
                     //finestre di errore
					e1.printStackTrace();
				}

			

			}
		});
		
		Avanti_B.setBackground(new Color(0, 0, 0));
		Avanti_B.setBounds(214, 334, 71, 23);
		contentPane.add(Avanti_B);
	}

}
