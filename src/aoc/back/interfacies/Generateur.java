package aoc.back.interfacies;

import aoc.proxy.interfacies.ObservateurGenerateurAsync;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Interface d'un generateur synchrone, similaire au generateur du pattern observateur/generateur
 */
public interface Generateur {
	/**
	 * Attache un observateur au generateur. Ici, les observateurs etant des canaux, on attache des ObservateurGenerateurAsync.
	 * @param observateur: ObservateurGenerateurAsync
	 */
	void attach (ObservateurGenerateurAsync observateur);
	/**
	 * Detache un observateur du generateur. Ici, les observateurs etant des canaux, on detache des ObservateurGenerateurAsync.
	 * @param observateur: ObservateurGenerateurAsync
	 */
	void detach (ObservateurGenerateurAsync observateur);
	
	/**
	 * Retourne la valeur du generateur.
	 * @return Integer
	 */
	Integer getValue();
	
}
