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
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class M_NuovaCollaborazione extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JTextField DataInizio_TF;
	private JTextField DataFine_TF;
	private JTextField StipendioMensile_TF;
	private JComboBox<String> Atleta_CB;
	
	/**
	 * Create the frame.
	 */
	
	public M_NuovaCollaborazione(Controller c) {
		
		controller  = c;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 286);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Aggiungi collaborazione");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 0, 540, 31);
		contentPane.add(lblNewLabel);
		
		JLabel Atleta_L = new JLabel("Atleta:");
		Atleta_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Atleta_L.setBounds(10, 65, 69, 14);
		contentPane.add(Atleta_L);
		
		JLabel DataInizio_L = new JLabel("Data di inizio:");
		DataInizio_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataInizio_L.setBounds(10, 90, 99, 14);
		contentPane.add(DataInizio_L);
		
		JLabel DataFine_L = new JLabel("Data di fine:");
		DataFine_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		DataFine_L.setBounds(10, 115, 89, 14);
		contentPane.add(DataFine_L);
		
		JLabel StipendioMensile_T = new JLabel("Stipendio mensile del procuratore:");
		StipendioMensile_T.setFont(new Font("Tahoma", Font.PLAIN, 14));
		StipendioMensile_T.setBounds(10, 150, 217, 18);
		contentPane.add(StipendioMensile_T);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.TornaAlistaCollaborazioni();
				
			}
		});
		
		Indietro_B.setBackground(Color.WHITE);
		Indietro_B.setBounds(367, 220, 71, 23);
		contentPane.add(Indietro_B);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String InfoAtleta = (String) Atleta_CB.getSelectedItem();
				
                double stipendiomensile = Double.parseDouble(StipendioMensile_TF.getText());
				
				try {
					
					controller.InserisciCollaborazione(DataInizio_TF.getText(), DataFine_TF.getText(), stipendiomensile, InfoAtleta);
					
					//svuoto i campi				
					DataInizio_TF.setText("");
					DataFine_TF.setText("");
					StipendioMensile_TF.setText("");
					
				} catch (SQLException  e1) {
                     
					controller.ErroreInserimentoDatabase();
					e1.printStackTrace();
					
				} catch (ParseException e2) {
					
					controller.ErroreInserimentoData();
					e2.printStackTrace();
					
				}
				
				
				controller.tornaAllaListaCollaborazioni();
				
			}
		});
		
		Avanti_B.setBackground(Color.WHITE);
		Avanti_B.setBounds(448, 220, 69, 23);
		contentPane.add(Avanti_B);
		
		DataInizio_TF = new JTextField();
		DataInizio_TF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bravo!");
			}
		});
		
		DataInizio_TF.setBounds(249, 89, 108, 20);
		contentPane.add(DataInizio_TF);
		DataInizio_TF.setColumns(10);
		
		DataFine_TF = new JTextField();
		DataFine_TF.setBounds(249, 114, 108, 20);
		contentPane.add(DataFine_TF);
		DataFine_TF.setColumns(10);
		
		Atleta_CB = new JComboBox<String>();
		Atleta_CB.setBounds(249, 65, 268, 18);
		contentPane.add(Atleta_CB);
		
		
		StipendioMensile_TF = new JTextField();
		StipendioMensile_TF.setBounds(249, 148, 86, 20);
		contentPane.add(StipendioMensile_TF);
		StipendioMensile_TF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u20AC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(237, 149, 22, 18);
		contentPane.add(lblNewLabel_1);
	}
	
	public void setAtletiLiberiComboBox (List<String> atleti) {
		
		Iterator<String> i = atleti.iterator();
		
		while (i.hasNext()) {
			Atleta_CB.addItem(i.next()); 
		}
	}
	
	public void clearAtletiLiberiComboBox() {
		
		Atleta_CB.removeAllItems();
	}
}
