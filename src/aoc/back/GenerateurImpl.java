package aoc.back;

import java.util.ArrayList;
import java.util.List;

import aoc.back.interfacies.Generateur;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;
import aoc.strategy.AlgoDiffusion;
import aoc.strategy.DiffusionAtomique;

public class GenerateurImpl implements Generateur {
	
	AlgoDiffusion alg = new DiffusionAtomique(this);
	Integer value;
	List <ObservateurGenerateurAsync> listobs = new ArrayList<ObservateurGenerateurAsync>();
	

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
	
	public void run() {
		while (true){
			this.value ++;
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
	public Integer getValue(ObservateurGenerateurAsync obs) {
		return this.value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
		alg.execute();	
	}

	public List<ObservateurGenerateurAsync> getListobs() {
		return listobs;
	}

	public void setListobs(List<ObservateurGenerateurAsync> listobs) {
		this.listobs = listobs;
	}

	public Integer getValue() {
		return value;
	}
	
	public AlgoDiffusion getAlg() {
		return alg;
	}

	public void setAlg(AlgoDiffusion alg) {
		this.alg = alg;
	}
}
