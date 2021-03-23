package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class M_ListaCollaborazioni extends JFrame {
 
	Controller controller;
	
	private JPanel contentPane;
	private JList<String> ListaCollaborazioni_list;
	private DefaultListModel<String> listmodelCollaborazioni = new DefaultListModel<String>();
	
	/**
	 * Create the frame.
	 */
	
	public M_ListaCollaborazioni(Controller c) {

		controller = c;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ListaCollaborazioni_L = new JLabel("Lista collaborazioni del procuratore:");
		ListaCollaborazioni_L.setHorizontalAlignment(SwingConstants.CENTER);
		ListaCollaborazioni_L.setFont(new Font("Verdana", Font.PLAIN, 22));
		ListaCollaborazioni_L.setBounds(10, 0, 576, 37);
		contentPane.add(ListaCollaborazioni_L);
		
		ListaCollaborazioni_list = new JList<String>(listmodelCollaborazioni);
		ListaCollaborazioni_list.setBounds(10, 56, 576, 309);
		contentPane.add(ListaCollaborazioni_list);
		
		JButton Aggiungi_B = new JButton("Aggiungi collaborazione");
		Aggiungi_B.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Aggiungi_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					controller.aggiungiAtletaCollab();
					
			}
		});
		
		Aggiungi_B.setBackground(Color.WHITE);
		Aggiungi_B.setBounds(10, 376, 166, 37);
		contentPane.add(Aggiungi_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.TornaAGestioneProcuratore();	
				
			}
		});
		
		Indietro_B.setBackground(Color.WHITE);
		Indietro_B.setBounds(497, 390, 89, 23);
		contentPane.add(Indietro_B);
		
		JLabel lblNewLabel = new JLabel("(Data di inizio, Data di fine, Stipendio mensile del procuratore)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 37, 257, 14);
		contentPane.add(lblNewLabel);
	}
	
	 
	public void setListaCollaborazioni(List <String> collaborazioni) {
				
		int indice = 0;
				
		Iterator<String> i = collaborazioni.iterator();
		while(i.hasNext()) {
			listmodelCollaborazioni.add(indice, i.next());
					
		indice++;	
		}	 
		 
	}
	
	public void clearListCollaborazioni() {
		
		listmodelCollaborazioni.removeAllElements();
	}
}
