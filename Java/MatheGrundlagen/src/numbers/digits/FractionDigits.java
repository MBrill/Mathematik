package numbers.digits;

import java.util.ArrayList;

/**
 * Stellenwertsysteme für Dezimalbrüche mit einer beliebigen Basis.
 * 
 * Die Klasse FractionDigits speichert einen Dezimalbruch im Dezimalsystem in einem
 * durch die Basis gegebenen Stellenwertsystem in Form
 * der Ziffern. Die Ziffern sind ganze Zahlen zwischen 0
 * und Basis-1. Wenn eine negative ganze Zahl behandelt werden soll,
 * dann wird der Betrag dieser Zahl umgewandelt und das Vorzeichen
 * wird wieder hinzugefügt.
 * 
 * Diese Klasse behandelt nur Dezimalbrüche, deren Betrag echt kleiner als 1 ist!
 * 
 * @author $Author: brill $
 * @version $Revision: #1 $
 */

public class FractionDigits {
	
    /** 
     * Die Basis des Stellenwertsystems, die in der Instanz verwendet wird
     * 
     * Default ist das Binärsystem, also base = 2.
     */
    private int base = 2;
    
    /**
     * Flag für das Vorzeichen der behandelten Zahl. 
     * Ist sign == true, dann ist die Zahl positiv, sonst negativ.
     * 
     * Defaultwert ist true.
     */
    private boolean sign = true;
    
    /**
     * Anzahl der Nachkommastellen, die maximal verwendet werden sollen.
     * 
     * Defaultwert ist 10.
     */
    private int maxDigits = 10;
    
    /**  
     * Dynamisches Feld mit den Ziffern, das Element 0 enthält die Ziffer 
     * bei base^(-1), dann base^(-2) etc. 
     */
	private ArrayList<Byte> digits;  
	
    /**  
     * Default Konstruktor 
     * 
     * Defaultwerte:
     * base 2
     * digits Feld angelegt, ohne Werte
     */
    public FractionDigits() 
    { 
		this.digits = new  ArrayList<Byte>(this.maxDigits);
	}	
    
    /** 
     * Konstruktor mit der Basis des Stellenwertsystems und einem Dezimalbruch.
     * 
     * @param theNumber Eine Zahl, die im Stellenwertsystem dargestellt werden soll.
     * @param theBase Die Basis des Zahlsystems, das verwendet werden soll.
     * @param theMax Anzahl der Nachkommastellen, die verwendet werden sollen.
     * 
     * @throws IllegalArgumentException Exception, falls der Betrag des Dezimalbruchs
     *                                  nicht kleiner als 1 ist.
     */
    public FractionDigits(double theNumber, int theBase, int theMax) 
    {
    	if (Math.abs(theNumber) >= 1.0) throw new IllegalArgumentException("Error: no fractional number!");
    	// Vorzeichen
    	if (theNumber < 0) {
    		this.sign = false;
    	}
    	else
    		this.sign = true;
    	
    	this.base = theBase;
    	this.maxDigits = theMax;
		this.digits = new  ArrayList<Byte>(this.maxDigits);
		// Den Absolutbetrag übergeben, das vorzeichen ist oben schon
		// behandelt worden.
    	this.splitIntoDigits(Math.abs(theNumber));
	}  
 
    /** 
     * Funktion, die eine long-Zahl, also eine Zahl im Dezimalsystem, in ihre Ziffern zerlegt 
     * Nach dem Aufruf dieser Funktion enthält die Instanz die Ziffern der Zahl.
     * 
     * Wir implementieren die "method 2a" aus Knuth, Band 3 aus Seite 319. 
     * Aktuell wird <b>nicht</b> gerundet, sondern die Berechnung der Nachkommastellen
     * wird einfach abgebrochen!
     * 
     * @param number Dezimalbruch der in die Ziffern im Stellenwertsystem zerlegt werden soll.
     *               Diese Zahl muss positiv sein!
     *               
     * @throws IllegalArgumentException Exception, falls eine negative Zahl übergeben wird,
     *                                  oder der Dezimalbruch einen Betrag größer oder gleich 1 hat.
     */
    private void splitIntoDigits (double number)
    {
    	if (number < 0) throw new IllegalArgumentException("Error: number in splitIntoDigits is negative!");
    	if (number >= 1.0) throw new IllegalArgumentException("Error: no fractional number!");
    	
        int counter = 0;
        double helper = number;
        while ( counter < this.maxDigits)
        {   
          digits.add( (byte)(Math.floor(helper * this.base)) );
          helper = helper*this.base - Math.floor(helper*this.base);
          counter++;
        }
    }   
    
    /** 
     * Die Ziffern in der Instanz verwenden, um einen Dezimalbruch zu produzieren.
     * 
     * @return Dezimalbruch
     */
    public double numberFromDigits()
    {
    	int i;
    	double value = 0.0, basePower = 1.0/(double)this.base;
    	if (!this.digits.isEmpty()) {
    		for (i=0; i<this.digits.size(); i++) {
    		     value += this.digits.get(i) * basePower;
    		     basePower /= (double)this.base;
    	    }
    	}
    	if (!sign)
    		return -value;
    	else
    		return value;
    	
    }
    
	/**
	 * Überschreiben von toString für Konsolenausgaben.
	 * 
	 * @return String für die Ausgabe
	 */
	@Override
    public String toString() {
		String text = "";
		if (!sign) 
			text += "- ";
		
	    text += "( 0, ";
	    if (!this.digits.isEmpty()) {
            for (int i=0; i < this.maxDigits; i++) {
            	text += this.digits.get(i).toString() + " ";
            }	 	
	    	text += ")_" + this.base;
	    }	
	    else {
	    	text = "( 0,0 )_" + this.base;
	    }
	    return text;
    }  

    /** Die verwendete Basis des Stellenwertsystems abfragen 
    *
    * @return Die Basis des Stellenwertsystems
    */
   public int getBase() { return this.base; }
   
   /** 
    * Abfragen, wie viele Nachkommastellen wir verwenden
    * 
    *  @return die Anzahl der Nachkommastellen
    */
   public int getNumberOfDigits() { return this.maxDigits; };	
}
