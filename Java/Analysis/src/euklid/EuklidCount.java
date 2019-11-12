/**
 *   Implementierung des Euklidischen Algorithmus mit Instrumentierung
 *   f�r die Analyse des Algorithmus.
 *   <P>
 *   Verwendung: die Eingabedaten stehen in der Datei Euklid.in,
 *   die Ergebnisse werden in die Datei Euklid.out geschrieben.
 *   Dabei enh�lt die Ausgabedatei f�r die beiden Fibonacci-Zahlen
 *   F_{12} = a = 233 die Anzahl der Divisionen f�r die Berechnung von
 *   ggT(233, b), f�r b = 2, ..., 232, und nat�rlich die Zahl b selbst.
 *   F�r die bessere Weiterverarbeitung werden Strichpunkte zwischen die
 *   Eintr�ge gesetzt (CSV-Format).</P> *   
 *   <P>
 *   Auf der Konsole wird nur Fehler, Warnungen oder eine kurz
 *   Erfolgsmeldung ausgegeben.</P>
 */
public class EuklidCount 
{   /** Der Default-Konstruktor setzt die Variable f�r das
     *  Z�hlen der Schleifendurchl�ufe auf Null.	 
	 */
	public EuklidCount() {
		this.a = 0;
		this.b = 0;
		this.counter = 0;
	}
    /** Konstruktor mit den beiden Zahlen a und b,
     *  f�r die der gr��te gemeinsame Teiler berechnet
     *  werden soll.	 
	 */
	public EuklidCount(long aa, long bb) {
		this.a = aa;		this.b = bb;
		this.counter = 0;
	}
    /** Konstruktor mit der Zahl a,
     *  f�r die der gr��te gemeinsame Teiler berechnet
     *  werden soll. b und der Z�hler werden mit 1 bzw. 0 
     *  initialisiert.	 
	 */
	public EuklidCount(long aa) {
		this.a = aa;
		this.b = 1;		this.counter = 0;
	}
	/**
	 * Euklidischer Algorithmus, mit Z�hlen der Schleifendurchl�ufe f�r die Analyse
	 * des Algorithmus.
	 * 
	 * @param a Zahl, f�r die der gr��te gemeinsame Teiler berechnet werden soll
	 * @param b Zahl, f�r die der gr��te gemeinsame Teiler berechnet werden soll
	 * @return gr��ter gemeinsamer Teiler von a und b
	 */
	public long gcd()
	{
		long r;		// Umspeichern der Zahlen a und b, damit wir diese Klassenvariablen
		// weiter verwenden k�nnen.
		long localA = this.a;
		long localB = this.b;		this.resetCounter();
		while (localB != 0)
		{
			r = localA%localB;
			localA = localB;			localB = r;			this.counter += 1;
		}		// counter um 1 verringern; die letzte Zeile hat Rest 0
		this.counter--;		return localA;
	}
	/** Die Zahl a neu setzen, dabei auch gleich den Counter zur�cksetzen */
	public void setA(long aa) {
		this.a = aa;	
		this.counter = 0;
	}
	/** Die Zahl a neu setzen, dabei auch gleich den Counter zur�cksetzen */
	public void setB(long bb) {
		this.b = bb;	
		this.counter = 0;
	}
	/** Die Zahl a abfragen */
	public long getA() {		return this.a;
	}
	/** Die Zahl a abfragen */
	public long getB() {
		return this.b;
	}
	/** Den Z�hler zur�cksetzen */
	public void resetCounter() {
		this.counter = 0;
	}
	/** Den Counter abfragen */
	public long getCounter() {
		return this.counter;
	}
	/** Variablen f�r die Zahlen a und b mit gcd(a, b) */
	private long a, b;
	/** Variable f�r die Anzahl der Schleifendurchl�ufe in gcd */
	private long counter;
}


