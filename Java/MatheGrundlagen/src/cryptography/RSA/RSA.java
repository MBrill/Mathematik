package cryptography.RSA;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

/**
 * Implementierung von RSA.
 *
 * We use the class BigInteger, to get rid of the constraints
 * of int and long.
 *
 * In RSA.in we get the following numbers:
 *    1. the module m
 *    2. Bob's public key e
 *    3. Bob's private key d
 *    4. the plaintext.
 *
 * In RSA.out we see the ciphertext, consisting of numbers, and the
 * plaintext again.
 * 
 * @author Manfred Brill
 */
public class RSA 
{

	//! Convert plaintext letters to BigInteger
	private static BigInteger c2i(char c)
	{
	   return BigInteger.valueOf((long)c);
	}

	//! Convert an BigInteger to a plaintext letter
	private static char i2c(BigInteger i)
	{
	   return (char)(i.intValue());
	}
	
	//! Convert the plaintext to an array of numbers
	private static BigInteger[] s2i(String plain)
	{
		int i;
		BigInteger bigPlain[] = new BigInteger[plain.length()];
		for (i = 0; i<plain.length(); i++)
		{
		   bigPlain[i] = c2i(plain.charAt(i));
		}
		return bigPlain;
	}
    
	//! Convert an array of BigInteger to a String
	private static String i2s(BigInteger[] chiffre)
	{
		int i;
		String text = new String("");
		for (i = 0; i<chiffre.length; i++)
			 text += i2c(chiffre[i]);
		return text;
	}
		
    /**
     *  Apply the RSA Encryption.
     *  
     *  1. Transform the message into a integer vector
     *  2. Use modular powers for the encrpytion
     *
     *  @arg chiffre    the integer vector, containint the
     *                  the plaintext, as output chiffre contains
     *                  the integers transmitted.
     *  @arg publicKey  Bob's public key
     *  @arg m          the module used for the arithmetic
     */	
	public static void rsaEncrypt(BigInteger[] chiffre,
	                              BigInteger publicKey, 
	                              BigInteger m) 
	{
		int i;
		BigInteger big;
				
		for (i=0; i<chiffre.length; i++) {
			big = chiffre[i];
			chiffre[i] = big.modPow(publicKey, m);
		}
	}

    /**
     *  Apply the RSA Decryption.
     *  
     *  1. Use the private key and modular powers for the decryption.
     *  2. Convert the numbers to a String.
     *
     *  @arg chiffre    the integer vector, containint the
     *                  the plaintext, as output chiffre contains
     *                  the integers transmitted.
     *  @arg privateKey Bob's private key
     *  @arg m          he module used for the arithmetic
     */	
	public static void rsaDecrypt(BigInteger chiffre[],
	                              BigInteger privateKey, 
	                              BigInteger m)
	{
		int i;
		BigInteger ziffer;

		for (i=0; i<chiffre.length; i++) 
		{
		    ziffer = chiffre[i].modPow(privateKey, m);
		    chiffre[i] = ziffer;
		}
	}
    /**
     * Name der Eingabedatei.
     */	
    private static final String FileInputName = "RSA.in";
    /**
     * Name der Ausgabedatei.
     */    
    private static final String FileOutputName = "RSA.out";      
    
	public static void main(String[] args) throws IOException
	{
		int i; 
				
        Scanner input = null;
        PrintStream output = null;    

        // Try-Block to catch IOExceptions
        try {
			input = new Scanner(new File(FileInputName));
			output = new PrintStream(new File(FileOutputName));

            BigInteger publicKey, privateKey, module;         
     
            module = new BigInteger(input.next());
            publicKey = new BigInteger(input.next());
            privateKey = new BigInteger(input.next());

            String plaintext;                         
            plaintext = input.next();                                  

            BigInteger[] cipher = new BigInteger[plaintext.length()];
            cipher = s2i(plaintext);
            
            for (i=0; i<plaintext.length(); i++) 
            {
                output.print(cipher[i]+" ");
            }
            
                                              
            rsaEncrypt(cipher, publicKey, module);          
            for (i=0; i<plaintext.length(); i++) 
            {
                output.print(cipher[i]+" ");
            }

            output.println();
            for (i=0; i<plaintext.length(); i++) 
            {
                output.print(cipher[i]+" ");
            }  
            rsaDecrypt(cipher, privateKey, module);
                      
            plaintext = i2s(cipher);     
            output.println();
            output.println(plaintext);
            
		
        } finally {
			if (input != null) input.close();
			if (output != null) output.close();
        }		

	}
}
