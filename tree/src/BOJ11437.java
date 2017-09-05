// LCA https://www.acmicpc.net/problem/11437
import java.util.*;

public class Main {
	static ArrayList<Integer>[] G = new ArrayList[50010];
	static int[] p = new int[50001];
	static boolean[] visit = new boolean[50001];
	
	static void BFS(int v)
	{
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(v);
		visit[v] = true;
		while(!Q.isEmpty())
		{
			v = Q.poll();
			
			for(int u: G[v])
			{
				if(!visit[u])
				{
					Q.add(u); visit[u] = true;
					p[u] = v;
				}
			}
		}
	}
	static int findLCA(int v1, int v2)
	{
		int v, lca = 1;
		
		v = v1;
		while(v != 0)
		{
			visit[v] = true;
			v = p[v];
		}
		
		v = v2;		
		while(v != 0)
		{
			if(visit[v]) 
			{
				lca = v; break;
			}
			v = p[v];
		}
		v = v1;
		while(v != 0)
		{
			visit[v] = false;
			v = p[v];
		}
		return lca;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i = 0; i <= N; i++)
			G[i] = new ArrayList<Integer>();
				
		for(int i = 0; i < N - 1; i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			G[v1].add(v2);
			G[v2].add(v1);
		}
		BFS(1);
		
		for(int i = 1; i <= N; i++)
			visit[i] = false;
		
		int M = sc.nextInt();
		
		for(int i = 0; i < M; i++)
		{
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			System.out.println(findLCA(v1, v2));
		}	
		sc.close();
	}
}
