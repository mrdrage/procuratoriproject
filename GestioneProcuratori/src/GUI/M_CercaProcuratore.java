package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class M_CercaProcuratore extends JFrame {

	private JPanel contentPane;
	private JComboBox CercaProcuratore_CO;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public M_CercaProcuratore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 174);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel CercaProcuratore_L = new JLabel("Cerca un procuratore");
		CercaProcuratore_L.setFont(new Font("Verdana", Font.PLAIN, 18));
		CercaProcuratore_L.setBounds(105, 11, 192, 45);
		contentPane.add(CercaProcuratore_L);
		
		JButton CercaProcuratore_B = new JButton("Cerca");
		CercaProcuratore_B.setBounds(337, 101, 61, 23);
		contentPane.add(CercaProcuratore_B);
		
		CercaProcuratore_CO = new JComboBox();
		CercaProcuratore_CO.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CercaProcuratore_CO.setBounds(85, 67, 234, 23);
		contentPane.add(CercaProcuratore_CO);
	}
}
