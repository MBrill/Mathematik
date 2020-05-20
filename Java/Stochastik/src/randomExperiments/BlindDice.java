import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Realisierung eines blinden W�rfels nach Haller unr Barth
 * 
 * Ein blinder W�rfel ist ein W�rfel, der f�nf leere, blinde, Seiten hat.
 * Auf einer Seite steht ein Auge, entweder eine 1, eine 2 bis zu einer 6.
 * Die Wahrscheinlichkeit f�r jede der Seiten ist gleich. Also haben wir eine
 * Wahrscheinlichkeit von 5/6, eine Augenzahl von 0 zu w�rfeln, und eine
 * Wahrscheinclichkeit von 1/6 f�r die nicht-blinde Seite.
 * 
 * In einem Spiel werden insgesamt 6 solcher blinder W�rfel verwendet, jeweils
 * mit einer der m�glichen Augenzahlen.
 */
public class BlindDice {

	/** Default-Konstruktor
	 *  
	 *  Als Default wird ein blinder W�rfel erzeugt, der
	 *  eine 1 auf der einen Seite aufweist. 
	 *  
	 *  Die Wahrscheinlichkeit, die nicht-blinde Seite zu w�rfeln
	 *  ist 1/6.
	 *  
	 *  Es wird kein Generator �bergeben, so dass der W�rfel noch nicht
	 *  geworfen werden kann.
	 */
	private BlindDice() 
	{
		eye = 1;
		p = 1.0/6.0;
	}

	/** Konstruktor mit einer Augenzahl
	 *  
	 *  Ein blinder W�rfel mit n als Augenzahl. 
	 *  
	 *  Die Wahrscheinlichkeit, die nicht-blinde Seite zu w�rfeln
	 *  ist 1/6.
	 *  
	 *  @param n Augenzahl f�r die nicht-blinden Seite. Wird nicht eine Zahl zwischen 1 und 6 �bergeben wird die Augenzahl auf 1 gesetzt.
		
	/**
	 * Abfragen, mit Welcher Wahrscheinlichkeit ein Auge zur�ckgeliefert wird
	 * 
	 * @return Wahrscheinlichkeit f�r die Erzeugung des nicht-blinden Auges
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
	
	
	/** 
	 * Welche Augenzahl wird auf der einen Seite verwendet? 
	 */
	private int eye;
	
	/** 
	 * Mit welcher Wahrscheinlichkeit wird die nicht-blinde Seite gew�rfelt? 
	 */
	private double p;
	
	/** 
	 * Instanz des Generators 
	 */
	private RandomDataGenerator generator;	
}
