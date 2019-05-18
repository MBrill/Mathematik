package numbers.digits;

import java.util.ArrayList;

/**
 * Stellenwertsysteme für ganze Zahlen mit einer beliebigen Basis.
 * 
 * Die Klasse Digits speichert eine Zahl im Dezimalsystem in einem
 * durch die Basis gegebenen Stellenwertsystem in Form
 * der Ziffern. Die Ziffern sind ganze Zahlen zwischen 0
 * und Basis-1. Wenn eine negative ganze Zahl behandelt werden soll,
 * dann wird der Betrag dieser Zahl umgewandelt und das Vorzeichen
 * wird wieder hinzugefügt.
 * 
 * @author $Author: brill $
 * @version $Revision: #2 $
 */
public class Digits {

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
     * Dynamisches Feld mit den Ziffern, das Element 0 enthält die Ziffer 
     * bei base^0, dann base^1 etc. 
     */
	private ArrayList<Byte> digits;    
    
    /**  
     * Default Konstruktor 
     * 
     * Defaultwerte:
     * base 2
     * digits Feld angelegt, ohne Werte
     */
    public Digits() 
    { 
		this.digits = new  ArrayList<Byte>();
	}

    /** 
     * Konstruktor mit der Basis des Stellenwertsystems, der maximalen Anzahl der Ziffern und einer Zahl 
     * 
     * @param theNumber Eine Zahl, die im Stellenwertsystem dargestellt werden soll
     * @param theBase Die Basis des Zahlsystems, das verwendet werden soll
     */
    public Digits(long theNumber, int theBase) 
    {
    	// Vorzeichen
    	if (theNumber < 0) {
    		this.sign = false;
    	}
    	else
    		this.sign = true;
    	
    	this.base = theBase;
		this.digits = new  ArrayList<Byte>();
		// Den Absolutbetrag übergeben, das vorzeichen ist oben schon
		// behandelt worden.
    	this.splitIntoDigits(Math.abs(theNumber));
	}

    /** 
     * Funktion, die eine long-Zahl, also eine Zahl im Dezimalsystem, in ihre Ziffern zerlegt 
     * Nach dem Aufruf dieser Funktion enthält die Instanz die Ziffern der Zahl.
     * 
     * Wir implementieren die "method 1a" aus Knuth, Band 3 aus Seite 319. 
     * 
     * @param number Die Zahl die in die Ziffern im Stellenwertsystem zerlegt werden soll.
     *               Diese Zahl muss positiv sein!
     *               
     * @throws IllegalArgumentException Exception, falls eine negative  Zahl übergeben wird.
     */
    private void splitIntoDigits (long number)
    {
    	if (number < 0) throw new IllegalArgumentException("Error: number in splitIntoDigits is negative!");
        // Durch die Zahl gehen, von rechts nach links
       
        while ( number != 0)
        {
          if ( number == 0 ) break;     
          digits.add( (byte)(number % this.base) );
          number /= base;        
        }
    }

    /**
     * Übergeben einer Dezimalzahl und umwandeln in das Stellenwertsytem
     * der Basis in der Instanz.
     * 
     * Falls vorher bereits eine Zahl behandelt wurde wird die Information
     * dazu gelöscht!
     */
    public void setNumber(long number) {
    	// Vorzeichen
    	if (number < 0) {
    		this.sign = false;
    	}
    	else
    		this.sign = true;
    	
		this.digits = new  ArrayList<Byte>();
		// Den Absolutbetrag übergeben, das vorzeichen ist oben schon
		// behandelt worden.
    	this.splitIntoDigits(Math.abs(number));   	
    }
    
    /** 
     * Die Ziffern in der Instanz verwenden, um eine Dezimalzahl zu produzieren.
     * 
     * @return Zahl im  Dezimalsystem
     */
    public long numberFromDigits()
    {
    	int i;
    	long value = 0, basePower = 1;
    	if (!this.digits.isEmpty()) {
    		for (i=0; i<this.digits.size(); i++) {
    		     value += this.digits.get(i) * basePower;
    		     basePower *= this.base;
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
	 * Im dynamischen Feld haben wir die Zahl "verkehrt" herum
	 * gespeichert, das machen wir hier wieder rückgängig.
	 * 
	 * @return String für die Ausgabe
	 */
	@Override
    public String toString() {
		String text = "";
		if (!sign) 
			text += "- ";
		
	    text += "( ";
	    if (!this.digits.isEmpty()) {
            for (int i=this.digits.size()-1; i>=0; i--) {
            	text += this.digits.get(i).toString() + " ";
            }	    	
	    	text += ")_" + this.base;
	    }	
	    else {
	    	text = "(0)_" + this.base;
	    }
	    return text;
    }
	
    /**
     * Die i-te Ziffer in der Darstellung im Stellenwertsystem
     * 
     * @return i-te Stelle
     */
    public int getDigit(int i) {
    	assert (i>= 0 && i < this.digits.size());
    	return this.digits.get(i);
    }
    
    /** Die verwendete Basis des Stellenwertsystems abfragen 
     *
     * @return Die Basis des Stellenwertsystems
     */
    public int getBase() { return this.base; }

    /** 
     * Abfragen, wie viele Ziffern wir benötigen
     * 
     *  @return die Anzahl der verwendeten Ziffern
     */
    public int getNumberOfDigits() { return this.digits.size(); };
}    