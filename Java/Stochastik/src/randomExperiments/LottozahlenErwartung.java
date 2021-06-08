import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.Well44497a;
import java.util.Vector;
import java.util.Scanner;

/**
 * Simulation von 1000 Lotto-Ziehungen. 
 * 
 * Wir bestimmen die Häufigkeit dafür, dass eine
 * Zahl in der Ziehung auftaucht.
 * Die Zahl kann eingegeben werden, als Default 
 * verwenden wir die Zahl 42.
 */
public class LottozahlenErwartung {

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		Well44497a well = new Well44497a();
		RandomDataGenerator generator = new RandomDataGenerator(well);
		Lotto6aus49 simulation = new Lotto6aus49(generator);
		
		// Wie oft simulieren wir?
		int max = 10000000;
		// Variablen
		int i, j, number=42;
		
		// Daten für die Lotto-Simulation
		int n=49, m=6;
		
		System.out.println("Simulation von Lotto 6 aus 49");
		System.out.println("Zufallszahlengenerator: Well44497a aus der Apache Commons Math");
		System.out.println("Für welche Zahl möchten sie nach der Simulation die Häufigkeiten wissen?");
		System.out.println("Geben Sie bitte eine Zahl zwischen 1 und 49 ein!");
		System.out.println("Ungültige Eingaben führen zur Verwendung der interessantesten Zahl - 42");
		number = in.nextInt();
		if (number < 1 || number > n) {
			number = 42;
			System.out.println("\n42! Good Choice!\n");
		}
		
		in.close();
		
		int[] statistik = new int[n];
		
		for (i=0; i<n; i++)
		{
			statistik[i] = 0;
		}
		
		System.out.println("Danke! Nach der Simulation werde ich Ihnen die Häufigkeit für die Zahl " + number + " ausgeben!");
		System.out.println("Wir simulieren jetzt " + max + " Lottoziehungen!");
		System.out.println("Bitte haben Sie etwas Geduld!");
		System.out.println("Sobald die Simulation beendet ist erfolgt wieder eine Ausgabe auf der Konsole!");
		
		
		// Simulieren und die Häufigkeiten kumulieren
		for (i=0; i<max; i++) {
			Vector<Integer>  ziehung = new Vector<Integer>(6);
			ziehung = simulation.draw();
			for (j=0; j<ziehung.size(); j++) 
			{
				statistik[ziehung.get(j)-1]++;
			}
		}		
		System.out.println("Die Simulation ist beendet!\n\n");
		    
	    // Vergleichszahlen und Variable für die Schätzung der Wahrscheinlichkeit
	    double erwartet = (6.0/49.0); 
	    int erwartetFrequ = (int)(erwartet*max);
	    double computed = (double)statistik[number-1]/(double)max;
	    
	    System.out.println("Die absolute Häufigkeit für die Zahl " + number + " ist " + statistik[number-1]);
	    System.out.println("Die erwartete absolute Häufigkeit für die Zahl " + number + " ist " + erwartetFrequ);	    
	    System.out.println("Der durch die Simulation geschätzte Wert für die Wahrscheinlichkeit ist " + computed);
	    System.out.println("Der erwartete Wert für die Wahrscheinlichkeit ist " + erwartet);
	    double relError = Math.abs(computed-erwartet)/erwartet;
	    System.out.println("Die Abweichung zwischen diesen beiden Zahlen beträgt " + relError);
	}
}