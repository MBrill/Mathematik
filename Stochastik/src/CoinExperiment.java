/**
 * Experiment Münzwurf.
 * 
 * Das Experiment wird zweimal ausgeführt. Einmal mit einer Instanz von
 * Math.Random, und einmal mit einer Instanz eines MersenneTwisters
 * aus der Apache Common Math API.
 */
public class CoinExperiment 
{
	public static void main(String[] args) {

        ThrowCoinRandom  experiment1 = new ThrowCoinRandom();
        ThrowCoinTwister experiment2 = new ThrowCoinTwister();
        
		int i, ergebnis;
		// Wir oft wollen wir jeweils eine Münze werfen?
		final int n=100000;
		
		System.out.println("Wir simulieren Münzwürfe mit Math.Random!");
		for (i=0; i<n; i++) 
			counter(experiment1.throwCoin());
		
		// Statistik ausgeben
		System.out.println("\n");		
		System.out.println("Ergebnisse für Math.Random");
		System.out.println("-----------------------------------");
		printResults(n);

		// Counter zurücksetzen für das zweite Experiment
		countWappen=0;
		countZahl=0;
		
		System.out.println("\n");
		System.out.println("Wir simulieren Münzwürfe mit dem Mersenne-Twister!");
		for (i=0; i<n; i++) 
			counter(experiment2.throwCoin());
		
		// Statistik ausgeben
		System.out.println("\n");
		System.out.println("Ergebnisse für den Mersenne-Twister");
		System.out.println("-----------------------------------");
		printResults(n);
	}

	/** Variable für die absolute Häufigkeit für Wappen */
	private static int countWappen=0;
	/** Variable für die absolute Häufigkeit für Wappen */	
	private static int countZahl=0;
	
	/**
	 * Erfassen der Ergebnisse auf zwei Variablen
	 * 
	 * Die Funktion zählt die beiden Counter hoch. Es wird
	 * *nicht* überprüft, ob ergebnis nicht 0 ode 1 ist!
	 * Alle Eingaben ungleich 0 werden als Zahl interpretiert!
	 * 
	 * @param ergebnis Wappen (=0) oder Zahl (=1)?
	 */
	private static void counter(int ergebnis)
	{
		if (ergebnis==0)
			countWappen++;
		else
			countZahl++;
	}
	
	/**
	 * Ausgabe der absoluten Häufigkeiten als csv-Liste, mit Trenner Semikolon.
	 * 
	 * Die erste ausgegebene absolute Häufigkeit ist die Anzahl der Wappen, die zweite die Anzahl für Zahl.
	 * 
	 * @param n Anzahl der Experimente für die Berechnung der relativen Häufigkeiten
	 */
	private static void printResults(int n) 
	{	
		System.out.println("Es wurden " + n + " Simulationen durchgeführt!");
		System.out.println("Ausgabe der absoluten Häufigkeiten Wappen/Zahl als csv, Semikolon ist der Trenner.");
		System.out.println(countWappen + ";" + countZahl);
		System.out.println("Ausgabe der relativen Häufigkeiten Wappen/Zahl als csv, Semikolon ist der Trenner.");
		System.out.println((double)countWappen/n + ";" + (double)countZahl/n);
		System.out.println("Abweichungen Wappen/Zahl von der theoretischen relativen Häufigkeit 0.5 als csv, Semikolon ist der Trenner.");
		System.out.println(Math.abs((double)countWappen/n-0.5) + ";" + Math.abs((double)countZahl/n-0.5));		
		
	}

}
