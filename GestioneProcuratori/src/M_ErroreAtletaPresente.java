import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class M_ErroreAtletaPresente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			M_ErroreAtletaPresente dialog = new M_ErroreAtletaPresente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public M_ErroreAtletaPresente() {
		setBounds(100, 100, 375, 129);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(250, 240, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel ErroreAtletaPresente_L = new JLabel("I dati dell'atleta sono gi\u00E1 presenti.");
			ErroreAtletaPresente_L.setFont(new Font("Verdana", Font.PLAIN, 20));
			ErroreAtletaPresente_L.setBounds(10, -22, 349, 104);
			contentPanel.add(ErroreAtletaPresente_L);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(250, 240, 230));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ok_B = new JButton("OK");
				ok_B.setBackground(new Color(0, 0, 0));
				ok_B.setActionCommand("OK");
				buttonPane.add(ok_B);
				getRootPane().setDefaultButton(ok_B);
			}
			{
				JButton Cancel_B = new JButton("Cancel");
				Cancel_B.setBackground(new Color(0, 0, 0));
				Cancel_B.setActionCommand("Cancel");
				buttonPane.add(Cancel_B);
			}
		}
	}

}
