import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_SelezionaAtletaContratto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public M_SelezionaAtletaContratto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 204);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ScegliAtleta_L = new JLabel("Seleziona un atleta: ");
		ScegliAtleta_L.setFont(new Font("Verdana", Font.PLAIN, 20));
		ScegliAtleta_L.setHorizontalAlignment(SwingConstants.CENTER);
		ScegliAtleta_L.setBounds(10, 11, 414, 51);
		contentPane.add(ScegliAtleta_L);
		
		JComboBox ScegliAtleta_CO = new JComboBox();
		ScegliAtleta_CO.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ScegliAtleta_CO.setBounds(10, 66, 414, 32);
		contentPane.add(ScegliAtleta_CO);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(370, 136, 54, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(289, 136, 71, 23);
		contentPane.add(btnNewButton_1);
	}

}
