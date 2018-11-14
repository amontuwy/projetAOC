package aoc.back;

import java.util.concurrent.Future;

import aoc.back.interfacies.Generateur;
import aoc.proxy.interfacies.GenerateurAsync;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;

public class GenerateurImpl implements Generateur {



	@Override
	public void attach(ObservateurGenerateurAsync canal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(ObservateurGenerateurAsync canal) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Future<Integer> getValue(GenerateurAsync canal) {
		// TODO Auto-generated method stub
		return null;
	}

}
