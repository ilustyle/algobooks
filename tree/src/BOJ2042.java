// 구간합 구하기1 https://www.acmicpc.net/problem/2042

import java.util.*;

public class Main {
	static long[] arr = new long[1000010];
	static long[] st = new long[1 << 21 + 1];
	static long[] lt = new long[1 << 21 + 1];;
	static int N, M, K;
	public static long buildTree(int id, int l, int r)
	{
		if(l == r)
		{
			return st[id] = arr[l];
		}
		int m = (l + r) / 2;
		
		return st[id] = buildTree(id * 2, l, m) + buildTree(id * 2 + 1, m + 1, r);
	}

	public static long query(int id, int l, int r, int i, int j)
	{
		if(r < i || j < l) return 0;
		
		if(i <= l && r <= j)  return st[id];
		
		int m = (l + r) / 2;
		return query(id * 2, l, m, i, j) + query(id * 2 + 1, m + 1, r, i, j);
	}
	public static void update(int id, int l, int r, int p, int v)
	{
		if(r < p || p < l) return;
		
		st[id] += v;
		if(l != r)
		{
				int m = (l + r) / 2;		
				update(id * 2, l, m, p, v);
				update(id * 2 + 1, m + 1, r, p, v);
		}
	}	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();		
		M = M + K;
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		buildTree(1, 0, N - 1);		
		int a, b, c;
		for(int i = 0; i < M; i++)
		{
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if(a == 1) 
			{
				b--;
				update(1, 0, N - 1, b, (int)(c - arr[b]));
				arr[b] = c;
			}else{
				System.out.println(query(1, 0, N - 1, b - 1, c - 1));
			}
		}
		sc.close();
	}
}
