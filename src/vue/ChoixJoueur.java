package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChoixJoueur extends JFrame {

	private JPanel contentPane;
	private JTextField txtPseudo;

	/**
	 * Create the frame.
	 */
	public ChoixJoueur() {
		setTitle("Choix");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 313); // taille de la frame
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblPrecedent_clic();
			}
		});
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
		});
		
		JLabel lblPersonnage = new JLabel("Ne label");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(145, 115, 116, 118);
		contentPane.add(lblPersonnage);
		
		txtPseudo = new JTextField();
		txtPseudo.setBounds(141, 244, 122, 22);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		lblGo.setBounds(318, 201, 49, 53);
		contentPane.add(lblGo);
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
		});
		lblSuivant.setBounds(298, 137, 31, 53);
		contentPane.add(lblSuivant);
		lblPrecedent.setBounds(61, 145, 38, 45);
		contentPane.add(lblPrecedent);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275); // taille du Jlabel qui contient l'img de fond
		lblFond.setIcon(new ImageIcon("media/fonds/fondchoix.jpg"));
		contentPane.add(lblFond);
	}
	
	private void lblPrecedent_clic(){
		
	}
	
	private void lblSuivant_clic(){
		
	}
	
	private void lblGo_clic(){
		
	}
}
