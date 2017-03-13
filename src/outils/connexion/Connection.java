package outils.connexion;

import controleur.Controle;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class Connection extends Thread{
	
	private Object leRecepteur;
	private ObjectInputStream in; //canal d'entrée pour recevoir les mess provenant de l'ordi distant
	private ObjectOutputStream out; //canal de sortir pour envoyer des mess à l'ordi distant

	/**
	 * Constructeur
	 * @param: socket : socket de l'ordinateur distant
	 * @param: leRecepteur: recevra l'objet leRecepteur de la classe ServerSocket ou ClientSocket
	 */
	public Connection(Socket socket, Object leRecepteur){
		this.leRecepteur = leRecepteur;
		// canal de sortie
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("erreur de création de canal de sortie");
			System.exit(0);
		}
		//canal d'entrée
		try {
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.out.println("erreur de création de canal d'entrée");
			System.exit(0);
		}
		start();
		
	}
	
	/**
	 * redéfinition de la méthode abstraite run() de la classe mère Thread
	 */
	public void run(){
		Boolean inOk = true;
		Object reception;
		while (inOk = true){
			try {
				reception = in.readObject();
			} catch (ClassNotFoundException e) {
				System.out.println("erreur : classe non trouvée");
				System.exit(0);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "L'ordinateur distant s'est déconnecté");
				inOk = false;
				try {
					in.close();
				} catch (IOException e1) {
					System.out.println("erreur lors de la fermeture du canal");
				}
			}
		}
	}
	
	public void envoi(Object unObjet){
		try {
			out.writeObject(unObjet);
			out.flush();
		} catch (IOException e) {
			System.out.println("erreur sur out");
		}
	}
	
}
