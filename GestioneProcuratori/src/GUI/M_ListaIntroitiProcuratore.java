package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_ListaIntroitiProcuratore extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JList<String> ListaGuadagni_list;
	private DefaultListModel<String> listmodelIntroiti = new DefaultListModel<String>();

	/**
	 * Create the frame.
	 */
	public M_ListaIntroitiProcuratore(Controller c) {
		
		controller = c;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 335);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 763, 175);
		contentPane.add(scrollPane);
		
		ListaGuadagni_list = new JList<String>(listmodelIntroiti);
		scrollPane.setViewportView(ListaGuadagni_list);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBounds(684, 258, 89, 23);
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.TornaGestioneProcuratore();
			}
		});
		contentPane.add(Indietro_B);
		
		JLabel ListaGuadagni_L = new JLabel("Lista di tutti i guadagni del procuratore, divisi per atleta");
		ListaGuadagni_L.setBounds(10, 0, 763, 31);
		ListaGuadagni_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ListaGuadagni_L.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(ListaGuadagni_L);
		
		JLabel lblNewLabel = new JLabel("(Nome atleta, Cognome atleta, Guadagno procuratore dalla collaborazione, Guadagno dai contratti sponsor dell'atleta, Totale guadagni)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel.setBounds(10, 52, 697, 14);
		contentPane.add(lblNewLabel);
	}
	
	public void setListaIntroiti(List <String> introiti) {
		
		int indice = 0;
				
		Iterator<String> i = introiti.iterator();
		while(i.hasNext()) {
			listmodelIntroiti.add(indice, i.next());
					
		indice++;	
		}	 
		 
	}
	
	public void clearListIntroiti () {
		
		listmodelIntroiti.removeAllElements();
	}
}
