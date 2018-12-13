package aoc.proxy.interfacies;

import java.util.concurrent.Future;

import aoc.back.interfacies.Generateur;
/**
 * @author Angelique Montuwy, Antoine Posnic
 * Interface d'un observateur asynchrone, permettant la mise a jour d'un observateur apres un certain delai.
 */
public interface ObservateurGenerateurAsync {

	/**
	 * Permet de notifier un Observateur Asynchrone de l'etat d'un Generateur synchrone. Cette notification renvoie une promesse vide, qui n'est resolue qu'a l'issue de la mise a jour temporisee de l'observateur.
	 * @param gen: Generateur
	 * @return Future of Object
	 */
	Future <Object> update (Generateur gen);
}
