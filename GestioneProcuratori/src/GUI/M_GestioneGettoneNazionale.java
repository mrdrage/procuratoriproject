package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class M_GestioneGettoneNazionale extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_GestioneGettoneNazionale() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList GettoneNazionale_List = new JList();
		GettoneNazionale_List.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GettoneNazionale_List.setBounds(35, 56, 435, 276);
		contentPane.add(GettoneNazionale_List);
		
		JLabel GettoneNazionale_L = new JLabel("Questi sono i gettoni nazionale dell'atleta: ");
		GettoneNazionale_L.setHorizontalAlignment(SwingConstants.CENTER);
		GettoneNazionale_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		GettoneNazionale_L.setBounds(23, 11, 445, 32);
		contentPane.add(GettoneNazionale_L);
		
		JButton Ok_B = new JButton("Ok");
		Ok_B.setBackground(new Color(0, 0, 0));
		Ok_B.setBounds(404, 393, 66, 23);
		contentPane.add(Ok_B);
		
		JButton Indietro_B = new JButton("Indietro");
		Indietro_B.setBackground(new Color(0, 0, 0));
		Indietro_B.setBounds(323, 393, 71, 23);
		contentPane.add(Indietro_B);
	}

}
