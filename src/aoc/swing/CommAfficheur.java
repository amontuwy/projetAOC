package aoc.swing;

import java.lang.reflect.Field;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

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
			GenerateurImpl gen = (GenerateurImpl) o;
			try {
				Field field = fen.getClass().getDeclaredField("generateur");
				Object obj = field.get(fen);
				((JLabel) obj).setText(arg.toString());
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		else if(o instanceof Afficheur) {
			Afficheur afficheur = (Afficheur) o;
			try {
				Field field = fen.getClass().getDeclaredField("canal" + afficheur.getId());
				//field.setAccessible(true);
				Object obj = field.get(fen);
				((JLabel) obj).setText(arg.toString());
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}