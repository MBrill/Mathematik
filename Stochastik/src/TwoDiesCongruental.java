/**
 * Realisierung eines Zufallsexperiments zweimal würfeln und Augensumme
 * mit unserem eigenen linearen Kongruenz-Generator.
 */
public class TwoDiesCongruental extends TwoDiesAbstract {
	
	/** 
	 * Konstruktor 
	 */
	public TwoDiesCongruental() {	
		// Eine Instanz des Generators erzeugen
		// Der Generator verwendet die originalDaten von Lehmer!
		generator = new LinearCongruentalGenerator();
	}
	
	/** 
	 * Funktion f�r die Simulation eines W�rfels
	 *  Wir holen zwei double-Zahlen im Einheitsintervall ab,
	 *  wandeln sie in W�rfelergebnisse um und bilden die Summe.
	 *  
	 *  @return Summe der beiden W�rfel
	 */
	public int throwDies()
	{
		double die1, die2;
		die1 = generator.nextDouble();
		die2 = generator.nextDouble();
		return getDie(die1) + getDie(die2);	
	}
	
	/** 
	 * Instanz des Generators 
	 */
	private LinearCongruentalGenerator generator;
}
