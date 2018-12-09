package aoc.swing;

import java.util.Observable;
import java.util.Observer;

import aoc.back.GenerateurImpl;
import aoc.front.Afficheur;

public class CommAfficheur implements Observer {
	Fenetre fen ;

	public CommAfficheur(Fenetre fen) {
		this.fen=fen;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof GenerateurImpl) {
			this.fen.setGenerateurText(arg.toString());
		} else if(o instanceof Afficheur) {
			Afficheur afficheur = (Afficheur) o;
			this.fen.setCanalText(arg.toString(), afficheur.getId());
		}
	}
}