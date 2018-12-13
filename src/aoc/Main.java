package aoc;
import aoc.back.GenerateurImpl;
import aoc.front.Afficheur;
import aoc.proxy.Canal;
import aoc.strategy.DiffusionAtomique;
import aoc.strategy.causale.DiffusionCausale;
import aoc.swing.CommAfficheur;
import aoc.swing.Fenetre;

/**
 * @author Angelique Montuwy, Antoine Posnic 
 * Classe de creation du generateur, des canaux, des afficheurs et de la fenetre Swing.
 */

public class Main {
	/**
	 * Nombre d'afficheurs desires
	 */
	public static final int NB_VALUES_AFF=3;

	public static void main(String[] args) {
		/**
		 * Creation du generateur
		 */
		GenerateurImpl gen = new GenerateurImpl();

		/**
		 * Creation de la fenetre
		 */
		Fenetre fen = new Fenetre(gen);
		/**
		 * Creation de l'observateur qui vient modifier la fenetre
		 */
		CommAfficheur comm = new CommAfficheur(fen);
		
		/**
		 * Creation d'autant d'afficheurs et de canaux que necessaire. On attache chaque afficheur a un canal (les afficheurs deviennent des observateurs de canaux), et chaque canal au generateur (les canaux deviennent des observateurs du generateur).
		 */
		for(int i=0; i<Main.NB_VALUES_AFF; i++) {
			Afficheur aff = new Afficheur(i);
			
			Canal canal = new Canal();
			canal.attach(aff);
			
			gen.attach(canal);
			aff.addObserver(comm);
		}
		
		/**
		 * Attache le generateur au notifieur de la fenetre
		 */
		gen.addObserver(comm);
		
		/**
		 * Par defaut, le programme commence avec un algorithme de diffusion atomique.
		 */
		gen.setAlg(new DiffusionAtomique(gen));
		gen.run();
		
	}
}
