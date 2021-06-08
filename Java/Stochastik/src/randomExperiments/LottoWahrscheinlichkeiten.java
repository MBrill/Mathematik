import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.Well44497a;

import java.util.*;

/**
 * Simulation von 100 000 000 Lotto-Ziehungen. 
 * 
 * Wir wählen sechs Zahlen, unseren Tipp, aus
 * und überprüfen pro Ziehung, ob wir 6 Richtige haben.
 * 
 * Am Ende geben wir die relative Häufigkeit für 6 Richtige aus.
 */
public class LottoWahrscheinlichkeiten {

	public static void main(String[] args) 
	{

		Well44497a well = new Well44497a();
		RandomDataGenerator generator = new RandomDataGenerator(well);
		Lotto6aus49 simulation = new Lotto6aus49(generator);
		
		// Wie oft simulieren wir?
		int max = 1000000000;
		int frequency = 0;
		
        tipp = new LinkedList<Integer>();
		draw = new Vector<Integer>(6);
		
		// Wie besetzen den Tipp
		tipp.add(42);
		tipp.add(7);
		tipp.add(12);
		tipp.add(18);
		tipp.add(4);
		tipp.add(11);
		
	System.out.println("Simulation von Lotto 6 aus 49");
		System.out.println("Zufallszahlengenerator: Well44497a aus der Apache Commons Math");
		System.out.println("Wir führen " + max + " Ziehungen durch.");
		System.out.println("Wir verwenden den Tipp " + tipp);

		
		System.out.println("Nach der Simulation geben wir die relative Häufigkeit für 6 Richtige aus!");
		System.out.println("Wir simulieren jetzt " + max + " Lottoziehungen!");
		System.out.println("Bitte haben Sie etwas Geduld!");
		System.out.println("Sobald die Simulation beendet ist erfolgt wieder eine Ausgabe auf der Konsole!");
		
		for (int i=0; i<max; i++)
		{
			draw = simulation.draw();
			if (success())  {
				frequency++;
				System.out.println("6 Richtige!");
			}
		}
		
		System.out.println("Die Simulation ist beendet!\n\n");
		System.out.println("Die relative Häufigkeit von 6 Richtigen ist " + ((double)frequency/(double)max));
		    

	}
	
	static private Vector<Integer> draw;
	static private List<Integer> tipp;
	
	static private boolean success()
	{
		// Vector respektiert Ordnung, deshalb wandeln wir das zu Listen
		List<Integer> drawList = new LinkedList<Integer>(draw);
		
		return drawList.equals(tipp);
	}
}