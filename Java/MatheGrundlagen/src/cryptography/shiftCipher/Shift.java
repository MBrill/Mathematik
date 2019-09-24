package cryptography.shiftCipher;

 
import java.lang.String;
import java.util.*;
import java.io.*;

/**
 * Schiefe-Chiffren.
 * 
 * Klartext ist in Kleinbuchstaben, Code in Großbuchstaben!
 * 
 * @author Manfred Brill
 */
public class Shift {
	
	/**
	 * Klartext zu einer natürliche Zahl.
	 * 
	 * @param c Buchstabe, der umgewandelt wird
	 * @return  Zahlencode
	 */
	private static int p2i(char c)
	{
	   return (int)c-97;
	}


   /**
     * Natürliche Zahl zu Klartext
     * 
     * @param i Zahl im Code
     * @return Buchstabe
     */
	private static char i2p(int i)
	{
	   return (char)(i+97);
	}
	
		
    /**
     * Natürliche Zahl zu Chiffretext.
     * 
     * @param i Zahl im Code
     * @return Buchstabe
     */
	private static char i2c(int i)
	{
	   return (char)(i+65);
	}
	
    /**
     * Den Klartext als String in Zahlenfolge wandeln.
     * 
     * @param plain Klartext
     * @return Zahlenfolge
     */
    private static int[] s2i(String plain)
    {
    	int i;
    	int iplain[] = new int[plain.length()];
	    for (i = 0; i<plain.length(); i++)
		   iplain[i] = p2i(plain.charAt(i));
		return iplain;
    }
    
    /**
     * Ein Feld mit Zahlenwerten zu Klartext wandeln.
     * 
     * @param chiffre Zahlenwerte
     * @return String mit Klartext
     */
    private static String i2sp(int chiffre[])
    {
    	int i;
    	String plain = new String("");
	    for (i = 0; i<chiffre.length; i++)
		     plain += i2p(chiffre[i]);
		return plain;
    }

    /**
     * Ein Feld mit Zahlenwerten in Chiffretext wandeln.
     * 
     * @param chiffre Zahlenwerte
     * @return String mit Chiffretext
     */
    private static String i2sc(int chiffre[])
    {
    	int i;
    	String cipher = new String("");
	    for (i = 0; i<chiffre.length; i++)
		     cipher += i2c(chiffre[i]);
		return cipher;
    }
    
    /**
     *  Schiebe-Chiffre anwenden.
     *  
     *  @arg k Schlüssel
     *  @arg chiffre Nachricht, als Folge von natürlichen Zahlen
     */
    public static void shiftEncrypt(int k, int chiffre[])
    {
    	int i;
	    for (i=0; i<chiffre.length; i++)
	    {
	      chiffre[i] = (chiffre[i] + k) % 26;
	      // Add 26, so the decryption is easier!
	      if (chiffre[i] < 0 ) chiffre[i] += 26;
	    }
    }
	
    /**
     * De-Chiffririerung.
     *  
     *  @arg k Schlüssel
     *  @arg chiffre Nachricht, als Folge von natürlichen Zahlen       
     */
    public static void shiftDecrypt(int k, int chiffre[])
    {
	   shiftEncrypt(-k, chiffre);
    }  

    /**
     * Name der Eingabedatei.
     */
    private static final String FileInputName = "Shift.in";
    /**
     * Name der Ausgabedatei.
     */
    private static final String FileOutputName = "Shift.out";      
    
	public static void main(String[] args) throws IOException
	{
		int i; 
		
		
        Scanner input = null;
        PrintStream output = null;
        
        int key;
        String plaintext, ciphertext;     

        try {
			input = new Scanner(new File(FileInputName));
			output = new PrintStream(new File(FileOutputName));
			
            key = input.nextInt(); 
            plaintext = input.next();
            
            int[] cipher = new int[plaintext.length()];
            cipher = s2i(plaintext);
            
            for (i=0; i<plaintext.length(); i++) 
            {
                output.print(cipher[i]+" ");
            }
            

            shiftEncrypt(key, cipher);
            output.println();            
            for (i=0; i<plaintext.length(); i++) 
            {
                output.print(cipher[i]+" ");
            }
            
            ciphertext = i2sc(cipher);
            
            output.println();
            output.println(ciphertext);   
            
            shiftDecrypt(key, cipher);          
            for (i=0; i<plaintext.length(); i++) 
            {
                output.print(cipher[i]+" ");
            }
            
            String plain2 = i2sp(cipher);
            output.println();
            output.println(plain2);              
                                            
                                                     	
			
        } finally {
			if (input != null) input.close();
			if (output != null) output.close();
        }		

	}
}