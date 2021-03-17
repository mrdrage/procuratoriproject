package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;
import entita.Procuratori;

import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_GestioneProcuratore extends JFrame {

	Controller controller = null;
	
	private JPanel contentPane;
	
	private JTextField NumeroTelefono2_TF;
	private JTextField NumeroTelefono_TF;
	private JTextField CodiceFiscale_TF;
	private JTextField Cognome_TF;
	private JTextField Nome_TF;
	private JTextField Email_TF;
	private JTextField DataN_TF;

	/**
	 * Create the frame.
	 */
	public M_GestioneProcuratore(Controller c) {
		controller  = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SchedaProcuratore_L = new JLabel("Scheda del procuratore");
		SchedaProcuratore_L.setFont(new Font("Verdana", Font.PLAIN, 25));
		SchedaProcuratore_L.setBounds(10, 11, 304, 38);
		contentPane.add(SchedaProcuratore_L);
		
		JLabel Nome_L = new JLabel("Nome:");
		Nome_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nome_L.setBounds(10, 71, 143, 25);
		contentPane.add(Nome_L);
		
		JLabel Cognome_L = new JLabel("Cognome:");
		Cognome_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Cognome_L.setBounds(10, 107, 143, 25);
		contentPane.add(Cognome_L);
		
		JLabel CodiceFiscale_L = new JLabel("Codice Fiscale:");
		CodiceFiscale_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CodiceFiscale_L.setBounds(10, 143, 143, 25);
		contentPane.add(CodiceFiscale_L);
		
		JLabel NumeroTelefono_L = new JLabel("Numero di telefono:");
		NumeroTelefono_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NumeroTelefono_L.setBounds(10, 179, 143, 25);
		contentPane.add(NumeroTelefono_L);
		
		JLabel NumeroTelefono2_L = new JLabel("Numero di telefono2:");
		NumeroTelefono2_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NumeroTelefono2_L.setBounds(10, 215, 143, 25);
		contentPane.add(NumeroTelefono2_L);
		
		JLabel Email_L = new JLabel("Email:");
		Email_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Email_L.setBounds(10, 251, 143, 25);
		contentPane.add(Email_L);
		
		JLabel DataN_L = new JLabel("Data di nascita:");
		DataN_L.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DataN_L.setBounds(10, 287, 143, 25);
		contentPane.add(DataN_L);
		
		NumeroTelefono2_TF = new JTextField();
		NumeroTelefono2_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NumeroTelefono2_TF.setEditable(false);
		NumeroTelefono2_TF.setBounds(163, 219, 113, 20);
		contentPane.add(NumeroTelefono2_TF);
		NumeroTelefono2_TF.setColumns(10);
		
		NumeroTelefono_TF = new JTextField();
		NumeroTelefono_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NumeroTelefono_TF.setEditable(false);
		NumeroTelefono_TF.setBounds(163, 183, 113, 20);
		contentPane.add(NumeroTelefono_TF);
		NumeroTelefono_TF.setColumns(10);
		
		CodiceFiscale_TF = new JTextField();
		CodiceFiscale_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CodiceFiscale_TF.setEditable(false);
		CodiceFiscale_TF.setBounds(163, 147, 113, 20);
		contentPane.add(CodiceFiscale_TF);
		CodiceFiscale_TF.setColumns(10);
		
		Cognome_TF = new JTextField();
		Cognome_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Cognome_TF.setEditable(false);
		Cognome_TF.setBounds(163, 111, 113, 20);
		contentPane.add(Cognome_TF);
		Cognome_TF.setColumns(10);
		
		Nome_TF = new JTextField();
		Nome_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nome_TF.setEditable(false);
		Nome_TF.setBounds(163, 75, 113, 20);
		contentPane.add(Nome_TF);
		Nome_TF.setColumns(10);
		
		Email_TF = new JTextField();
		Email_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Email_TF.setEditable(false);
		Email_TF.setBounds(163, 255, 113, 20);
		contentPane.add(Email_TF);
		Email_TF.setColumns(10);
		
		DataN_TF = new JTextField();
		DataN_TF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DataN_TF.setEditable(false);
		DataN_TF.setBounds(163, 291, 113, 20);
		contentPane.add(DataN_TF);
		DataN_TF.setColumns(10);
		
		JButton Collaborazioni_B = new JButton("Collaborazioni");
		Collaborazioni_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se non � presente nessuna collaborazione, apre la dialog NessunaCollaborazione
				//oppure
				//Apre la finestra ListaCollaborazioni
				//setVisible(false);
				
			}
		});
		Collaborazioni_B.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Collaborazioni_B.setBackground(new Color(0, 0, 0));
		Collaborazioni_B.setBounds(401, 71, 207, 43);
		contentPane.add(Collaborazioni_B);
		
		JButton Guadagni_B = new JButton("Guadagni");
		Guadagni_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Si apre la finestra ControllaGuadagni
				//setVisible(false);
			}
		});
		Guadagni_B.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Guadagni_B.setBackground(new Color(0, 0, 0));
		Guadagni_B.setBounds(401, 125, 207, 38);
		contentPane.add(Guadagni_B);
		
		JButton Contratti_B = new JButton("Contratti");
		Contratti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Si apre la finestra SelezionaAtletaContratto, caricando gli atleti del procuratore nella combobox
				//setVisible(false);
			}
		});
		Contratti_B.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Contratti_B.setBackground(new Color(0, 0, 0));
		Contratti_B.setBounds(401, 179, 207, 38);
		contentPane.add(Contratti_B);
		
		JButton Atleti_B = new JButton("Atleti");
		Atleti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Si apre la finestra CercaAtletaDettagli, caricando tutti gli atleti del procuratore nella combobox
				//setVisible(false);
			}
		});
		Atleti_B.setBackground(new Color(0, 0, 0));
		Atleti_B.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Atleti_B.setBounds(401, 228, 207, 43);
		contentPane.add(Atleti_B);
	}
	
	public void setProcuratore (Procuratori procuratore) {
		Nome_TF.setText(procuratore.getNome());
		Cognome_TF.setText(procuratore.getCognome());
		CodiceFiscale_TF.setText(procuratore.getCodiceFiscale());
		NumeroTelefono_TF.setText(procuratore.getNumeroTelefonico());
		NumeroTelefono2_TF.setText(procuratore.getNumeroTelefonico2());
		Email_TF.setText(procuratore.getEmail());
	//	DataN_TF.setText(procuratore.getDataN().toString());
		
		
	}
}
