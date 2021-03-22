package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;
import entita.ContrattoClub;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_VisualizzaContrattiAtleta extends JFrame {

	Controller controller;
	
	private JPanel contentPane;
	private JList<String> listaContrattiSponsor_List;
    private JList<String> listaContrattiClub_List;
    private DefaultListModel<String> listmodelClub = new DefaultListModel<String>();
    private DefaultListModel<String> listmodelSponsor = new DefaultListModel<String>();
    
	/**
	 * Create the frame.
	 */
    
	public M_VisualizzaContrattiAtleta(Controller c) {
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ListaContratti_L = new JLabel("Contratti Atleta");
		ListaContratti_L.setBounds(10, 0, 1014, 42);
		ListaContratti_L.setHorizontalAlignment(SwingConstants.CENTER);
		ListaContratti_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		contentPane.add(ListaContratti_L);
		//va aggiunta una jlist anche per i contratti sposnor (passandogli listmodelSponsor similmente come fatto coi club
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.TornaASelezionaAtletaContratto();
				
			}
		});
		Indietro_B.setBounds(928, 602, 84, 23);
		Indietro_B.setBackground(Color.WHITE);
		contentPane.add(Indietro_B);
		
		JLabel ContrattiClub_L = new JLabel("Contratti club");
		ContrattiClub_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ContrattiClub_L.setBounds(10, 267, 122, 16);
		contentPane.add(ContrattiClub_L);
		
		JLabel ContrattiSponsor_L = new JLabel("Contratti sponsor");
		ContrattiSponsor_L.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ContrattiSponsor_L.setBounds(10, 541, 133, 15);
		contentPane.add(ContrattiSponsor_L);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(990, 475, -42, -134);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 333, 1014, 197);
		contentPane.add(scrollPane_1);
		
		listaContrattiSponsor_List = new JList<String>(listmodelSponsor);
		scrollPane_1.setViewportView(listaContrattiSponsor_List);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 67, 1014, 197);
		contentPane.add(scrollPane_2);
		
		listaContrattiClub_List = new JList<String>(listmodelClub);
		scrollPane_2.setViewportView(listaContrattiClub_List);
		
	}
	
	public void setListaContrattiClub(List <String> contratti) {
		
		int indice = 0;
		
		 Iterator<String> i = contratti.iterator();
		 while(i.hasNext()) {
			 listmodelClub.add(indice, i.next());
		
			 
	    indice++;
	    }
	}	 
		
		 
	public void setListaContrattiSponsor(List <String> contratti) {
				
		int indice = 0;
				
		Iterator<String> i = contratti.iterator();
		while(i.hasNext()) {
			listmodelSponsor.add(indice, i.next());
					
		indice++;	
		}	 
		 
	}
	
	public void clearListContrattiClub () {
		listmodelClub.removeAllElements();
	}
	
	public void clearListContrattiSponsor () {
		listmodelSponsor.removeAllElements();
	}
}
