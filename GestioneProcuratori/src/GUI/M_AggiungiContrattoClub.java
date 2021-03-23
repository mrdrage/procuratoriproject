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
import javax.swing.DropMode;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Point;
import javax.swing.JTextArea;

public class M_AggiungiContrattoClub extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JTextField DataInizio_TF;
	private JTextField DataFine_TF;
	private JTextField StipendioAtleta_TF;
	private JTextArea BonusStagione_TF;
	private JTextField GuadagnoBonus_TF;
	private JTextArea VincoloContrattuale_TF;

	/**
	 * Create the frame.
	 */
	public M_AggiungiContrattoClub(Controller c) {
		setResizable(false);
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 504);
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
		
		
		JLabel StipendioAtleta_L = new JLabel("Stipendio stagionale dell'atleta:");
		StipendioAtleta_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StipendioAtleta_L.setBounds(10, 122, 235, 19);
		contentPane.add(StipendioAtleta_L);
		
		JLabel BonusStagione_L = new JLabel("Obiettivi bonus stagionale*:");
		BonusStagione_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		BonusStagione_L.setBounds(10, 152, 216, 19);
		contentPane.add(BonusStagione_L);
		
		JLabel GuadagnoBonus_L = new JLabel("Guadagno bonus dell'atleta:");
		GuadagnoBonus_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GuadagnoBonus_L.setBounds(10, 271, 216, 19);
		contentPane.add(GuadagnoBonus_L);
		
		JLabel VincoliContrattuali_L = new JLabel("Vincoli contrattuali con il club:");
		VincoliContrattuali_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VincoliContrattuali_L.setBounds(10, 317, 216, 19);
		contentPane.add(VincoliContrattuali_L);
		
		DataInizio_TF = new JTextField();
		DataInizio_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataInizio_TF.setBounds(351, 61, 119, 20);
		contentPane.add(DataInizio_TF);
		DataInizio_TF.setColumns(10);
		
		DataFine_TF = new JTextField();
		DataFine_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataFine_TF.setBounds(351, 91, 119, 20);
		contentPane.add(DataFine_TF);
		DataFine_TF.setColumns(10);
		
		StipendioAtleta_TF = new JTextField();
		StipendioAtleta_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		StipendioAtleta_TF.setBounds(351, 121, 119, 20);
		contentPane.add(StipendioAtleta_TF);
		StipendioAtleta_TF.setColumns(10);
		
		BonusStagione_TF = new JTextArea();
		BonusStagione_TF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BonusStagione_TF.setBounds(254, 151, 216, 88);
		contentPane.add(BonusStagione_TF);
		
		GuadagnoBonus_TF = new JTextField();
		GuadagnoBonus_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GuadagnoBonus_TF.setBounds(351, 270, 119, 20);
		contentPane.add(GuadagnoBonus_TF);
		GuadagnoBonus_TF.setColumns(10);
		
		VincoloContrattuale_TF = new JTextArea();
		VincoloContrattuale_TF.setBounds(254, 316, 216, 88);
		contentPane.add(VincoloContrattuale_TF);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double stipendioatleta = Double.parseDouble(StipendioAtleta_TF.getText());
				double guadagnobonus = Double.parseDouble(GuadagnoBonus_TF.getText());
				
				try {
					
					controller.InserisciContrattoClubDB(DataInizio_TF.getText(), DataFine_TF.getText(), stipendioatleta, BonusStagione_TF.getText(), guadagnobonus, VincoloContrattuale_TF.getText());
					//svuoto i campi
					DataInizio_TF.setText("");
					DataFine_TF.setText("");
					StipendioAtleta_TF.setText("");
					BonusStagione_TF.setText("");
					GuadagnoBonus_TF.setText("");
					VincoloContrattuale_TF.setText("");
					
					controller.ContrattoClubInseritoCorrettamente();
				} 
				  catch (ParseException e1) {
					  
					// finestra di errore
					controller.ErroreInserimentoData();
					e1.printStackTrace();
					
				} catch (SQLException | NumberFormatException e2) {
					
					controller.ErroreInserimentoDatabase();
					e2.printStackTrace();
				}	

				
			}
		});
		
		Avanti_B.setBackground(Color.WHITE);
		Avanti_B.setBounds(377, 433, 93, 23);
		contentPane.add(Avanti_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DataInizio_TF.setText("");
				DataFine_TF.setText("");
				StipendioAtleta_TF.setText("");
				BonusStagione_TF.setText("");
				GuadagnoBonus_TF.setText("");
				VincoloContrattuale_TF.setText("");
				
				controller.tornaAselezionaAtletaContratto();
				
				
			}
		});
		Indietro_B.setBackground(Color.WHITE);
		Indietro_B.setBounds(274, 433, 93, 23);
		contentPane.add(Indietro_B);
		
		JLabel Percentuale_L = new JLabel("%");
		Percentuale_L.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Percentuale_L.setBounds(474, 270, 25, 17);
		contentPane.add(Percentuale_L);
		
		JLabel Suggerimento_L = new JLabel("*Indicare gli obiettivi per ottenere il bonus");
		Suggerimento_L.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Suggerimento_L.setBounds(10, 182, 216, 14);
		contentPane.add(Suggerimento_L);
		
		
		
	
	}
}
