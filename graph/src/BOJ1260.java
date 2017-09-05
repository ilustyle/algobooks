// DFS-BFS https://www.acmicpc.net/problem/1260
import java.util.*;

public class Main {

	static int[][] G = new int[1001][1001];	
	static boolean[] visit = new boolean[1001];
	static int N, M, s;
	
	static void DFS(int v)
	{
		visit[v] = true;
		System.out.print(v + " ");
		for(int i = 1; i <= N; i++)
		{
			if(G[v][i] != 0 && visit[i] == false)
				DFS(i);
		}
	}
	static void BFS(int v)
	{
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(v);
		visit[v] = true;
		System.out.print(v + " ");
		
		while(!Q.isEmpty())
		{
			v = Q.poll();
			
			for(int i = 1; i <= N; i++)
			{
				if(G[v][i] != 0 && visit[i] == false)
				{
					Q.add(i);
					visit[i] = true;
					System.out.print(i + " ");
				}
			}
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();	// 정점수
		M = sc.nextInt();	// 간선수
		s = sc.nextInt(); // 시작 정점
		
		int u, v;
		for(int i = 0; i < M; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			
			G[u][v] = G[v][u] = 1;
		}
		
		DFS(s); System.out.println();
		BFS(s);
		
		sc.close();
	}
}
