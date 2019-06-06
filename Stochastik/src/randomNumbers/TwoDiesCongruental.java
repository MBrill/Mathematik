/**
 * Realisierung des Zufallsexperiments zweimal wÃ¼rfeln und Augensumme
 * mit unserem eigenen linearen Kongruenz-Generator.
 */
public class TwoDiesCongruental extends TwoDiesAbstract 
{	
	/** 
	 * Konstruktor 
	 */
	public TwoDiesCongruental(LinearCongruentalGenerator gen) 
	{	
		generator = new LinearCongruentalGenerator();
	}
	
	/** 
	 * @see TwoDiesAbstract#throwDies()
	 */
	@Override
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
	
	/** 
	 * Funktion, die einen double-Wert im Einheitsintervall 
	 * in ein Würfelergebnis umwandelt.
	 * Wir überprüfen nicht, ob der übergebene Wert im Einheitsintervall liegt!
	 * 
	 * @param val Zahl, die umgewandelt werden soll
	 * @return Zahl 1, 2, 3, 4, 5 oder 6
	 */
	private int getDie(double val) {
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
