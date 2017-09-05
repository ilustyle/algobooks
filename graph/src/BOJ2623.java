// 음악 프로그램 https://www.acmicpc.net/problem/2623
import java.util.*;

public class Main{
	static int MAXN = 1000;
		
	static int[][] G = new int[MAXN + 1][MAXN + 1];
	static int[] idx = new int[MAXN + 1];
	static int[] indeg = new int[MAXN + 1];
	static Stack<Integer> stack = new Stack<Integer>();
	static int[] discovered = new int[MAXN + 1];
	static int[] finished = new int[MAXN + 1];	
	static boolean isCycle = false;
	static void dfs(int v)
	{
		discovered[v] = 1;
		for (int i = 0; i < idx[v]; i++)
		{
			if (discovered[G[v][i]] == 0)
			{
				dfs(G[v][i]);
			}
			else if (finished[G[v][i]] == 0)
				isCycle = true;
		}
		finished[v] = 1;
		stack.push(v);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int size, from, to;
		for (int i = 0; i < M; i++)
		{
			size = sc.nextInt();
			from = sc.nextInt();
			
			for (int j = 1; j < size; j++)
			{
				to = sc.nextInt();
				G[from][idx[from]++] = to;
				indeg[to]++;
				from = to;
			}
		}
		
		for (int i = 1; i <= N; i++)
		{
			if (indeg[i] == 0)
				dfs(i);
		}
		if (isCycle) System.out.printf("0\n");
		else
			while (!stack.isEmpty())
				System.out.printf("%d\n", stack.pop());
		sc.close();
	}
}