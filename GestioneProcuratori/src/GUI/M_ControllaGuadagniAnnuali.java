package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;

public class M_ControllaGuadagniAnnuali extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_ControllaGuadagniAnnuali() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ControllaGuadagni_L = new JLabel("Ecco i guadagni dell'anno selezionato:");
		ControllaGuadagni_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ControllaGuadagni_L.setBounds(10, 11, 462, 52);
		contentPane.add(ControllaGuadagni_L);
		
		JList ControllaGuadagniAnnuali_List = new JList();
		ControllaGuadagniAnnuali_List.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ControllaGuadagniAnnuali_List.setBounds(10, 74, 588, 292);
		contentPane.add(ControllaGuadagniAnnuali_List);
		
		JButton Indietro_B = new JButton("Ok");
		Indietro_B.setBackground(new Color(0, 0, 0));
		Indietro_B.setBounds(553, 390, 45, 23);
		contentPane.add(Indietro_B);
	}
}
