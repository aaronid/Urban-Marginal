package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EntreeJeu extends JFrame {

	private JPanel contentPane;
	private JTextField txtIp;
	private Controle controle;
	
	/**
	 * clic sur le bouton Start pour lancer le serveur
	 */
	private void btnStart_Clic() {
		controle.evenementVue(this, "serveur");
	}
	
	/**
	 * clic sur le bouton Connect pour se connecter à un serveur
	 */
	private void btnConnect_Clic() {
		controle.evenementVue(this, txtIp.getText());
	}
	
	/**
	 * clic sur le bouton Exit pour quitter l'application
	 */
	private void btnExit_Clic() {
		System.exit(0);
	}
		

	/**
	 * Create the frame.
	 * @param controle 
	 */
	public EntreeJeu(Controle controle) {
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Start"); //constructeur avec le titre en param
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnStart_Clic();
			}
		});
		
		btnStart.setBounds(252, 41, 130, 34); //taille
		contentPane.add(btnStart); //integration de l'objet avec add dans le Jpanel général (contentPane)
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnConnect_Clic();
			}
		});
		btnConnect.setBounds(252, 131, 130, 34);
		contentPane.add(btnConnect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExit_Clic();
			}
		});
		btnExit.setBounds(252, 184, 130, 34);
		contentPane.add(btnExit);
		
		JLabel lblStartServ = new JLabel("Start a server :");
		lblStartServ.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStartServ.setBounds(56, 46, 130, 24);
		contentPane.add(lblStartServ);
		
		JLabel lblConnect = new JLabel("Connect an existing server :");
		lblConnect.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConnect.setBounds(56, 101, 191, 14);
		contentPane.add(lblConnect);
		
		JLabel lblIp = new JLabel("IP server :");
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIp.setBounds(56, 141, 66, 14);
		contentPane.add(lblIp);
		
		txtIp = new JTextField();
		txtIp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(121, 138, 93, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		this.controle = controle;
	}
}
