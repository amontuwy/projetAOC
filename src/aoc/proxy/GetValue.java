package aoc.proxy;

import java.util.concurrent.Callable;

import aoc.back.interfacies.Generateur;
import aoc.proxy.interfacies.GenerateurAsync;

public class GetValue implements Callable<Integer> {

	Generateur gen;
	GenerateurAsync canal;
	
	public GetValue(Generateur gen, GenerateurAsync canal) {
		this.gen = gen;
		this.canal=canal;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		this.gen.getValue(this.canal);
		return null;
	}
}
