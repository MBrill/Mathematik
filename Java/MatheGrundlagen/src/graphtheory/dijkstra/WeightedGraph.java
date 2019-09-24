package graphtheory.dijkstra;

//import java.io.*;

/** Bewertete Graphen und k�rzeste Wege.
 * 
 *  Klasse f�r die Repr�sentation eines bewerteten,
 *  einfachen und zusammenh�ngenden Graphen und die
 *  Bestimmung der k�rzesten Wege von einer Ausgangsecke
 *  aus mit Hilfe des Dijkstra-Algorithmus.
 *
 *  Die Funktion WeightedGraph::dijkstra berechnet <B>alle</B>
 *  k�rzeste Wege ausgehend von einer Startecke. Das Ergebnis wird
 *  als Vorg�ngerbaum zur�ckgegeben. Ist der Graph nicht zusammenh�ngend,
 *  dann gibt diese Funktion false zur�ck.
 *
 *  Die Funktion WeightedGraph::shortestPath berechnet den
 *  k�rzesten Weg von einer Start- zu einer Zielecke. Der berechnete Weg wird
 *  als Vorg�ngerbaum zur�ckgegeben. Ist der Graph nicht zusammenh�ngen,
 *  dann gibt diese Funktion false zur�ck.
 */
public class WeightedGraph 
{
	// Konstruktor mit Anzahl der Ecken, Bewertung ist 0.0
    public WeightedGraph(int dim) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new double[n][n];
	    this.names = new String[n];
	    
	    for (i=0; i<this.n; i++)
	    {
	       names[i] = " ";
	       for (j=0; j<n; j++)
	          a[i][j] = 0.0;
	    }
    }

	// Konstruktor mit Anzahl der Ecken und einer Bewertung
    public WeightedGraph(int dim, double[][] matrix) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new double[n][n];
	    this.names = new String[n];
	    	    
	    for (i=0; i<this.n; i++)
	    {
	       names[i] = " ";
	       for (j=0; j<n; j++)
	          a[i][j] = matrix[i][j];
	    }
    }  

	// Konstruktor mit Anzahl der Ecken und einer Bewertung
    public WeightedGraph(int dim, String[] nm, double[][] matrix) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new double[n][n];
	    this.names = new String[n];
	    	    
	    for (i=0; i<this.n; i++)
	    {
	       names[i] = nm[i];
	       for (j=0; j<n; j++)
	          a[i][j] = matrix[i][j];
	    }
    }  
            
    // Zwei gegebene Ecken auf Adjazenz �berpr�fen
    public boolean checkAdjacency(int i, int j)
    {
        if (this.a[i][j] > 0.0)
            return true;
        else
            return false;
    }

    // Namen f�r Ecke i zur�ckgeben    
    public String getName(int v)
    {
        return names[v];
    }
    
    // Alle Namen als Feld zur�ckgeben
    public String[] getNames()
    {
        return names;
    }
    
    // Die Grade aller Ecken zur�ckgeben
    public int[] getVertexDegrees() 
    {
        int[] degrees = new int[n];
        int i;
        for (i=0; i<n; i++)
        {
            degrees[i] = this.getDegree(i);
        }
        return degrees;
    }

    // Die Anzahl der Kanten berechnen und zur�ckgeben
    public int getNumberOfEdges()
    {
        int i, j, edges;
        
        edges = 0;       
        for (i=0; i<this.n; i++)
        for (j=i; j<this.n; j++)
             if ((a[i][j] > 0.0))
                edges++;

        return edges;  
    } 
        
    /**
     *  Den Grad einer Ecke berechnen.
     *  
     * @param vertex Ecke, f�r die der Grad gesucht ist.
     * @return Falls ein ung�ltiger Eckpunktindex �bergeben wird
     * gibt die Funktion -1 zur�ck!
     */
    public int getDegree(int vertex) 
    {
        int j, sum;

        if (vertex >= 0 && vertex < n)
        {   
            sum = 0;
            for (j=0; j<n; j++)
            {
                if (this.a[vertex][j]>0.0)
                 sum++;
            }
            return sum;
        }
        else
            return -1;
    }  

    // Die Anzahl der Eckpunkte zur�ckgeben
    public int getNumberOfVertices() 
    {
    	return this.n;
    }
        
    /**
     *  Das Hand-Shaking Theorem sagt aus, dass die Summe aller Eckengrade
     *  eine gerade Zahl ist, gegeben durch die doppelte Anzahl der Kanten.
     *  Ist diese Gleichung verletzt repr�sentiert die Matrix keinen Graphen.
     */
    public boolean checkHandshake()
    {
        int i, sum;
        int[] degrees = new int[this.n];
        
        degrees = this.getVertexDegrees();
        int e = this.getNumberOfEdges();
        
        sum = 0;
        for (i=0; i<this.n; i++)
             sum += degrees[i];
             
        if (sum == 2*e)
            return true;
        else
            return false;
    }
        
    // Die Adjazenzmatrix abfragen
    public double[][] getAdjacencyMatrix() 
    {
        double[][] matrix = new double[n][n];    
        int i,j;
        for (i=0; i<n; i++)
        for (j=0; j<n; j++)
            matrix[i][j] = this.a[i][j];
        return matrix;
    }

          
    /**
     * Es werden *alle* k�rzesten Wege von der Startecke a berechnet
     * und als Vorg�ngerbaum zur�ckgegeben.
     *
     * Ist die Instanz kein zusammenh�ngender Graph, dann
     * gibt die Funktion false zur�ck.
     *
     * @param start Startecke f�r den Dijkstra Algorithmus
     * @param pre Enth�lt den Vorg�ngerbaum f�r die k�rzesten Wege.
     *           Muss von der aufrufenden Funktion mit der Anzahl
     *           der Ecken des Graphen dimensioniert werden.
     */
    public boolean dijkstra(int start, int[] pre)
    {
        int i,j;
        boolean[] inTree = new boolean[n];
        
        init(start, pre, inTree);
        
        // �berpr�fen, ob es noch eine zu besuchende Ecke gibt
        boolean allReached = unVisited(inTree);
        
        boolean found = true;
        while ((!allReached) && found)
        {
            int nXmin = -1, nYmin = -1;
            double lMin=Double.MAX_VALUE;
            found = false;
            //boolean first = true;
            
            for (i=0; i<n; i++)
            {
                if (inTree[i])
                {
                    for (j=0; j<n; j++)
                    {
                        if ((!inTree[j]) && checkAdjacency(i,j))
                        {
                            found = true;
                            if (lMin > d[i]+a[i][j])
                            {
                                nXmin = i;
                                nYmin = j;
                                lMin = d[i]+a[i][j];
                            }
                        }
                    }
                }
            }
            if (!found) return false;
            // Punkt gefunden, Vorg�ngerbaum aktualisieren
            inTree[nYmin] = true;
            pre[nYmin] = nXmin;
            d[nYmin] = lMin;
            
            // M�ssen wir noch Ecken besuchen?
            allReached = unVisited(inTree);
        }
        return true;
    }

    /** Implementierung des Dijkstra Algorithmus f�r eine gegebene Start- und Zielecke.
     * 
     * Berechnung des k�rzesten Weges von der Startecke start zur Endecke end.
     *
     * Ist die Instanz kein zusammenh�ngender Graph, dann
     * gibt die Funktion false zur�ck.
     *
     * @param start Startecke
     * @param end Zielecke
     * @param path Enth�lt den Vorg�ngerbaum f�r den k�rzesten Weg.
     */
    public boolean shortestPath(int start, int end, int length, int[] pre)
    {
        int i,j;
        boolean[] inTree = new boolean[n];
        //int pre[] = new int[n];
        
        init(start, pre, inTree);
        
        // �berpr�fen, ob es noch eine zu besuchende Ecke gibt
        boolean allReached = unVisited(inTree);
        
        boolean found = true;
        while ((!allReached) && found)
        {
            int nXmin = -1, nYmin = -1;
            double lMin=Double.MAX_VALUE;
            found = false;
            //boolean first = true;
            
            for (i=0; i<n; i++)
            {
                if (inTree[i])
                {
                    for (j=0; j<n; j++)
                    {
                        if ((!inTree[j]) && checkAdjacency(i,j))
                        {
                            found = true;
                            if (lMin > d[i]+a[i][j])
                            {
                                nXmin = i;
                                nYmin = j;
                                lMin = d[i]+a[i][j];
                            }
                        }
                    }
                }
            }
        
            if (!found) return false;
            // Punkt gefunden, Vorg�ngerbaum aktualisieren
            inTree[nYmin] = true;
            pre[nYmin] = nXmin;
            d[nYmin] = lMin;
            if (nYmin == end)
                       return true;
            
            // M�ssen wir noch Ecken besuchen?
            allReached = unVisited(inTree);
        }
        
        // Jetzt noch den Weg aus dem Vorg�ngerbaum
        // extrahieren und zur�ckgeben.
        /*int count = 1, pt = end;
        // Feststellen wie lange der Weg ist:
        while (pre[pt] != -1)
        {
            pt = pre[pt];
            count++;
        }
        // Jetzt den Weg �bertragen
        pt = end;
        for (j=count-1; j>=0; j--)
        {
            path[j] = pt;
            pt = pre[pt];
        }*/
        return true;
    }
      
    /** Die L�nge der berechneten k�rzesten Wege zur�ckgeben.
     * 
     *  Das Feld enth�lt die L�nge der k�rzesten Wege, die von der Funktion
     *  WeightedGraph::dijkstra berechnet wurden.
     *
     *  Diese Funktion sollte <B>nach</B> einem Aufruf von WeightedGraph::dijkstra 
     *  aufgerufen werden. Dies wird <B>nicht</B> �berpr�ft!
     */
    public double[] getLengths()
    {
        return d;
    }
 
    /**Die L�nge des berechneten k�rzesten Weges zur�ckgeben.
     * 
     *  Das Feld enth�lt die L�nge des k�rzesten Weges, die von der Funktion
     *  WeightedGraph::shortestPath berechnet wurden.
     *
     *  Diese Funktion sollte <B>nach</B> einem Aufruf von WeightedGraph::shortestpath 
     *  aufgerufen werden. Dies wird <B>nicht</B> �berpr�ft!
     */
    public double getLength(int ende)
    {
        return d[ende];
    }
        
    //! Den Algorithmus initialisieren
    private void init(int start, int[] pre, boolean[] inTree)
    {
        int i;
         
        d = new double[n];
        
        for (i=0; i<n; i++)
        {
            d[i] = Double.MAX_VALUE;
            pre[i] = -1;
            inTree[i] = false;
        }
        d[start] = 0;
        inTree[start] = true;
    }
  

    // �berpr�fen, ob es noch unbesuchte Ecken gibt
    private boolean unVisited(boolean[] inTree)
    {
        boolean all = true;
        for (int i=0; i<n && all; i++)
        {
            if (!inTree[i])
                all = false;
        }
        return all;
    }                
    
    // Anzahl der Eckpunkte im Graphen
    private int n;    
    // Die Adjazenzmatrix
    private double[][] a;   
    // Die Distanzen innerhalb des Vorg�ngerbaumes
    private double[] d;
    // Namen der Eckpunkte
    private String[] names;
}
