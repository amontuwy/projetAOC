package aoc.front;

import java.util.Observable;
import java.util.concurrent.ExecutionException;

import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Classe d'implementation d'un afficheur synchrone d'interface ObservateurGenerateur.
 * Cette implementation etend Observable de sorte a pouvoir notifier la fenetre d'affichage des valeurs prises par l'afficheur.
 */
public class Afficheur extends Observable implements ObservateurGenerateur{
	/**
	 * Identifiant de l'afficheur, utile pour l'IHM.
	 */
	int id;
	
	/**
	 * Constructeur d'un afficheur d'indentifiant x.
	 * @param x: int
	 */
	public Afficheur (int x) {
		this.id=x;
	}
	
	/**
	 * Permet de connaitre l'identifiant de l'affichaur depuis l'exterieur.
	 * @return id: int
	 */
	public int getId() {
		return id;
	}

	@Override
	/**
	 * Permet a un afficheur de recuperer la valeur du generateur l'ayant notifie (ici un canal, donc un GenerateurAsync).
	 * Affiche cette valeur dans la console et notifie la fenetre d'affichage de cette nouvelle valeur.
	 */
	public void update(GenerateurAsync generateur) { 
		try {
			int value = generateur.getValue().get();
			System.out.println("la valeur reçue par afficheur " +this.id + " est: " + value);
			setChanged();
			notifyObservers(value);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
