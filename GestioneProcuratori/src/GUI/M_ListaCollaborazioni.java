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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_ListaCollaborazioni extends JFrame {
 
	Controller controller = null;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public M_ListaCollaborazioni(Controller c) {
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ListaCollaborazioni_L = new JLabel("Ecco la lista delle collaborazioni del procuratore:");
		ListaCollaborazioni_L.setFont(new Font("Verdana", Font.PLAIN, 22));
		ListaCollaborazioni_L.setBounds(10, -22, 576, 91);
		contentPane.add(ListaCollaborazioni_L);
		
		JList ListaCollaborazioni_list = new JList();
		ListaCollaborazioni_list.setBounds(10, 56, 576, 309);
		contentPane.add(ListaCollaborazioni_list);
		
		JButton Aggiungi_B = new JButton("Aggiungi collaborazione");
		Aggiungi_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Apre la finestra NuovoAtletaCollab
				//setVisible(false);
			}
		});
		Aggiungi_B.setBackground(Color.BLACK);
		Aggiungi_B.setBounds(20, 376, 145, 23);
		contentPane.add(Aggiungi_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Torna alla finestra GestioneProcuratore
				//setVisible(false);
			}
		});
		Indietro_B.setBackground(Color.BLACK);
		Indietro_B.setBounds(514, 401, 72, 23);
		contentPane.add(Indietro_B);
	}
}
