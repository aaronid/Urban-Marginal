package outils.connexion;

import controleur.Controle;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class ClientSocket {
	
	private boolean connexionOk;
	
	/**
	 * Constructeur
	 * @ip : ip du serveur auquel il faut se connecter
	 * @port : numéro du port d'écoute du serveur
	 * @leRecepteur : instance Controle vers laquelle il faudra transférer les infos reçues du serveur
	 */
	public ClientSocket(String ip, int port, Object leRecepteur){
		connexionOk = false;
		Socket socket;
		try {
			socket = new Socket(ip, port);
			JOptionPane.showMessageDialog(null, "Connexion au serveur réussie");
			connexionOk = true;
			new Connection(socket, leRecepteur);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Le serveur n'est pas disponible");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "erreur : problème entrée/sortie");
		}
	}
	
	public boolean getConnexionOk(){
		return this.connexionOk;
	}

}
