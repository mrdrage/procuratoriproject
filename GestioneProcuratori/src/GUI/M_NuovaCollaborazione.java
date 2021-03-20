package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class M_NuovaCollaborazione extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JTextField DataInizio_TF;
	private JTextField DataFine_TF;
	private JTextField StipendioMensile_TF;

	
	/**
	 * Create the frame.
	 */
	public M_NuovaCollaborazione(Controller c) {
		
		controller  = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 286);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aggiungi collaborazione");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 0, 273, 31);
		contentPane.add(lblNewLabel);
		
		JLabel Atleta_L = new JLabel("Atleta:");
		Atleta_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Atleta_L.setBounds(10, 65, 69, 14);
		contentPane.add(Atleta_L);
		
		JLabel DataInizio_L = new JLabel("Data di inizio");
		DataInizio_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataInizio_L.setBounds(10, 90, 99, 14);
		contentPane.add(DataInizio_L);
		
		JLabel DataFine_L = new JLabel("Data di fine");
		DataFine_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataFine_L.setBounds(10, 115, 89, 14);
		contentPane.add(DataFine_L);
		
		JLabel StipendioMensile_T = new JLabel("Stipendio mensile del procuratore:");
		StipendioMensile_T.setFont(new Font("Tahoma", Font.PLAIN, 13));
		StipendioMensile_T.setBounds(10, 153, 207, 14);
		contentPane.add(StipendioMensile_T);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Torna alla finestra GestioneProcuratore
				//setVisible(false);
			}
		});
		Indietro_B.setBackground(new Color(0, 0, 0));
		Indietro_B.setBounds(205, 220, 71, 23);
		contentPane.add(Indietro_B);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                double stipendiomensile = Double.parseDouble(StipendioMensile_TF.getText());
				
				try {
					
					controller.InserisciCollaborazioneDB(DataInizio_TF.getText(), DataFine_TF.getText(), stipendiomensile);
				} catch (SQLException | ParseException e1) {
                     //finestre di errore
					e1.printStackTrace();
				}
				
				//Se � gia presente una collaborazione con i dati inseriti, apre la dialog ErroreCollaborazionePresente
				
				
				
				//svuoto i campi
				DataInizio_TF.setText("");
				DataFine_TF.setText("");
				StipendioMensile_TF.setText("");
				
				
				//Se tutto va bene, si apre la finestra ListaCollaborazioni
				setVisible(false);
				//controller.ApriListaCollaborazioni();
				
			}
		});
		Avanti_B.setBackground(new Color(0, 0, 0));
		Avanti_B.setBounds(286, 220, 69, 23);
		contentPane.add(Avanti_B);
		
		DataInizio_TF = new JTextField();
		DataInizio_TF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bravo!");
			}
		});
		
		DataInizio_TF.setBounds(227, 89, 108, 20);
		contentPane.add(DataInizio_TF);
		DataInizio_TF.setColumns(10);
		
		DataFine_TF = new JTextField();
		DataFine_TF.setBounds(227, 114, 108, 20);
		contentPane.add(DataFine_TF);
		DataFine_TF.setColumns(10);
		
		JComboBox Atleta_CB = new JComboBox();
		Atleta_CB.setBounds(227, 65, 108, 18);
		contentPane.add(Atleta_CB);
		
		
		StipendioMensile_TF = new JTextField();
		StipendioMensile_TF.setBounds(227, 151, 86, 20);
		contentPane.add(StipendioMensile_TF);
		StipendioMensile_TF.setColumns(10);
	}
}
