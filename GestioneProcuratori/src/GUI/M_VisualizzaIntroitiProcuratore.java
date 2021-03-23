package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;
import entita.Procuratori;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_VisualizzaIntroitiProcuratore extends JFrame {
	
	Controller controller;

	private JPanel contentPane;
	private JTextField Procuratore_TF;
	private JTextField GuadagnoCollab_TF;
	private JTextField GuadagnoSponsor_TF;
	private JTextField Totale_TF;

	/**
	 * Create the frame.
	 */
	
	public M_VisualizzaIntroitiProcuratore(Controller c) {
		
		controller = c;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Procuratore_TF = new JTextField();
		Procuratore_TF.setEditable(false);
		Procuratore_TF.setBounds(10, 58, 157, 28);
		contentPane.add(Procuratore_TF);
		Procuratore_TF.setColumns(10);
		
		GuadagnoCollab_TF = new JTextField();
		GuadagnoCollab_TF.setEditable(false);
		GuadagnoCollab_TF.setBounds(231, 58, 157, 28);
		contentPane.add(GuadagnoCollab_TF);
		GuadagnoCollab_TF.setColumns(10);
		
		GuadagnoSponsor_TF = new JTextField();
		GuadagnoSponsor_TF.setEditable(false);
		GuadagnoSponsor_TF.setBounds(417, 58, 157, 28);
		contentPane.add(GuadagnoSponsor_TF);
		GuadagnoSponsor_TF.setColumns(10);
		
		Totale_TF = new JTextField();
		Totale_TF.setEditable(false);
		Totale_TF.setBounds(641, 58, 109, 28);
		contentPane.add(Totale_TF);
		Totale_TF.setColumns(10);
		
		JLabel Procuratore_L = new JLabel("Procuratore");
		Procuratore_L.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Procuratore_L.setBounds(10, 32, 129, 14);
		contentPane.add(Procuratore_L);
		
		JLabel GuadagnoCollab_L = new JLabel("Guadagno collaborazione");
		GuadagnoCollab_L.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GuadagnoCollab_L.setBounds(231, 31, 157, 16);
		contentPane.add(GuadagnoCollab_L);
		
		JLabel GuadagnoSponsor_L = new JLabel("Guadagno dagli sponsor");
		GuadagnoSponsor_L.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GuadagnoSponsor_L.setBounds(417, 31, 157, 16);
		contentPane.add(GuadagnoSponsor_L);
		
		JLabel Totale_L = new JLabel("Totale");
		Totale_L.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Totale_L.setBounds(641, 32, 109, 14);
		contentPane.add(Totale_L);
		
		JButton Ok_B = new JButton("Ok");
		Ok_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Ok_B.setBounds(684, 97, 66, 23);
		contentPane.add(Ok_B);
		
		
	}
	
	public void setCampi(Procuratori Procuratore, double guadagnocollaborazione, double guadagnosponsor, double totale) {
		
		
		Procuratore_TF.setText(Procuratore.getNome() + Procuratore.getCognome());
		
		String guadagnoCollaborazione = Double.toString(guadagnocollaborazione);
		String guadagnoSponsor = Double.toString(guadagnosponsor);
		String Totale = Double.toString(totale);
		
		
		GuadagnoCollab_TF.setText(guadagnoCollaborazione);
		GuadagnoSponsor_TF.setText(guadagnoSponsor);
		Totale_TF.setText(Totale);
	}
}
