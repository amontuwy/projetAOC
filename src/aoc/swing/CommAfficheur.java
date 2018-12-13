package aoc.swing;

import java.util.Observable;

import java.util.Observer;

import aoc.back.GenerateurImpl;
import aoc.front.Afficheur;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Classe observatrice du generateurImpl et de chacun des Afficheurs.
 * Permet d'assurer l'affichage des valeurs prises par le generateur et les afficheurs des qu'elles sont modifiees. 
 */
public class CommAfficheur implements Observer {
	Fenetre fen ;

	public CommAfficheur(Fenetre fen) {
		this.fen=fen;
	}

	@Override
	/**
	 * En fonction du type de l'objet notifiant (Generateur ou Afficheur), on met a jour le JLabel correspondant dans la fenetre.
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof GenerateurImpl) {
			this.fen.setGenerateurText(arg.toString());
		} else if(o instanceof Afficheur) {
			Afficheur afficheur = (Afficheur) o;
			this.fen.setCanalText(arg.toString(), afficheur.getId());
		}
	}
}