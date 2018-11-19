package aoc.front;

import java.util.concurrent.ExecutionException;

import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;

public class Afficheur implements ObservateurGenerateur{
	int id;
	
	public Afficheur (int x) {
		this.id=x;
	}

	@Override
	public void update(GenerateurAsync generateur) { // notre générateur ici, c'est le canal
		try {
			System.out.println("la valeur reçue par afficheur " +this.id + " est: " + generateur.getValue().get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
