import java.util.*;
public class Main {	
	static final int SIZE = 500;	
	static boolean[][] D = new boolean[SIZE + 1][SIZE + 1];	
	static int V, E;	
	
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
	        D[from][to] = true;
	    }	    	
		
		for (int k = 1; k <= V; k++)
		{
			for (int i = 1; i <= V; i++)
			{
				if (i == k) continue;
				for (int j = 1; j <= V; j++)
				{
					if (j == k || j == i) continue;
					if(!D[i][j])
						D[i][j] = D[i][k] && D[k][j];
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= V; i++)
		{
			int sum = 0;
			for (int j = 1; j <= V; j++)
			{
				if (D[i][j]) sum++;
				if (D[j][i]) sum++;
			}
			if (sum == V - 1) cnt++;
		}		
	    System.out.println(cnt);
	   
	    sc.close();
	}
}
