package controleur;
/**
 * classe controle
 * execution du main
 * instantiation de la classe où se trouve le main
 * execution du constructeur qui lui-même instantie la classe EntreeJeu (frame) et la rend visible
 * 2 roles: gérer les évènements provenant du modele et ceux provenant de la vue
 */

import vue.EntreeJeu;
import vue.Arene;
import vue.ChoixJoueur;
import javax.swing.JFrame;
import outils.connexion.ServeurSocket;
import outils.connexion.ClientSocket;
import modele.Jeu;
import modele.JeuServeur;
import modele.JeuClient;

public class Controle {
	
	private EntreeJeu frmEntreeJeu;
	private Jeu leJeu;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;

	public static void main(String[] args) {
		new Controle() ;
	}
	
	/**
	 * constructeur
	 */
	public Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		this.frmEntreeJeu.setVisible(true);
	}
	
	/**
	 * events package vue
	 */	
	
	public void evenementVue(JFrame uneFrame, Object info) {
		if (uneFrame instanceof EntreeJeu) {
			evenementEntreeJeu(info);
		}
	}

	public void evenementEntreeJeu(Object info) {
		if ((String) info == "serveur"){
			new ServeurSocket(this, 6666);
			this.leJeu = new JeuServeur(this);
			frmEntreeJeu.dispose();
			frmArene = new Arene();
			frmArene.setVisible(true);
		}else{
			(new ClientSocket((String) info, 6666, this)).getConnexionOk();
			this.leJeu = new JeuClient(this);
			frmArene = new Arene();
			frmEntreeJeu.dispose();
			frmChoixJoueur = new ChoixJoueur();
			frmChoixJoueur.setVisible(true);
		}
		
	}
	
	
	
	/**
	 * events package modele
	 */

}
