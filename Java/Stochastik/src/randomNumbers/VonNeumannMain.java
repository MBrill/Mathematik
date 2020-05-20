/**
 * Hauptprogramm für die Untersuchung der Mid-Square Methode
 * Diese Methode selbst ist in der Klasse VonNeumann implementiert.
 */
public class VonNeumannMain 
{
	public static void main(String[] args) {
		int i,  value, counter, seed;
		// Variable für die Zyklenlänge für jeden Startwert
		int[] cycles = new int[100];
		// Variable für den Stopwert, um zu untersuchen, mit welchem Wert die Folge stoppt.
		int[] stopValue = new int[100];

		// Matrix für die Ausgabe der einzelnen Folgen
		// Der längste Zyklus ist durch 15 Zahlen gegeben ...
		int[][] sequences = new int[100][15];
		// Implementierung der Mid-Square Methode für zweistellige Dezimalzahlen
		VonNeumann mid = new VonNeumann();
		// Hash für die Entscheidung, ob ein Zyklus erreicht wurde
		boolean stop = false;
		boolean[] hash = new boolean[100];
		for (i=0; i<100; i++)
			hash[i] = false;
		
		// Jetzt führen wir das Experiment durch
		for (seed=0; seed<100; seed++) {
            // Alle Startwerte durchlaufen
			mid.setSeed(seed);
			// Alle Variablen zurücksetzen
			counter = 0;
		    // hash zurücksetzen
			for (i=0; i<100; i++)
				hash[i] = false;
			stop = false;
			// Startwert in das Ergebnisfeld eintragen und Folge berechnen
			sequences[seed][counter] = seed;
		    while (!stop) {
		    	value = mid.next();
		    	counter++;
		    	if (!hash[value]) {
		    		hash[value] = true;
		    		sequences[seed][counter] = value;
		    	}
		    	else {
		    		stopValue[seed] = value;
		    		stop = true;
		    	}
		    } // end while
		    // Länge des Zyklus speichern
		    cycles[seed] = counter;
		}
		
		
		// Maximum der Werte im Feld cycles bestimmen
		int max = cycles[0];
		for (seed=1; seed<100; seed++) {
			if (cycles[seed]>max) 
				max = seed;
		}
		
		// Die absoluten Häufigkeiten bestimmen, mit denen die einzelnen Stopwerte auftreten
		// Variable, mit der wir die Häufigkeiten f�r diese Stopwerte
		// Es gibt die folgenden Möglichkeiten, an denen ein Zyklus stoppt:
		// 0, 0
		// 10, 10
		// 50, 50
		// 60, 60
		// 24, 57, 24,57
		// Die Stopwerte f�r jeden Startwert stehen im Feld stopValue.
		// stopFrequency[0] gehört zu 0, 1 zu 10, 2 zu 50,
		// der Index 3 zu 60, 60, 
		// der Index 4 zu 24, 57.
		int[] stopFrequency = new int[5];
		for (seed=0; seed<100; seed++) {
			switch (stopValue[seed]) {
			case 0: stopFrequency[0]++; break;
			case 10: stopFrequency[1]++; break;
			case 50: stopFrequency[2]++; break;
			case 60: stopFrequency[3]++; break;
			case 24: stopFrequency[4]++; break;
			default: // tunix
				break;
			}
		}
		// Ergebnisse ausgeben
		System.out.println("Untersuchung der Mid-Square Methode für zweistellige Dezimalstellen");
		System.out.println("Die Folge mit dem längstem Zyklus hat den Startwert "+ max + " und die Zykluslänge " + cycles[max]+ ".");
		System.out.print("\nDieser Zyklus lautet: ");
		for (i=0; i<cycles[max]; i++)
			System.out.print(sequences[max][i]+ " ");
		System.out.println("\n");
		System.out.println("Die einzelnen Stopwerte wurden mit den folgenden absoluten Häufigkeiten erreicht:");
		System.out.println("0, 0 wurde " + stopFrequency[0] + "-mal erreicht");
		System.out.println("10, 10 wurde " + stopFrequency[1] + "-mal erreicht");
		System.out.println("50, 50 wurde " + stopFrequency[2] + "-mal erreicht");
		System.out.println("60, 60 wurde " + stopFrequency[3] + "-mal erreicht");
		System.out.println("24, 57, 24 wurde " + stopFrequency[4] + "-mal erreicht");
		
		// Ausgabe alle Zyklen Ergebnisse, falls Variable all auf true gesetzt wird
		boolean all = false;
	
		if (all) {
			for (seed=0; seed<100; seed++) {
				System.out.println("Der Startwert " + seed);
				System.out.println("Zykluslänge " + cycles[seed]);
				System.out.println("Der letzte Wert des Zyklus " + stopValue[seed]);
				System.out.println("Der Zyklus");
				for (i=0; i<cycles[seed]; i++)
					System.out.print(sequences[seed][i] + " ");
				System.out.println("\n---");		
				}
			}
	}
}