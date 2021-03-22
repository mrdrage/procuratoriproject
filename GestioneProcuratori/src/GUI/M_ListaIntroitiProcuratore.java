package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Starter.Controller;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class M_ListaIntroitiProcuratore extends JFrame {
	Controller controller = null;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public M_ListaIntroitiProcuratore(Controller c) {
		controller = c;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 305);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 763, 175);
		contentPane.add(scrollPane);
		
		JList ListaGuadagni_list = new JList();
		scrollPane.setViewportView(ListaGuadagni_list);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBounds(684, 242, 89, 23);
		contentPane.add(Indietro_B);
		
		JLabel ListaGuadagni_L = new JLabel("Ecco la lista di tutti i guadagni del procuratore, divisi per atleta");
		ListaGuadagni_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ListaGuadagni_L.setHorizontalAlignment(SwingConstants.CENTER);
		ListaGuadagni_L.setBounds(10, 11, 763, 31);
		contentPane.add(ListaGuadagni_L);
	}
}
