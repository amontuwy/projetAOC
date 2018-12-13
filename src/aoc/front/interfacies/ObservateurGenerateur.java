package aoc.front.interfacies;

import aoc.proxy.interfacies.GenerateurAsync;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Interface d'un observateur synchrone, correspondant au pattern observateur/generateur traditionnel (synchrone).
 */

public interface ObservateurGenerateur {
	/**
	 * Permet la mise a jour d'un observateur par un Generateur. Dans le cadre du pattern, les canaux jouent le role de generateur du point de vue des observateurs. Le type du parametre est donc GenerateurAsync.
	 * @param gen: GenerateurAsync
	 */
	void update (GenerateurAsync gen);
}
