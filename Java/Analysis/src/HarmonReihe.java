/*!
 * Aufsummieren der harmonischen Reihe in float und in double-Genauigkeit.
 */
import java.io.*;

public class harmonReihe {
  
// -------------------------------------------------
public static void main (String[] args) throws IOException {
  long N = readInt(), phi;
  System.out.println("---------------------------------------------------------------");
  System.out.println("Aufsummieren der harmonischen Reihe\n");
  
  System.out.println("Die Summe in float-Genauigkeit bis 1/"+N+" :" + floatSum(N));
  
  System.out.println("\nDie Summe in double-Genauigkeit bis 1/"+N+" :" + doubleSum(N));
  System.out.println("---------------------------------------------------------------");
} 
   
public static int readInt() throws IOException {
  int n;
  BufferedReader in = new BufferedReader(
			new InputStreamReader(
                          System.in));
  
  System.out.print("Geben sie die Anzahl der Summanden an: ");
  n = Integer.parseInt(in.readLine());
  
  return n;
} 

public static double doubleSum (long N) 
{
  int i; 
  double summe=(double)1.0;
  
  for (i=2; i<=N; i++)
  	summe += 1.0/((double)i);
  
  return summe;
} 

public static float floatSum (long N) 
{
  int i; 
  float summe=(float)1.0;
  
  for (i=2; i<=N; i++)
  	summe += 1.0/((float)i);
  
  return summe;
}   
} 
