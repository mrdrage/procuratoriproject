package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class M_SelezionaAtletaContratto extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JComboBox<String> ScegliAtleta_CO;

	/**
	 * Create the frame.
	 */
	
	public M_SelezionaAtletaContratto(Controller c) {
		setResizable(false);
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 245);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ScegliAtleta_L = new JLabel("Seleziona un atleta: ");
		ScegliAtleta_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ScegliAtleta_L.setHorizontalAlignment(SwingConstants.CENTER);
		ScegliAtleta_L.setBounds(10, 0, 414, 51);
		contentPane.add(ScegliAtleta_L);
		
		ScegliAtleta_CO = new JComboBox();
		ScegliAtleta_CO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ScegliAtleta_CO.setBounds(10, 62, 414, 32);
		contentPane.add(ScegliAtleta_CO);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.tornaAGestioneProcuratore();
			}
		});
		
		Indietro_B.setBackground(Color.WHITE);
		Indietro_B.setBounds(331, 177, 93, 23);
		contentPane.add(Indietro_B);
		
		JButton VisualizzaContratti_B = new JButton("Visualizza i contratti");
		VisualizzaContratti_B.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VisualizzaContratti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(((String) ScegliAtleta_CO.getSelectedItem()) == null ) {
						controller.erroreComboBoxAtletiVuota();
					}else {
					controller.iniziaRicercaContrattiAtleta((String) ScegliAtleta_CO.getSelectedItem());
					}
					
				} catch (SQLException e1) {
					
					controller.ErroreLetturaDatabase();
					e1.printStackTrace();
				}
				//Apre la finestra SelezionaAtletaContratto, caricando prima i contratti relativi a quell'atleta
			}
		});
		
		VisualizzaContratti_B.setBackground(UIManager.getColor("Button.background"));
		VisualizzaContratti_B.setBounds(10, 109, 188, 23);
		contentPane.add(VisualizzaContratti_B);
		
		JButton InserisciContrattoClub_B = new JButton("Inserisci contratto Club");
		InserisciContrattoClub_B.setFont(new Font("Tahoma", Font.PLAIN, 10));
		InserisciContrattoClub_B.setBackground(UIManager.getColor("Button.background"));
		InserisciContrattoClub_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(((String) ScegliAtleta_CO.getSelectedItem()) == null ) {
						controller.erroreComboBoxAtletiVuota();
					}else {
					controller.InserisciContrattoClub((String) ScegliAtleta_CO.getSelectedItem());

					}

				} catch (SQLException e1) {
					
					controller.ErroreInserimentoDatabase();
					e1.printStackTrace();
				}
			}
		});
		
		InserisciContrattoClub_B.setBounds(10, 143, 188, 23);
		contentPane.add(InserisciContrattoClub_B);
		
		JButton InserisciContrattoSponsor_B = new JButton("Inserisci contratto Sponsor");
		InserisciContrattoSponsor_B.setFont(new Font("Tahoma", Font.PLAIN, 10));
		InserisciContrattoSponsor_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(((String) ScegliAtleta_CO.getSelectedItem()) == null ) {
						controller.erroreComboBoxAtletiVuota();
					}else {
					controller.InserisciContrattoSponsor((String) ScegliAtleta_CO.getSelectedItem());
					}
					
				} catch (SQLException e1) {
					
					controller.ErroreInserimentoDatabase();
					e1.printStackTrace();
				}
			}
		});
		
		InserisciContrattoSponsor_B.setBackground(UIManager.getColor("Button.background"));
		InserisciContrattoSponsor_B.setBounds(10, 177, 188, 23);
		contentPane.add(InserisciContrattoSponsor_B);
		
		JButton Introiti_B = new JButton("Visualizza gli introiti");
		Introiti_B.setFont(new Font("Tahoma", Font.PLAIN, 10));
		Introiti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(((String) ScegliAtleta_CO.getSelectedItem()) == null ) {
						controller.erroreComboBoxAtletiVuota();
					}else {
					controller.VisualizzaIntroitiProcuratore((String) ScegliAtleta_CO.getSelectedItem());
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Introiti_B.setBounds(234, 109, 188, 23);
		contentPane.add(Introiti_B);
	}

	
	public void setContrattiComboBox(List<String> atleti) {

		Iterator<String> i = atleti.iterator();
		
		while (i.hasNext()) {
			ScegliAtleta_CO.addItem(i.next()); 
		}
	}
	
	public void clearContrattiComboBox () {
		
		ScegliAtleta_CO.removeAllItems();
	
	}
}
