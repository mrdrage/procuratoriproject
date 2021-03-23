package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class M_GestioneGettoneNazionale extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JList GettoneNazionale_List;
	private DefaultListModel<String> listmodelGettoni = new DefaultListModel<String>();
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	
	public M_GestioneGettoneNazionale(Controller c) {
		setResizable(false);
		
		controller = c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GettoneNazionale_List = new JList<String>(listmodelGettoni);
		GettoneNazionale_List.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GettoneNazionale_List.setBounds(35, 53, 435, 276);
		contentPane.add(GettoneNazionale_List);
		
		JLabel GettoneNazionale_L = new JLabel("Questi sono i gettoni nazionale dell'atleta: ");
		GettoneNazionale_L.setHorizontalAlignment(SwingConstants.CENTER);
		GettoneNazionale_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		GettoneNazionale_L.setBounds(10, 0, 483, 32);
		contentPane.add(GettoneNazionale_L);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.TornaADettagliAtleta();
			}
		});
		Indietro_B.setBackground(UIManager.getColor("Button.background"));
		Indietro_B.setBounds(377, 364, 93, 23);
		contentPane.add(Indietro_B);
		
		lblNewLabel = new JLabel("(Data presenza gettone, Guadagno del gettone)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel.setBounds(38, 38, 241, 14);
		contentPane.add(lblNewLabel);
	}
	
	public void setListaGettoniNazionale(List <String> gettoni) {
		
		int indice = 0;
				
		Iterator<String> i = gettoni.iterator();
		while(i.hasNext()) {
			listmodelGettoni.add(indice, i.next());
					
		indice++;	
		}	 
		 
	}
	
	public void clearListGettoniNazionale () {
		
		listmodelGettoni.removeAllElements();
	}

}
