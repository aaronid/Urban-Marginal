package modele;

import controleur.Controle;
import outils.connexion.Connection;

public class JeuServeur extends Jeu {
	
	/**
	 * Constructeur
	 * @param controle
	 */
	public JeuServeur(Controle controle){
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
