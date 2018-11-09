package aoc.proxy;

import java.util.concurrent.Future;

import aoc.back.Generateur;
import aoc.front.ObservateurGenerateur;

public class Canal implements ObservateurGenerateur, Generateur {

	Generateur gen;
	ObservateurGenerateur obs;

	public Canal(Generateur gen, ObservateurGenerateur obs) {
		super();
		this.gen = gen;
		this.obs = obs;
	}

	@Override
	public void attach(ObservateurGenerateur obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(ObservateurGenerateur obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Generateur gen) {
		// TODO Auto-generated method stub
		
	}

}
