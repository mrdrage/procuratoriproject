package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class VisualizzaIntroitiProcuratore extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizzaIntroitiProcuratore frame = new VisualizzaIntroitiProcuratore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualizzaIntroitiProcuratore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 58, 157, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(231, 58, 157, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(417, 58, 157, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(641, 58, 109, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
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
}
