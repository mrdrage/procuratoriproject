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

public class M_VisualizzaIntroitiProcuratore extends JFrame {
	Controller controller = null;

	private JPanel contentPane;
	private JTextField Procuratore_TF;
	private JTextField GuadagnoCollab_TF;
	private JTextField GuadagnoSponsor_TF;
	private JTextField Totale_TF;

	/**
	 * Launch the application.
	 */
	

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
		
		JLabel lblNewLabel = new JLabel("Procuratore");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 32, 129, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guadagno collaborazione");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(231, 31, 157, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Guadagno dagli sponsor");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(417, 31, 157, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Totale");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(641, 32, 109, 14);
		contentPane.add(lblNewLabel_3);
		
		
	}
	
	public void inserisciCampi(Procuratori Procuratore, double guadagnocollaborazione, double guadagnosponsor, double totale) {
		
		
		Procuratore_TF.setText(Procuratore.getNome() + Procuratore.getCognome());
		
		String guadagnoCollaborazione = Double.toString(guadagnocollaborazione);
		String guadagnoSponsor = Double.toString(guadagnosponsor);
		String Totale = Double.toString(totale);
		
		
		GuadagnoCollab_TF.setText(guadagnoCollaborazione);
		GuadagnoSponsor_TF.setText(guadagnoSponsor);
		Totale_TF.setText(Totale);
	}
	
}
