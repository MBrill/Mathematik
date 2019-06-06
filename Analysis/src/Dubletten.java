import java.io.*;
import java.util.Scanner;

/**Implementierung der Suche nach Dubletten aus der Analysis-Vorlesung
 * 
 * Die Liste der Zahlen kann aus einer Datei gelesen werden. Im Default-Konstruktor
 * wird das Zahlenbeispiel aus den Folien erzeugt.
 * 
 * Die beiden in der Vorlesung vorgestellten Verfahren sind in den Funktionen
 * Dubletten.scan() und Dubletten.hash() implementiert.
 * 
 * @author Manfred Brill
 * @version 2.0
 */
public class Dubletten {
	/** Hauptprogramm */
	public static void main(String[] args) throws IOException
	{
		PrintStream out = null;
		Scanner scanner = null;
		
		
		
		try {
			// Stream für die Dateiausgabe erzeugen
			out = new PrintStream(new File("Dubletten.out"));
			
			out.println("Ergebnis der Suche nach Dubletten");
			out.println("");
			
			// Das Beispiel aus den Folien erzeugen
			Dubletten beispiel = new Dubletten();
			out.println("1. Die Zahlen aus der Vorlesung");
			out.println("");
			beispiel.printNumbers(out);
			
			out.println("Suche mit scan()");
		    if (beispiel.scan())
		    	out.println("Dubletten gefunden!");
		    else
		    	out.println("Keine Dubletten gefunden!");
		
		    out.println("Suche mit hash()");
		    
		    if (beispiel.hash())
		    	out.println("Dubletten gefunden!");
		    else
		    	out.println("Keine Dubletten gefunden!");			
			
		    // Nächstes Beispiel, mit Werten in einer Datei
			scanner = new Scanner(new File("Dubletten.in"));
			int n = scanner.nextInt();		
			int a[] = new int[n];
			for (int counter = 0; counter < n; counter++) {
				a[counter] = scanner.nextInt();
			}

			Dubletten beispiel1 = new Dubletten(a);
			
		    out.println(""); out.println("");
		    out.println("2. Werte aus der Datei Dubletten.in");
		    out.println("");
			beispiel1.printNumbers(out);
			
			out.println("Suche mit scan()");
		    if (beispiel1.scan())
		    	out.println("Dubletten gefunden!");
		    else
		    	out.println("Keine Dubletten gefunden!");
		
		    out.println("Suche mit hash()");
		    
		    if (beispiel1.hash())
		    	out.println("Dubletten gefunden!");
		    else
		    	out.println("Keine Dubletten gefunden!");
		
		    // Ein weiteres Beispiel, der worst case
		    Dubletten beispiel2 = beispiel.worstCase();
		    out.println(""); out.println("");
		    out.println("3. Beispiel für den worst case");
		    out.println("");
		    beispiel2.printNumbers(out);
		    out.println("");
		
		    out.println("Suche mit scan()");
		    if (beispiel2.scan()) 
		    	out.println("Dubletten gefunden!");
		    else
		    	out.println("Keine Dubletten gefunden!");
		
		    Dubletten beispiel3 = beispiel.makeDouble(2);
		    out.println(""); out.println("");
		    out.println("4. Beispiel mit einer Dublette an der Stelle 2");
		    out.println("");
		    		
		    beispiel3.printNumbers(out);
		    out.println("");
		
		    out.println("Suche mit Hash");
		
		    if (beispiel3.hash())
				out.println("Dubletten gefunden!");
		    else
			   out.println("Keine Dubletten gefunden!");	
		} finally {
			if (scanner != null) scanner.close();			
			if (out != null) out.close();
		}	
		System.out.println("Alles erledigt!");
	}		
	
    /** Der Default-Konstruktor verwendet das Folienbeispiel
     *  16 Zahlen, wie auf der Vorlesungsfolie und in
     *  "Mathematik für Informatiker" angegeben.	 
	 */
	public Dubletten() {
		N=16;
		Max = 99;
        A = new int[N];
        
       	A[0] = 86;
       	A[1] = 63;
       	A[2]=  39;
       	A[3] = 98;
       	A[4] = 38;
       	A[5] = 68;
       	A[6] = 88;
	    A[7] = 36;
	    A[8] = 83;
	    A[9] = 17;
		A[10] = 33;
		A[11] = 69;
		A[12] = 66;
		A[13] = 89;
		A[14] = 96;
		A[15] = 9;		
	}
	
	/** Füllen des Feldes mit Zufallszahlen zwischen 0 und 100 */
	public Dubletten(int n) {
		N = n;
		Max = 100;
		A = new int[N];
		
		for (int i=0; i<N; i++)
			A[i] = (int)(Max*Math.random());
	}

	/** Füllen des Feldes mit Zufallszahlen zwischen 0 und big */
	public Dubletten(int n, int big) {
		N = n;
		Max = big;
		A = new int[N];
		
		for (int i=0; i<N; i++)
			A[i] = (int)(this.Max*Math.random());
	}
	
	/** Füllen des Felds mit dem als Argument übergebenen Feld
	 * 
	 * Der maximal zulässige Wert wird aus den übergebenen Werten
	 * bestimmt.
	 * 
	 * @param m Maximal zulässiger Wert
	 * @param a Feld das verwendet werden soll
	 */
	public Dubletten(int feld[]) {
		this.N = feld.length;
		this.Max = 0;
		this.A = new int[this.N];
		
		for (int i=0; i<N; i++) {
			A[i] = feld[i];
			if (A[i] > this.Max) this.Max = A[i];
		}
	}
	
	/** Scan: lineare aufzählende Suche
	 * 
	 * @return true, falls Dublette gefunden wurde, sonst false
	 */
	public boolean scan() {
		int i, j;
		
		for (i=0; i<N; i++) {
			for (j=i+1; j<N; j++) 
				if (A[i] == A[j]) return true;
		}
		return false;
	}
	
	/** Hash: Einsatz einer Hashing-Strategie
	 * 
	 * @return true, falls Dublette gefunden wurde
	 */
	public boolean hash() {
		// Achtung beim Zugriff mit B[A[i]]: wir müssen 1 abziehen,
		// die Felder sind mit 0 beginnend indiziert!
		boolean B[] = new boolean[this.Max];
		int i;
		
		// B mit false initialisieren
		for (i=0; i<this.Max; i++)
			B[i] = false;
		
		for (i=0; i<this.N; i++) 
		{
			if (B[A[i]-1]) 
				return true;
			else
				B[A[i]-1] = true;
		}			
		return false;
	}
	
	/** Ausgabe der behandelten Zahlen auf der Konsole */
	public void printNumbers(PrintStream out) {
		out.println("Die verwendeten ganzen Zahlen:");
		
		for (int i=0; i<N; i++)
			out.println("A[" + i + "]=" + A[i] );
	}
	
	/** Ausgabe der Anzahl der ganzen Zahlen, in denen gesucht wird */
	public int getlength() {
		return N;
	}
	
	/** Ausgabe des maximal zulässigen Werts für die Einträge im Feld.
	 *  Wird für die Hashing-Strategie benötigt.
	 *   
	 * @return maximal zulässiger Wert
	 */
	public int getMaximum() {
		return Max;
	}
	
	/** Erstellen eines Feldes, das den worst case darstellt - 
	 *  Die Dublette ist in den letzten beiden Elementen.
	 */
	public Dubletten worstCase() {
		   int a[] = new int[this.N+1];
		   
		   for (int i=0; i<this.N; i++) 
		   	    a[i] = this.A[i];
		   a[N] = this.A[N-1];
		   
		   Dubletten kopie = new Dubletten(a);
		  
		   return kopie;
	}
	
	/** Dublette an einer angegebenen Stelle erzeugen
	 *
	 * Der angegebene Index muss zwischen 0 und N-1 liegen!
	 * @param stelle Index, an der der doppelte Eintrag erzeugt werden soll
	 * 
	 */
	public Dubletten makeDouble(int stelle) {
		   int a[] = new int[this.N+1];
		   
		   for (int i=0; i<=stelle; i++) 
		   	    a[i] = this.A[i];
		   a[stelle+1] = this.A[stelle];
		   for (int i=stelle+2; i<this.N+1; i++) 
	   	        a[i] = this.A[i-1];		   
		   
		   Dubletten kopie = new Dubletten(a);
		  
		   return kopie;
	}
	
	/** Anzahl der ganzen Zahlen */
	private int N;
    /** 
     *   Feld mit ganzen Zahlen, 
     *   in denen nach einer Dublette gesucht wird.
     */
	private int A[];
	/** 
	 * Maximal zulässiger Wert. Wird für die Hashing-Strategie benötigt!
	 */
	private int Max;
}
