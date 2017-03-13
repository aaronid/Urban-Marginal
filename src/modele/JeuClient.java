package modele;

import outils.connexion.Connection;
import controleur.Controle;

public class JeuClient extends Jeu {
	
	/**
	 * Constructeur
	 * @param controle
	 */
	public JeuClient(Controle controle){
		super.controle = controle;
	}

	@Override
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reception(Connection connection, Object info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deconnection(Connection connection) {
		// TODO Auto-generated method stub
		
	}

}
