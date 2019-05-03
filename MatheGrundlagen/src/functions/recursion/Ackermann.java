package functions.recursion;

/**
 * Beispiel aus Hoffmann, p. 150 zur Dokumentation
 * Im Code ist nicht nur keine Doku, sondern auch ein Fehler!!!
 */
public class Ackermann {
  
    public static void main (String[] args) {
        
	    System.out.println("compute(2,2) = "+ compute(2,2));
    } 

    static private int compute(int m, int n) {
	    while( m!=0) {
		    if (n==0) {
			    n = 1;
		    } 
	            else {
			    n = compute(m, n-1);
		    }
		    m--;
	    }
	    return n+1;
    }
} 
