package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;

public class M_ControllaGuadagniMensili extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_ControllaGuadagniMensili() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ControllaGuadagni_L = new JLabel("Ecco i guadagni del mese selezionato: ");
		ControllaGuadagni_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ControllaGuadagni_L.setBounds(10, 11, 529, 52);
		contentPane.add(ControllaGuadagni_L);
		
		JList ControllaGuadagniMensili_List = new JList();
		ControllaGuadagniMensili_List.setBounds(10, 74, 606, 301);
		contentPane.add(ControllaGuadagniMensili_List);
		
		JButton Ok_B = new JButton("Ok");
		Ok_B.setBackground(new Color(0, 0, 0));
		Ok_B.setBounds(571, 386, 45, 23);
		contentPane.add(Ok_B);
	}

}
