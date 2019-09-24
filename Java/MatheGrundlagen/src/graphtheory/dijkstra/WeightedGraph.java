package graphtheory.dijkstra;

//import java.io.*;

/** Bewertete Graphen und kürzeste Wege.
 * 
 *  Klasse für die Repräsentation eines bewerteten,
 *  einfachen und zusammenhängenden Graphen und die
 *  Bestimmung der kürzesten Wege von einer Ausgangsecke
 *  aus mit Hilfe des Dijkstra-Algorithmus.
 *
 *  Die Funktion WeightedGraph::dijkstra berechnet <B>alle</B>
 *  kürzeste Wege ausgehend von einer Startecke. Das Ergebnis wird
 *  als Vorgängerbaum zurückgegeben. Ist der Graph nicht zusammenhängend,
 *  dann gibt diese Funktion false zurück.
 *
 *  Die Funktion WeightedGraph::shortestPath berechnet den
 *  kürzesten Weg von einer Start- zu einer Zielecke. Der berechnete Weg wird
 *  als Vorgängerbaum zurückgegeben. Ist der Graph nicht zusammenhängen,
 *  dann gibt diese Funktion false zurück.
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
            
    // Zwei gegebene Ecken auf Adjazenz überprüfen
    public boolean checkAdjacency(int i, int j)
    {
        if (this.a[i][j] > 0.0)
            return true;
        else
            return false;
    }

    // Namen für Ecke i zurückgeben    
    public String getName(int v)
    {
        return names[v];
    }
    
    // Alle Namen als Feld zurückgeben
    public String[] getNames()
    {
        return names;
    }
    
    // Die Grade aller Ecken zurückgeben
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

    // Die Anzahl der Kanten berechnen und zurückgeben
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
     * @param vertex Ecke, für die der Grad gesucht ist.
     * @return Falls ein ungültiger Eckpunktindex übergeben wird
     * gibt die Funktion -1 zurück!
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

    // Die Anzahl der Eckpunkte zurückgeben
    public int getNumberOfVertices() 
    {
    	return this.n;
    }
        
    /**
     *  Das Hand-Shaking Theorem sagt aus, dass die Summe aller Eckengrade
     *  eine gerade Zahl ist, gegeben durch die doppelte Anzahl der Kanten.
     *  Ist diese Gleichung verletzt repräsentiert die Matrix keinen Graphen.
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
     * Es werden *alle* kürzesten Wege von der Startecke a berechnet
     * und als Vorgängerbaum zurückgegeben.
     *
     * Ist die Instanz kein zusammenhängender Graph, dann
     * gibt die Funktion false zurück.
     *
     * @param start Startecke für den Dijkstra Algorithmus
     * @param pre Enthält den Vorgängerbaum für die kürzesten Wege.
     *           Muss von der aufrufenden Funktion mit der Anzahl
     *           der Ecken des Graphen dimensioniert werden.
     */
    public boolean dijkstra(int start, int[] pre)
    {
        int i,j;
        boolean[] inTree = new boolean[n];
        
        init(start, pre, inTree);
        
        // Überprüfen, ob es noch eine zu besuchende Ecke gibt
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
            // Punkt gefunden, Vorgängerbaum aktualisieren
            inTree[nYmin] = true;
            pre[nYmin] = nXmin;
            d[nYmin] = lMin;
            
            // Müssen wir noch Ecken besuchen?
            allReached = unVisited(inTree);
        }
        return true;
    }

    /** Implementierung des Dijkstra Algorithmus für eine gegebene Start- und Zielecke.
     * 
     * Berechnung des kürzesten Weges von der Startecke start zur Endecke end.
     *
     * Ist die Instanz kein zusammenhängender Graph, dann
     * gibt die Funktion false zurück.
     *
     * @param start Startecke
     * @param end Zielecke
     * @param path Enthält den Vorgängerbaum für den kürzesten Weg.
     */
    public boolean shortestPath(int start, int end, int length, int[] pre)
    {
        int i,j;
        boolean[] inTree = new boolean[n];
        //int pre[] = new int[n];
        
        init(start, pre, inTree);
        
        // Überprüfen, ob es noch eine zu besuchende Ecke gibt
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
            // Punkt gefunden, Vorgängerbaum aktualisieren
            inTree[nYmin] = true;
            pre[nYmin] = nXmin;
            d[nYmin] = lMin;
            if (nYmin == end)
                       return true;
            
            // Müssen wir noch Ecken besuchen?
            allReached = unVisited(inTree);
        }
        
        // Jetzt noch den Weg aus dem Vorgängerbaum
        // extrahieren und zurückgeben.
        /*int count = 1, pt = end;
        // Feststellen wie lange der Weg ist:
        while (pre[pt] != -1)
        {
            pt = pre[pt];
            count++;
        }
        // Jetzt den Weg übertragen
        pt = end;
        for (j=count-1; j>=0; j--)
        {
            path[j] = pt;
            pt = pre[pt];
        }*/
        return true;
    }
      
    /** Die Länge der berechneten kürzesten Wege zurückgeben.
     * 
     *  Das Feld enthält die Länge der kürzesten Wege, die von der Funktion
     *  WeightedGraph::dijkstra berechnet wurden.
     *
     *  Diese Funktion sollte <B>nach</B> einem Aufruf von WeightedGraph::dijkstra 
     *  aufgerufen werden. Dies wird <B>nicht</B> überprüft!
     */
    public double[] getLengths()
    {
        return d;
    }
 
    /**Die Länge des berechneten kürzesten Weges zurückgeben.
     * 
     *  Das Feld enthält die Länge des kürzesten Weges, die von der Funktion
     *  WeightedGraph::shortestPath berechnet wurden.
     *
     *  Diese Funktion sollte <B>nach</B> einem Aufruf von WeightedGraph::shortestpath 
     *  aufgerufen werden. Dies wird <B>nicht</B> überprüft!
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
  

    // Überprüfen, ob es noch unbesuchte Ecken gibt
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
    // Die Distanzen innerhalb des Vorgängerbaumes
    private double[] d;
    // Namen der Eckpunkte
    private String[] names;
}
