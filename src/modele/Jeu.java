package modele;

import controleur.Controle;
import outils.connexion.Connection;

public abstract class Jeu {
	
	protected Controle controle;

	/**
	 * setter sur connection redéfinit par les classes filles
	 * @param connection
	 */
	public abstract void setConnection(Connection connection);

	/**
	 * méthode réception
	 * @param connection : savoir qui a envoyé le message
	 * @param info : message envoyé par l'ordinateur distant
	 */
	public abstract void reception(Connection connection, Object info);
	
	public void envoi(Connection connection, Object info){
		connection.envoi(info);
	}
	
	public abstract void deconnection(Connection connection);
}
