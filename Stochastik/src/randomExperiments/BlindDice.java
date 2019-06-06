import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Realisierung eines blinden Würfels nach Haller unr Barth
 * 
 * Ein blinder Würfel ist ein Würfel, der fünf leere, blinde, Seiten hat.
 * Auf einer Seite steht ein Auge, entweder eine 1, eine 2 bis zu einer 6.
 * Die Wahrscheinlichkeit für jede der Seiten ist gleich. Also haben wir eine
 * Wahrscheinlichkeit von 5/6, eine Augenzahl von 0 zu würfeln, und eine
 * Wahrscheinclichkeit von 1/6 für die nicht-blinde Seite.
 * 
 * In einem Spiel werden insgesamt 6 solcher blinder Würfel verwendet, jeweils
 * mit einer der möglichen Augenzahlen.
 */
public class BlindDice {

	/** Default-Konstruktor
	 *  
	 *  Als Default wird ein blinder Würfel erzeugt, der
	 *  eine 1 auf der einen Seite aufweist. 
	 *  
	 *  Die Wahrscheinlichkeit, die nicht-blinde Seite zu würfeln
	 *  ist 1/6.
	 *  
	 *  Es wird kein Generator übergeben, so dass der Würfel noch nicht
	 *  geworfen werden kann.
	 */
	private BlindDice() 
	{
		eye = 1;
		p = 1.0/6.0;
	}

	/** Konstruktor mit einer Augenzahl
	 *  
	 *  Ein blinder Würfel mit n als Augenzahl. 
	 *  
	 *  Die Wahrscheinlichkeit, die nicht-blinde Seite zu würfeln
	 *  ist 1/6.
	 *  
	 *  @param n Augenzahl für die nicht-blinden Seite. Wird nicht eine Zahl zwischen 1 und 6 übergeben wird die Augenzahl auf 1 gesetzt.
		
	/**
	 * Abfragen, mit Welcher Wahrscheinlichkeit ein Auge zurückgeliefert wird
	 * 
	 * @return Wahrscheinlichkeit für die Erzeugung des nicht-blinden Auges
	 */
	public double getP()
	{
		return p;
	}
	
	/*
	*  @param gen Instanz eines Generators, der einen Mersenne Twister realisiert.
	 */
	public BlindDice(int n, RandomDataGenerator gen) 
	{
		if ( (n>=1) && (n <=6))
			eye = n;
		else
			eye = 1;
		
		p = 1.0/6.0;
		generator = gen;
	}
	
	/** 
	 * Wir werfen den blinden Würfel
	 * 
	 * Wir verwenden eine Binomialverteilung mit Erfolgswahrscheinlichkeit p.
	 * 	  
	 * @return blinde seite (=0) oder die Augenzahl
	 */
	public int throwDice() 
	{
		return eye*generator.nextBinomial(1, p);
	}
	
	/**
	 * Abfragen, welche Zahl auf der nicht-blinden Seite steht
	 * 
	 * @return Augenzahl auf der nicht-blinden Seite
	 */
	public int getEye()
	{
		return eye;
	}
	
	
	/** Welche Augenzahl wird auf der einen Seite verwendet? 
	 * 
	 */
	private int eye;
	
	/** 
	 * Mit welcher Wahrscheinlichkeit wird die nicht-blinde Seite gewürfelt? 
	 */
	private double p;
	
	/** 
	 * Instanz des Generators 
	 */
	private RandomDataGenerator generator;	

}
