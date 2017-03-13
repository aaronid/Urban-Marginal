package modele;

import controleur.Controle;
import outils.connexion.Connection;

public abstract class Jeu {
	
	protected Controle controle;

	/**
	 * setter sur connection red�finit par les classes filles
	 * @param connection
	 */
	public abstract void setConnection(Connection connection);

	/**
	 * m�thode r�ception
	 * @param connection : savoir qui a envoy� le message
	 * @param info : message envoy� par l'ordinateur distant
	 */
	public abstract void reception(Connection connection, Object info);
	
	public void envoi(Connection connection, Object info){
		connection.envoi(info);
	}
	
	public abstract void deconnection(Connection connection);
}
