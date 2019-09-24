/**
 * class UndirectedGraph
 * @author Manfred Brill
 * 
 * Implementation of an undirected graph, represented by
 * by an adjacency matrix.
 *
 */
public class UndirectedGraph {
	
    //// Default-Construktor
    public UndirectedGraph() 
    {
	    this.n = 1;
	    this.a = new int[1][1];
	    a[0][0] = 0;
    }
	
	/// Constructor with dimension; no matrix
    public UndirectedGraph(int dim) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new int[n][n];
	    for (i=0; i<this.n; i++)
	       for (j=0; j<n; j++)
	          a[i][j] = 0;
    }

	/// Constructor with dimension and adjacency matrix
    public UndirectedGraph(int dim, int[][] matrix) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new int[n][n];
	    for (i=0; i<this.n; i++)
	       for (j=0; j<n; j++)
	          a[i][j] = matrix[i][j];
    }    

    /// Check if two vertices are adjacent
    public boolean checkAdjacency(int i, int j)
    {
        if (this.a[i][j] > 0)
            return true;
        else
            return false;
    }

    /// Check if the graph is simple
    public boolean isSimple()
    {
        int i,j;
        
        for (i=0; i<this.n; i++)
        for (j=0; j<this.n; j++)
             if ((a[i][j] < 0) || (a[i][j] > 1))
                return false;
        
        return true;
    }
    
    /// Get the number of vertices
    public int getNumberOfVertices() 
    {
    	return this.n;
    }

    /// Get the number of edges in the graph
    public int getNumberOfEdges()
    {
        int i, j, edges;
        
        edges = 0;
        
        for (i=0; i<this.n; i++)
        for (j=i; j<this.n; j++)
             if ((a[i][j] > 0))
                edges++;
                
        return edges;  
    } 
        
    /// Get the degrees of all vertices
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

    /// Get the degree of a vertex
    /*!
     * if the index is not valid, the function
     * returns -1!
     */
    public int getDegree(int vertex) 
    {
        int j, sum;

        if (vertex > 0 && vertex < n)
        {   
            sum = 0;
            for (j=0; j<n; j++)
                 sum += this.a[vertex][j];
            return sum;
        }
        else
            return -1;
    }  
      
    /// Check if for the graph the Handshaking Theorem is valid
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
                    
    /// Get the adjacency matrix
    public int[][] getAdjacencyMatrix() 
    {
        int[][] matrix = new int[n][n];    
        int i,j;
        for (i=0; i<n; i++)
        for (j=0; j<n; j++)
            matrix[i][j] = this.a[i][j];
        return matrix;
    }

    //! Number of vertices
    private int n;    
    //! Adjacency matrix
    private int[][] a;  
}
