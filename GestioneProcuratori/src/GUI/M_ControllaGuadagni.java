package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_ControllaGuadagni extends JFrame {
	Controller controller = null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_ControllaGuadagni(Controller c) {
		controller = c;
		setBackground(new Color(245, 245, 220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 263);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ControllaGuadagni_L = new JLabel("Controlla i guadagni del procuratore");
		ControllaGuadagni_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ControllaGuadagni_L.setHorizontalAlignment(SwingConstants.CENTER);
		ControllaGuadagni_L.setBounds(0, 11, 424, 37);
		contentPane.add(ControllaGuadagni_L);
		
		JButton Annuali_B = new JButton("Annuali");
		Annuali_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Appare la finestra SelezionaAnno, caricando giá gli anni nella combobox
				//setVisible(false);
			}
		});
		Annuali_B.setBackground(new Color(0, 0, 0));
		Annuali_B.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Annuali_B.setBounds(10, 78, 414, 30);
		contentPane.add(Annuali_B);
		
		JButton Mensili_B = new JButton("Mensili");
		Mensili_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Appare la finestra SelezionaMese, caricando giá i mesi e gli anni nella combobox
				//setVisible(false);
			}
		});
		Mensili_B.setBackground(new Color(0, 0, 0));
		Mensili_B.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Mensili_B.setBounds(10, 119, 414, 30);
		contentPane.add(Mensili_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Torna alla schermata GestioneProcuratore
				//setVisible(false);
			}
		});
		Indietro_B.setBackground(new Color(0, 0, 0));
		Indietro_B.setBounds(353, 190, 71, 23);
		contentPane.add(Indietro_B);
	}
}
