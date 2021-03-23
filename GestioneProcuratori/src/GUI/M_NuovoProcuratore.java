package GUI;


import Starter.Controller;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class M_NuovoProcuratore extends JFrame {

	Controller controller;
	
	
	private JPanel contentPane;
	private JTextField NumeroTelefono2_TF;
	private JTextField Email_TF;
	private JTextField DataN_TF;
	private JTextField NumeroTelefono_TF;
	private JTextField CodiceFiscale_TF;
	private JTextField Cognome_TF;
	private JTextField Nome_TF;



	/**
	 * Create the frame.
	 */
	public M_NuovoProcuratore(Controller c) {
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Nome_L = new JLabel("Nome:");
		Nome_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nome_L.setBounds(10, 79, 70, 17);
		contentPane.add(Nome_L);
		
		JLabel Cognome_L = new JLabel("Cognome:");
		Cognome_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Cognome_L.setBounds(10, 119, 89, 18);
		contentPane.add(Cognome_L);
		
		JLabel CodiceFiscale_L = new JLabel("Codice Fiscale*:");
		CodiceFiscale_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CodiceFiscale_L.setBounds(10, 159, 118, 17);
		contentPane.add(CodiceFiscale_L);
		
		JLabel NumeroTelefono_L = new JLabel("Numero di telefono:");
		NumeroTelefono_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NumeroTelefono_L.setBounds(10, 202, 155, 17);
		contentPane.add(NumeroTelefono_L);
		
		JLabel NumeroTelefono2_L = new JLabel("Numero di telefono 2:");
		NumeroTelefono2_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		NumeroTelefono2_L.setBounds(10, 245, 166, 17);
		contentPane.add(NumeroTelefono2_L);
		
		JLabel Email_L = new JLabel("Email:");
		Email_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Email_L.setBounds(10, 285, 86, 14);
		contentPane.add(Email_L);
		
		JLabel DataN_L = new JLabel("Data di nascita:");
		DataN_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataN_L.setBounds(10, 320, 118, 17);
		contentPane.add(DataN_L);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					controller.InserisciProcuratoreDB(Nome_TF.getText(), Cognome_TF.getText(), CodiceFiscale_TF.getText(), 
							NumeroTelefono_TF.getText(), NumeroTelefono2_TF.getText(),Email_TF.getText(), DataN_TF.getText());
					
					//svuoto i campi dopo che � stato premuto avanti
					Nome_TF.setText("");
					Cognome_TF.setText("");
					CodiceFiscale_TF.setText("");
					NumeroTelefono_TF.setText("");
					NumeroTelefono2_TF.setText("");
					Email_TF.setText("");
					DataN_TF.setText("");
					
					controller.ProcuratoreInseritoCorrettamente();
				
				} catch (SQLException | ParseException e1) {
                     controller.ErroreInserimentoDatabase();
					e1.printStackTrace();
				}
				
			
				//messaggio di inserimento effettuato 
				//OK.setVisible(true);
				
				
			}
		});
		
		Avanti_B.setBounds(260, 467, 89, 23);
		contentPane.add(Avanti_B);
		
		JButton Annulla_B = new JButton("Annulla");
		Annulla_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            controller.TornaAllaHome();
            setVisible(false);
			}
		});
		
		Annulla_B.setBounds(161, 467, 89, 23);
		contentPane.add(Annulla_B);
		
		JLabel InserisciDati_L = new JLabel("Inserisci i dati del procuratore:");
		InserisciDati_L.setFont(new Font("Verdana", Font.PLAIN, 18));
		InserisciDati_L.setBounds(24, -21, 297, 75);
		contentPane.add(InserisciDati_L);
		
		NumeroTelefono2_TF = new JTextField();
		NumeroTelefono2_TF.setBounds(194, 245, 145, 20);
		contentPane.add(NumeroTelefono2_TF);
		NumeroTelefono2_TF.setColumns(10);
		
		Email_TF = new JTextField();
		Email_TF.setBounds(194, 284, 145, 20);
		contentPane.add(Email_TF);
		Email_TF.setColumns(10);
		
		DataN_TF = new JTextField();
		DataN_TF.setBounds(194, 320, 145, 20);
		contentPane.add(DataN_TF);
		DataN_TF.setColumns(10);
		
		NumeroTelefono_TF = new JTextField();
		NumeroTelefono_TF.setBounds(194, 202, 145, 20);
		contentPane.add(NumeroTelefono_TF);
		NumeroTelefono_TF.setColumns(10);
		
		CodiceFiscale_TF = new JTextField();
		CodiceFiscale_TF.setBounds(194, 159, 145, 20);
		contentPane.add(CodiceFiscale_TF);
		CodiceFiscale_TF.setColumns(10);
		
		Cognome_TF = new JTextField();
		Cognome_TF.setBounds(194, 120, 145, 20);
		contentPane.add(Cognome_TF);
		Cognome_TF.setColumns(10);
		
		Nome_TF = new JTextField();
		Nome_TF.setBounds(194, 79, 145, 20);
		contentPane.add(Nome_TF);
		Nome_TF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("*Codice fiscale massimo 16 caratteri");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 415, 185, 17);
		contentPane.add(lblNewLabel);
		
		
	}
}
