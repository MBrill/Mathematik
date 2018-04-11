/**
 * Abstrakte Basisklasse für die Experimente mit verschiedenen Zufallszahlengeneratoren
 * und dem zufallsexperiment "Werfen einer fairen Münze".
 */
abstract public class ThrowCoinAbstract {
	
	/** Konstruktor */
	public ThrowCoinAbstract() {}
	
	/** Funktion für die Simulation eines Würfels.
	 *  
	 *  @return Summe der beiden Würfel
	 */
	abstract public int throwCoin();
}
