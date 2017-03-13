package outils.connexion;

import controleur.Controle;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurSocket extends Thread {
	
	private Object leRecepteur;
	private ServerSocket serverSocket;

	/**
	 * Constructeur
	 * @param leRecepteur : recevra l'instance de la classe Controle qui veut solliciter ServeurSocket
	 * @param port : numero de port d'�coute du socket du serveur
	 */
	public ServeurSocket(Object leRecepteur, int port) {
		this.leRecepteur = leRecepteur;
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("erreur grave cr�ation socket serveur" + e);
			System.exit(0);
		}
		start();
		
	}
	
	/**
	 * red�finition de la m�thode abstraite run de la classe Thread
	 */
	public void run(){
		Socket socket;
		while (true) {
			try {
				System.out.println("Le serveur attend...");
				socket = serverSocket.accept();
				System.out.println("Un client s'est connect�");
				new Connection(socket, leRecepteur);
			} catch (IOException e) {
				System.out.println("erreur socket serveur" + e);
				System.exit(0);
			}
		}
	}
}
