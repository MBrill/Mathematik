/**
 * Simulation der exponential-verteilten PKW-Werkstatt
 * Aufgabe 1.6
 */

import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.Well44497a;

public class PKWSimulation {

	public static void main(String[] args) {
		Well44497a well = new Well44497a();
		RandomDataGenerator generator = new RandomDataGenerator(well);
		
		// Erwartungswert ist 1/lambda ...
		double mean = 4.0;
		double lambda = 1.0/mean;
		
		int i;
		int n=1000000;
		double[] values = new double[n];
		
		System.out.println("Simulation einer Warteschlange in einer PKW-Werkstatt");		
		System.out.println("Die Daten werden erzeugt!");
		
		// Die Funktion nextExponential erwartet den Mittelwert, also 1/lambda!
		// Daten produzieren
		for (i=0; i<n; i++)
			values[i] = generator.nextExponential(mean);
		
		// Größen, um Mittelwert und empirische Varianz zu berechnen ...
		double average, variance, stddev;		
		System.out.println("Die Daten sind jetzt erzeugt worden, wir beginnen mit der Analyse!");		
		// Daten analysieren
		// 1. Den Mittelwert der Werte berechnen
		average = 0.0;
		for (i=0; i<n; i++)
			average += values[i];
		average /= n;
		
		System.out.println("Der Erwartungswert der verwendeten Exponentialverteilung mit Parameter lambda = " + lambda + " ist " + mean);
		System.out.println("Der empirische Mittelwert der erzeugten Daten ist gegeben durch " +  average);
		// 2. Die empirisiche Varianz berechnen
		variance = 0.0;
		for (i=0; i<n; i++)
			variance += values[i]*values[i];
		variance /= n;
		variance -= average*average;
		
		stddev = Math.sqrt(variance);
		System.out.println("Die Standardabweichung der verwendeten Exponentialverteilung mit Parameter lambda = " + lambda + " ist " + mean);		
		System.out.println("Der empirische Varianz der Daten ist gegeben durch  " +  stddev);		
	}
}
