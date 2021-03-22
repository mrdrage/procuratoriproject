package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class M_CercaAtletaDettagli extends JFrame {
	
	Controller controller = null;

	private JPanel contentPane;
	private JComboBox<String> CercaAtletaDettagli_CB;
	
	/**
	 * Create the frame.
	 */
	
	public M_CercaAtletaDettagli(Controller c) {
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 210);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CercaAtletaDettagli_L = new JLabel("Seleziona un Atleta");
		CercaAtletaDettagli_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		CercaAtletaDettagli_L.setHorizontalAlignment(SwingConstants.CENTER);
		CercaAtletaDettagli_L.setBounds(10, 11, 413, 33);
		contentPane.add(CercaAtletaDettagli_L);
		
		CercaAtletaDettagli_CB = new JComboBox();
		CercaAtletaDettagli_CB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CercaAtletaDettagli_CB.setBounds(99, 55, 237, 33);
		contentPane.add(CercaAtletaDettagli_CB);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBackground(new Color(0, 0, 0));
		Indietro_B.setBounds(249, 137, 93, 23);
		contentPane.add(Indietro_B);
		
		JButton Avanti_B = new JButton("Avanti");
		Avanti_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					controller.VisualizzaInfoAtleta((String)CercaAtletaDettagli_CB.getSelectedItem());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//Apre la finestra DettagliAtleta, caricando prima i dati dell'atleta selezionato 
				//setVisible(false);
			}
		});
		Avanti_B.setBackground(new Color(0, 0, 0));
		Avanti_B.setBounds(352, 137, 71, 23);
		contentPane.add(Avanti_B);
	}

	public void setAtletiComboBox (List<String> atleti) {
		Iterator<String> i = atleti.iterator();
		
		while (i.hasNext()) {
			CercaAtletaDettagli_CB.addItem(i.next()); 
		}
	}
}
