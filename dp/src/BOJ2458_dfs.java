import java.util.*;
public class Main {	
	static final int SIZE = 500;
	static int[] big = new int[SIZE + 1];
	static int[] small= new int[SIZE + 1];
	static int[][] G = new int[SIZE + 1][SIZE + 1];
	static boolean[] visited = new boolean[SIZE + 1];
	static int V, E;
	static int parents(int v)
	{
	    visited[v] = true;
	    int cnt = 1;
	    for (int i = 1; i <= V; i++)
	    {
	        if (G[i][v] == 1 && visited[i]  == false)
	            cnt += parents(i);
	    }
	    return cnt;
	}
	static int subnode(int v)
	{
	    visited[v] = true;
	    int cnt = 1;
	    for (int i = 1; i <= V; i++)
	    {
	        if (G[v][i] == 1 && visited[i] == false)
	            cnt += subnode(i);
	    }
	    return cnt;
	}
	
	public static void main(String[] args)
	{
		
	    Scanner sc = new Scanner(System.in);
	    
	    V = sc.nextInt();
	    E = sc.nextInt();

	    int from, to;
	    for (int i = 0; i < E; i++)
	    {
	        from = sc.nextInt();
	        to = sc.nextInt();
	        G[from][to] = 1;
	    }
	    for (int i = 1; i <= V; i++)
	    {
	        for (int j = 1; j <= V; j++) visited[j] = false;
	        big[i] = parents(i) - 1;
	    }
	    for (int i = 1; i <= V; i++)
	    {
	        for (int j = 1; j <= V; j++) visited[j] = false;
	        small[i] = subnode(i) - 1;
	    }
	    int result = 0;
	    for (int i = 1; i <= V; i++)
	    {
	        if (big[i] + small[i] == V - 1)
	            result++;
	    }
	   System.out.println(result);
	   
	   sc.close();
	}
}
