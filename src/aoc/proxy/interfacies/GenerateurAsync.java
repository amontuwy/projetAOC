package aoc.proxy.interfacies;

import java.util.concurrent.Future;

import aoc.front.interfacies.ObservateurGenerateur;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Interface offrant de creer des generateurs asynchrones. Similaire a l'interface traditionnelle d'un generateur dans le pattern Observateur/generateur, mais renvoyant des promesses au lieu de valeurs concretes. 
 */
public interface GenerateurAsync {

	/**
	 * Attache un observateur au generateur asynchrone. Ici, les observateurs etant des afficheurs, on attache des ObservateurGenerateur.
	 * @param obs: ObservateurGenerateur
	 */
	void attach (ObservateurGenerateur obs);
	/**
	 * Detache un observateur du generateur asynchrone. Ici, les observateurs etant des afficheurs, on detache des ObservateurGenerateur.
	 * @param obs: ObservateurGenerateur
	 */
	void detach (ObservateurGenerateur obs);
	
	/**
	 * Permet de requeter la valeur du generateur de maniere asynchrone. La promesse renvoyee par cette operation sera resolue plus tard, quand la valeur sera disponible.
	 * @return Future of Integer
	 */
	Future<Integer> getValue();
}
