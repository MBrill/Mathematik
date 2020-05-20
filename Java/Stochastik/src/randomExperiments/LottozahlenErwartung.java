import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.Well44497a;

/**
 * Simulation von 1000 Lotto-Ziehungen und zählen, wie häufig eine Zahl, beispielsweise 42,
 * gezogen wird.
 */
public class LottozahlenErwartung {

	public static void main(String[] args) {
		Well44497a well = new Well44497a();
		RandomDataGenerator generator = new RandomDataGenerator(well);
		
		// Wie oft simulieren wir?
		int max = 10000000;
		// Variablen
		int i, j, number=42;
		
		// Daten f�r die Lotto-Simulation
		int n=49, m = 6;
		int[] ziehung = new int[m],
			  statistik = new int[n];
		
		for (i=0; i<n; i++)
			statistik[i] = 0;
		
		System.out.println("Simulation von Lotto 6 aus 49");
		System.out.println("Zufallszahlengenerator: Well44497a aus der Apache Commons Math");
		System.out.println("Wir simulieren jetzt " + max + " Lottoziehungen!");
		System.out.println("Bitte haben Sie etwas Geduld!");
		System.out.println("Sobald die Simulation beendet ist erfolgt wieder eine Ausgabe auf der Konsole!");
		// Simulieren und die Häufigkeiten kumulieren
		for (i=0; i<max; i++) {
			ziehung = generator.nextPermutation(n, m);
			for (j=0; j<m; j++) {
				statistik[ziehung[j]]++;
			}
		}		
		System.out.println("Die Simulation ist beendet!\n\n");
		    
	    // Vergleichszahlen und Variable f�r die Schätzung der Wahrscheinlichkeit
	    double erwartet = (6.0/49.0); 
	    int erwartetFrequ = (int)(erwartet*max);
	    double computed = (double)statistik[number-1]/(double)max;
	    
	    System.out.println("Die Häufigkeit f�r die Zahl " + number + " ist " + statistik[number-1]);
	    System.out.println("Die erwartete absolute Häufigkeit f�r die Zahl " + number + " ist " + erwartetFrequ);	    
	    System.out.println("Der durch die Simulation geschätzte Wert für die Wahrscheinlichkeit ist " + computed);
	    System.out.println("Der erwartete Wert f�r die Wahrscheinlichkeit ist " + erwartet);
	}
}