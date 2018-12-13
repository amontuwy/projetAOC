package aoc.back;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import aoc.back.interfacies.Generateur;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;
import aoc.strategy.AlgoDiffusion;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Implementation d'un generateur synchrone d'interface Generateur.
 * Cette implementation etend Observable de sorte a pouvoir notifier la fenetre d'affichage des valeurs prises par le generateur.
 */

public class GenerateurImpl extends Observable implements Generateur{
	/**
	 * Algorithme en charge de la notification des observateurs
	 */
	AlgoDiffusion alg;
	/**
	 * Valeur courante du generateur
	 */
	Integer value;
	/**
	 * Liste des observateurs du generateur. Les observateurs etant des canaux, ils sont ici de type ObservateurGenerateurAsync.
	 */
	List <ObservateurGenerateurAsync> listobs = new ArrayList<ObservateurGenerateurAsync>();
	
	/**
	 * Constructeur d'un generateur. La valeur d'initialisation est 0.
	 */
	public GenerateurImpl() {
		super();
		this.value = 0;
	}

	@Override
	public void attach(ObservateurGenerateurAsync observeur) {
		listobs.add(observeur);
	}
	
	@Override
	public void detach(ObservateurGenerateurAsync observeur) {
		if (listobs.contains(observeur)){
			listobs.remove(observeur);
		}
	}

	
	/**
	 * Permet de demarrer le generateur. Dans le present cas, il est attendu du generateur de produire des valeurs en continu (chaque seconde) et d'appeler l'algorithme de diffusion visant a notifier les observateurs.
	 * La fenetre d'affichage est egalement notifiee du changement de valeur. 
	*/
	public void run() {
		while (true){
			this.value ++;
			setChanged();
			notifyObservers(this.value);
			System.out.println("Nouvelle valeur ");
			this.alg.execute();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Integer getValue() {
		return value;
	}

	/**
	 * Permet de forcer un valeur dans le generateur. Ceci est utile pour la copie de generateurs en vue de leur diffusion.
	 * @param value: integer
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * Permet de connaitre de l'exterieur la liste des observateurs (canaux) attaches a ce generateur.
	 * @return List of ObservateurGenerateurAsync
	 */
	public List<ObservateurGenerateurAsync> getListobs() {
		return listobs;
	}
	
	/**
	 * Permet de connaitre l'algorithme de diffusion couramment utilise.
	 * @return AlgoDiffusion
	 */
	public AlgoDiffusion getAlg() {
		return alg;
	}
	/**
	 * Permet de changer l'algorithme de diffusion et donc le mode de notification des observateurs (canaux) pendant le fonctionnement du generateur.
	 * @param alg: AlgoDiffusion
	 */
	public void setAlg(AlgoDiffusion alg) {
		this.alg = alg;
	}
	
}
