package functions.collatz;

/*!
 * Hauptprogramm für den Test der Klasse Collatz
 */
public class CollatzMain {
	
	public static void main(String[] args) throws NumberFormatException {

		int a=16;
		
		if (args.length > 0) {
		    try {
		        a = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + args[0] + " must be an integer!");
		        System.exit(1);
		    }
		}
		
		System.out.println("Die Collatz-Folge mit dem Startwert " + a);		
		Collatz c = new Collatz(a);
		c.computeAndPrint();
	} 	
}
