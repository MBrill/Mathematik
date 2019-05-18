/**
 * Abstrakte Basisklasse f�r die Experimente mit verschiedenen Zufallszahlengeneratoren
 * und dem zufallsexperiment "Werfen einer fairen M�nze".
 */
abstract public class ThrowCoinAbstract {
	
	/** Konstruktor */
	public ThrowCoinAbstract() {}
	
	/** Funktion f�r die Simulation eines W�rfels.
	 *  
	 *  @return Summe der beiden W�rfel
	 */
	abstract public int throwCoin();
}
