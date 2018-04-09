/**
 * Hauptprogramm für den Test unseres linearen Kongruenz-Generators
 */
public class CongruentalMain {

	public static void main(String[] args) {
		// Eine Instanz erzeugen
		int m=37, a = 17, c = 1, x0 = 5;
		LinearCongruentalGenerator generator = new LinearCongruentalGenerator(m, a, c, x0);
		
		System.out.println("Test unseres eigenen linearen Kongruenz-Generators");
		System.out.println("Der Startwert ist " + generator.getSeed());
		System.out.println("Die erste Zufallszahl mit unserem linearen Kongruenz-Generator " + generator.next());
	}
}
