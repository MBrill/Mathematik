package cryptography.DiffieHellmannMerkle;

import java.lang.String;
import java.util.*;
import java.io.*;

/**
 * Implementierung des Diffie-Hellmann-Merkle Kryptosystems.
 *
 * Klartext ist in Kleinbuchstaben, Code in Groﬂbuchstaben!
 */
public class Diffie {
	
	//! Convert plaintext letters to integer
	private static int p2i(char c)
	{
	   return (int)c-97;
	}

    //! Convert bitstring of length 7 to plaintext
	private static char i2p(int[] bits)
	{
	   int sum;
	   int offset = 32;
	   
	   sum = bits[0]*64 + bits[1]*32 + bits[2]*16 + bits[3]*8 + bits[4]*4
	         + bits[5]*2 + bits[6]*1;
	         
	   sum += offset;
	   
	   return (char)(sum);
	}
		
    //! Convert a String, the plaintext, to integers
    private static int[] s2i(String plain)
    {
    	int i;
    	int iplain[] = new int[plain.length()];
	    for (i = 0; i <plain.length(); i++)
		   iplain[i] = p2i(plain.charAt(i));
		return iplain;
    }
       
    /**
     *  Apply the Diffie-Hellmann-Merkle Encryption.
     *  
     *  1. Transform the message into a integer vector
     *  2. Transform the integer vector into sums.
     *  3. The sums encode the message.
     *
     *  @arg chiffre    chiffre is the integer vector, containint the
     *                  the plaintext, as output chiffre contains
     *                  the integers transmitted.
     *  @arg publicKey publicKey is Bob's public key
     *  @arg code      code contains the bits for the 26 characters.
     */
    public static void diffieEncrypt(int chiffre[], 
                                     int publicKey[],
                                     int code[][])
    {
    	int i, j, sum;
	    for (i=0; i<chiffre.length; i++)
	    {
             sum = 0;
             for (j=0; j<7; j++)
             {
                 sum += publicKey[j]*code[chiffre[i]][j];
             }

	         chiffre[i] = sum;
	    }
    }


    /**
     *  Apply the Diffie-Hellmann-Merkle Decryption.
     *  
     *  1. For every received integer B, compute
     *     the new integer B' = (B winv) (mod m).
     *  2. Use the private key to compute the 
     *     bit string corresponding to B'.
     *  3. Convert the bitstring to a lowercase letter.
     *
     *  @arg chiffre    chiffre contains the transmitted integers, the B's.
     *  @arg privateKey private is the Bob's private key
     *  @arg m          m is the used module
     *  @arg winv       winv is the multiplicative inverse of w 
     *                  modulo m.
     *  @arg code       code contains the bits for the 26 characters.
     *  @arg plaintext  the decrypted
     */
    public static void diffieDecrypt(int chiffre[], 
                                     int privateKey[],
                                     int m,
                                     int winv,
                                     int code[][],
                                     String plaintext)
    {
    	int i, j, k, sum;
    	int[] x = new int[7];
    	char[] text = new char[chiffre.length];

        for (i=0; i<chiffre.length; i++)
        {
            chiffre[i] = (chiffre[i]*winv) % m;
            System.out.println("B' = " + chiffre[i]);
            
            for (j=6; j>=0; j--)
            {
                sum = privateKey[j];
                for (k=j+1; k<7; k++) {
                    sum += x[k]*privateKey[k];
                }               
                if (sum <= chiffre[i]) {
                    x[j] = 1;
                }
                else {
                    x[j] = 0;
                }
                  
            }
            
            
            text[i] = i2p(x);           
        }
        plaintext = new String(text);
    }  

    private static final String FileInputName = "Diffie.in";
    private static final String FileOutputName = "Diffie.out";      
    
	public static void main(String[] args) throws IOException
	{
		int i, j, m, w, winv, n; 
				
        Scanner input = null;
        PrintStream output = null;
        
        String plaintext;     

        // Try-Block to catch IOExceptions
        try {
			input = new Scanner(new File(FileInputName));
			output = new PrintStream(new File(FileOutputName));
			
            m = input.nextInt();
            w = input.nextInt();
            winv = input.nextInt();
            n = 7;
            
            int[] bobPublic = new int[7];
            for (i=0; i<n; i++) 
            {
                bobPublic[i] = input.nextInt();
            }
            
            int[] bobPrivate = new int[7];
            for (i=0; i<n; i++) 
            {
                bobPrivate[i] = input.nextInt();
            }
                        

            plaintext = input.next();           
            
            int[][] code = new int[26][7];
            for (i=0; i<26; i++)
            {
               for (j=0; j<n; j++)
               {
                  code[i][j] = input.nextInt();
               }
            }
            
            int[] cipher = new int[plaintext.length()];
            cipher = s2i(plaintext);
            
            for (i=0; i<plaintext.length(); i++) 
            {
                output.print(cipher[i]+" ");
            }
            
                                    
            diffieEncrypt(cipher, bobPublic, code);
            
            output.println();            
            for (i=0; i<plaintext.length(); i++) 
            {
                output.print(cipher[i]+" ");
            }
         
            diffieDecrypt(cipher, bobPrivate, m, winv, code, plaintext);
            
            output.println();
            output.println(plaintext);
            
		
        } finally {
			if (input != null) input.close();
			if (output != null) output.close();
        }		
	}
}