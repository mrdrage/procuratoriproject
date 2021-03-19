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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class M_AggiungiContrattoSponsor extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JTextField DataInizio_TF;
	private JTextField DataFine_TF;
	private JTextField Guadagno_TF;
	private JTextField PercentualeProcuratore_TF;
	private JTextField TipologiaSponsor_TF;
	private JTextField MarcaSponsor_TF;
	private JTextField VincoliContrattuali_TF;


	/**
	 * Create the frame.
	 */
	public M_AggiungiContrattoSponsor(Controller c) {
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel AggiungiContrattoSponsor_L = new JLabel("Aggiungi un contratto Sponsor");
		AggiungiContrattoSponsor_L.setHorizontalAlignment(SwingConstants.CENTER);
		AggiungiContrattoSponsor_L.setFont(new Font("Verdana", Font.PLAIN, 25));
		AggiungiContrattoSponsor_L.setBounds(10, 11, 520, 42);
		contentPane.add(AggiungiContrattoSponsor_L);
		
		JLabel DataInizio_L = new JLabel("Data di inizio:");
		DataInizio_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataInizio_L.setBounds(10, 77, 198, 17);
		contentPane.add(DataInizio_L);
		
		JLabel DataFine_L = new JLabel("Data di fine:");
		DataFine_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataFine_L.setBounds(10, 105, 198, 17);
		contentPane.add(DataFine_L);
		
		JLabel GuadagnoAtleta_L = new JLabel("Guadagno dell'atleta:");
		GuadagnoAtleta_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GuadagnoAtleta_L.setBounds(10, 133, 198, 25);
		contentPane.add(GuadagnoAtleta_L);
		
		JLabel PercentualeProcuratore_L = new JLabel("Percentuale del procuratore:");
		PercentualeProcuratore_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PercentualeProcuratore_L.setBounds(10, 165, 208, 36);
		contentPane.add(PercentualeProcuratore_L);
		
		JLabel TipologiaSponsor_L = new JLabel("Tipologia dello Sponsor: ");
		TipologiaSponsor_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TipologiaSponsor_L.setBounds(10, 202, 208, 26);
		contentPane.add(TipologiaSponsor_L);
		
		JLabel MarcaSponsor_L = new JLabel("Marca dello Sponsor:");
		MarcaSponsor_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MarcaSponsor_L.setBounds(10, 239, 163, 26);
		contentPane.add(MarcaSponsor_L);
		
		JLabel VincoliContrattuali_L = new JLabel("Vincoli contrattuali:");
		VincoliContrattuali_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VincoliContrattuali_L.setBounds(10, 276, 163, 14);
		contentPane.add(VincoliContrattuali_L);
		
		DataInizio_TF = new JTextField();
		DataInizio_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataInizio_TF.setBounds(288, 75, 86, 20);
		contentPane.add(DataInizio_TF);
		DataInizio_TF.setColumns(10);
		
		DataFine_TF = new JTextField();
		DataFine_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataFine_TF.setBounds(288, 103, 86, 20);
		contentPane.add(DataFine_TF);
		DataFine_TF.setColumns(10);
		
		Guadagno_TF = new JTextField();
		Guadagno_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Guadagno_TF.setBounds(288, 135, 86, 20);
		contentPane.add(Guadagno_TF);
		Guadagno_TF.setColumns(10);
		
		PercentualeProcuratore_TF = new JTextField();
		PercentualeProcuratore_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PercentualeProcuratore_TF.setBounds(288, 173, 86, 20);
		contentPane.add(PercentualeProcuratore_TF);
		PercentualeProcuratore_TF.setColumns(10);
		
		TipologiaSponsor_TF = new JTextField();
		TipologiaSponsor_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		TipologiaSponsor_TF.setBounds(288, 205, 86, 20);
		contentPane.add(TipologiaSponsor_TF);
		TipologiaSponsor_TF.setColumns(10);
		
		MarcaSponsor_TF = new JTextField();
		MarcaSponsor_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		MarcaSponsor_TF.setBounds(288, 242, 86, 20);
		contentPane.add(MarcaSponsor_TF);
		MarcaSponsor_TF.setColumns(10);
		
		VincoliContrattuali_TF = new JTextField();
		VincoliContrattuali_TF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		VincoliContrattuali_TF.setBounds(288, 273, 242, 125);
		contentPane.add(VincoliContrattuali_TF);
		VincoliContrattuali_TF.setColumns(10);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				double guadagno = Double.parseDouble(Guadagno_TF.getText());
				double percentualeprocuratore = Double.parseDouble(PercentualeProcuratore_TF.getText());
				
				
				//Viene inserito  il contratto
				
				try {
					controller.InserisciContrattoSponsorDB(DataInizio_TF.getText(), DataFine_TF.getText(), guadagno, percentualeprocuratore, TipologiaSponsor_TF.getText(), MarcaSponsor_TF.getText(), VincoliContrattuali_TF.getText());
				} catch (ParseException | SQLException e1) {
					// finestre di errore
					//Se c� un errore nella data, appare la dialog ErroreDataSponsor
					e1.printStackTrace();
				}
				
				//Appare la dialog ContrattoSponsorInserito
				c.ContrattoSponsorInseritoCorrettamente();
				
			}
		});
		Avanti_B.setBackground(new Color(0, 0, 0));
		Avanti_B.setBounds(459, 450, 71, 23);
		contentPane.add(Avanti_B);
		
		JButton Indietr_B = new JButton("Indietro");
		Indietr_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Torna alla finestra GestioneProcuratore
				//setVisible(false);
			}
		});
		Indietr_B.setBackground(new Color(0, 0, 0));
		Indietr_B.setBounds(378, 450, 71, 23);
		contentPane.add(Indietr_B);
	}

}
