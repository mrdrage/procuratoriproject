package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class M_VisualizzaContrattiAtleta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_VisualizzaContrattiAtleta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 613);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ListaContratti_L = new JLabel("Ecco la lista dei contratti dell'atleta:");
		ListaContratti_L.setHorizontalAlignment(SwingConstants.CENTER);
		ListaContratti_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ListaContratti_L.setBounds(10, 11, 663, 59);
		contentPane.add(ListaContratti_L);
		
		JList ListaContratti_List = new JList();
		ListaContratti_List.setBounds(10, 81, 663, 453);
		contentPane.add(ListaContratti_List);
		
		JButton Esci_B = new JButton("Esci");
		Esci_B.setBackground(new Color(0, 0, 0));
		Esci_B.setBounds(604, 545, 69, 23);
		contentPane.add(Esci_B);
	}

}
