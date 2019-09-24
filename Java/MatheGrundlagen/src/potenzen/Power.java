public class Power {
	
    // Konstruktor
    public Power() {
                a = 1;
                n = 1;
	        counter = 0;
    }
	
    public Power(int basis) {
		a = basis;
		n = 1;
	        counter = 0;
    }
	
    public Power(int basis, int exponent) {
		a = basis;
		n = exponent;
	        counter = 0;
    }
	
    public int compute() {
		int x=1;
		
		for (int i=0; i<this.n; i++) 
			x *= a;
		return x;
    }
	
    public int compute2() {
		int basis, x = 1, i = this.n;
		
		basis = a;
		counter = 0;
		while (i>0) {
			if (i%2 == 1) x *= basis;
			i = (int)Math.floor(i/2.0);
			if (i>0) basis *=basis;
			counter++;
		}
		return x;
    }
	
    public void setExponent(int e) {
	    n = e;
    }

    public int getCounter() {
	       return counter;
    }

    private int a;
    private int n;
    private int counter;
}
