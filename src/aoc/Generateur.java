package aoc;

public interface Generateur {
	
	void attach (ObservateurGenerateur obs);
	void detach (ObservateurGenerateur obs);
	Integer getValue();
}
