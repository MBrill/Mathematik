/**
 * Abstrakte Basisklasse f�r die Experimente mit verschiedenen Zufallszahlengeneratoren
 * und dem zufallsexperiment "Augensumme bei zweimaligem W�rfeln".
 */
abstract public class TwoDiesAbstract {
	
	/** Konstruktor */
	public TwoDiesAbstract() {}
	
	/** Funktion f�r die Simulation eines W�rfels.
	 *  
	 *  @return Summe der beiden W�rfel
	 */
	abstract public int throwDies();
	
	/** 
	 * Funktion, die einen double-Wert im Einheitsintervall 
	 * in ein W�rfelergebnis umwandelt.
	 * Wir �berpr�fen nicht, ob der �bergebene Wert im Einheitsintervall liegt!
	 * 
	 * @return Zahl 1, 2, 3, 4, 5 oder 6
	 */
	protected int getDie(double val) {
		double p = 1.0/6.0;
		if (val < p)
			return 1;
		if (val < 2.0*p)
			return 2;	
		if (val < 3.0*p)
			return 3;	
		if (val < 4.0*p)
			return 4;	
		if (val < 5.0*p)
			return 5;	
		else
			return 6;
	}
}
