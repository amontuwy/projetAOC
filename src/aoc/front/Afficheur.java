package aoc.front;

import java.util.Observable;
import java.util.concurrent.ExecutionException;

import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;

public class Afficheur extends Observable implements ObservateurGenerateur{
	int id;
	
	public Afficheur (int x) {
		this.id=x;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public void update(GenerateurAsync generateur) { // notre générateur ici, c'est le canal
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
