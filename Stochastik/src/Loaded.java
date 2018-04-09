
import java.io.File;
import java.io.IOException;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.ValueServer;

/**
 * Simulation eines "gezinkten" Würfels mit der Klasse ValueServer
 * der Apache Commons Math
 */
public class Loaded {
	public static void main(String[] args) {
		
		// Twister
		MersenneTwister twister = new MersenneTwister();	
		ValueServer server = new ValueServer(twister);
		
		System.out.println("Ein Würfel auf der Basis von Häufigkeiten in der Datei loadedData.txt");
		try {
			  server.setValuesFileURL(new File("loadedData.txt").toURI().toURL());
	    } catch (IOException e) {
		       e.printStackTrace();
	    } finally {}
		
		
		// Daten lesen und die empirische Verteilung bauen
		System.out.println("1. Die Daten werden gelesen und die empirische Verteilung wird aufgebaut!");
		server.setMode(ValueServer.DIGEST_MODE);
		try {
			server.computeDistribution(6);
		} catch (IOException e) {
		       e.printStackTrace();	
        }		
	    finally {}	
		
		// Zufallszahlen erzeugen und ausgeben
		System.out.println("2. Mit der erstellten Verteilung werden jetzt 10 zufällige Würfelergebnisse erzeugt:");
		double value;
		try {
			for (int i=0; i<10; i++)
			{
				value = server.getNext();
				System.out.print((int)value+ " ");
			}
		} catch (IOException e) {
		       e.printStackTrace();	
        }		
	    finally {}	
	}
}


