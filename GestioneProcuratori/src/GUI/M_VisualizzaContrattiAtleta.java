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

public class M_VisualizzaContrattiAtleta extends JFrame {

	Controller controller;
	
	private JPanel contentPane;
    private JList<String> ListaContratti_List;
    private DefaultListModel<String> listmodelClub = new DefaultListModel<String>();
    private DefaultListModel<String> listmodelSponsor = new DefaultListModel<String>();
    
	/**
	 * Create the frame.
	 */
    
	public M_VisualizzaContrattiAtleta(Controller c) {
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 613);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ListaContratti_L = new JLabel("Contratti Atleta");
		ListaContratti_L.setHorizontalAlignment(SwingConstants.CENTER);
		ListaContratti_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ListaContratti_L.setBounds(10, 11, 663, 42);
		contentPane.add(ListaContratti_L);
		
		ListaContratti_List = new JList<String>(listmodelClub);
		ListaContratti_List.setBounds(10, 81, 330, 453);
		contentPane.add(ListaContratti_List);
		//va aggiunta una jlist anche per i contratti sposnor (passandogli listmodelSponsor similmente come fatto coi club
		JButton Esci_B = new JButton("Esci");
		Esci_B.setBackground(new Color(0, 0, 0));
		Esci_B.setBounds(604, 545, 69, 23);
		contentPane.add(Esci_B);
		
		JLabel ContrattiClub_L = new JLabel("ContrattiClub");
		ContrattiClub_L.setBounds(10, 54, 113, 16);
		contentPane.add(ContrattiClub_L);
		
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
}
