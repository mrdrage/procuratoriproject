package GUI;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class M_AggiungiContrattoClub extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JTextField DataInizio_TF;
	private JTextField DataFine_TF;
	private JTextField StipendioAtleta_TF;
	private JTextField BonusStagione_TF;
	private JTextField GuadagnoBonus_TF;
	private JTextField VincoloContrattuale_TF;

	/**
	 * Create the frame.
	 */
	public M_AggiungiContrattoClub(Controller c) {
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel AggiungiContrattoClub_L = new JLabel("Aggiungi un contratto Club");
		AggiungiContrattoClub_L.setFont(new Font("Verdana", Font.PLAIN, 25));
		AggiungiContrattoClub_L.setHorizontalAlignment(SwingConstants.CENTER);
		AggiungiContrattoClub_L.setBounds(10, 11, 489, 39);
		contentPane.add(AggiungiContrattoClub_L);
		
		JLabel DataInizio_L = new JLabel("Data di inizio:");
		DataInizio_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataInizio_L.setBounds(10, 62, 143, 19);
		contentPane.add(DataInizio_L);
		
		JLabel DataFine_L = new JLabel("Data di fine:");
		DataFine_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataFine_L.setBounds(10, 92, 153, 19);
		contentPane.add(DataFine_L);
		
		JLabel StipendioAtleta_L = new JLabel("Stipendio dell'atleta:");
		StipendioAtleta_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StipendioAtleta_L.setBounds(10, 122, 174, 19);
		contentPane.add(StipendioAtleta_L);
		
		JLabel BonusStagione_L = new JLabel("Bonus stagionali:");
		BonusStagione_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BonusStagione_L.setBounds(10, 152, 153, 19);
		contentPane.add(BonusStagione_L);
		
		JLabel GuadagnoBonus_L = new JLabel("Guadagno bonus dell'atleta:");
		GuadagnoBonus_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GuadagnoBonus_L.setBounds(10, 271, 216, 19);
		contentPane.add(GuadagnoBonus_L);
		
		JLabel VincoliContrattuali_L = new JLabel("Vincoli contrattuali:");
		VincoliContrattuali_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VincoliContrattuali_L.setBounds(10, 317, 163, 19);
		contentPane.add(VincoliContrattuali_L);
		
		DataInizio_TF = new JTextField();
		DataInizio_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataInizio_TF.setBounds(254, 63, 119, 20);
		contentPane.add(DataInizio_TF);
		DataInizio_TF.setColumns(10);
		
		DataFine_TF = new JTextField();
		DataFine_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataFine_TF.setBounds(254, 93, 119, 20);
		contentPane.add(DataFine_TF);
		DataFine_TF.setColumns(10);
		
		StipendioAtleta_TF = new JTextField();
		StipendioAtleta_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StipendioAtleta_TF.setBounds(254, 123, 119, 20);
		contentPane.add(StipendioAtleta_TF);
		StipendioAtleta_TF.setColumns(10);
		
		BonusStagione_TF = new JTextField();
		BonusStagione_TF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BonusStagione_TF.setBounds(254, 153, 216, 88);
		contentPane.add(BonusStagione_TF);
		BonusStagione_TF.setColumns(10);
		
		GuadagnoBonus_TF = new JTextField();
		GuadagnoBonus_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GuadagnoBonus_TF.setBounds(254, 272, 119, 20);
		contentPane.add(GuadagnoBonus_TF);
		GuadagnoBonus_TF.setColumns(10);
		
		VincoloContrattuale_TF = new JTextField();
		VincoloContrattuale_TF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		VincoloContrattuale_TF.setBounds(254, 318, 216, 88);
		contentPane.add(VincoloContrattuale_TF);
		VincoloContrattuale_TF.setColumns(10);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double stipendioatleta = Double.parseDouble(StipendioAtleta_TF.getText());
				double guadagnobonus = Double.parseDouble(GuadagnoBonus_TF.getText());
				
				//Se l'atleta selezionato ha giá un contratto club, appare la finestra M_checkclub
				//oppure viene inserito  il contratto
				
				try {
					controller.InserisciContrattoClubDB(DataInizio_TF.getText(), DataFine_TF.getText(), stipendioatleta, BonusStagione_TF.getText(), guadagnobonus, VincoloContrattuale_TF.getText());
					controller.ContrattoClubInseritoCorrettamente();
				} // finestre di errore
				  catch (ParseException e1) {
					
					e1.printStackTrace();
					controller.ErroreInserimentoDataContratto();
					
				} catch (SQLException e2) {
					controller.ErroreInserimentoDatabase();
					
				}
				
				//oppure appare la dialog ContrattoClubInserito
				
				
				
				
			}
		});
		Avanti_B.setBackground(new Color(0, 0, 0));
		Avanti_B.setBounds(393, 433, 93, 23);
		contentPane.add(Avanti_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//torna alla finestra GestioneProcuratore
				//setVisible(false);
			}
		});
		Indietro_B.setBackground(new Color(0, 0, 0));
		Indietro_B.setBounds(288, 433, 93, 23);
		contentPane.add(Indietro_B);
	}

}
