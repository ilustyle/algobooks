
//	덩치 - https://www.acmicpc.net/problem/7568

import java.util.*;

public class BOJ7568 {

	static int[] w = new int[51];
	static int[] h = new int[51];
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++)
		{
			w[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++)
		{
			int cnt = 0;
			for (int j = 0; j < N; j++)
			{
				if (w[i] < w[j] && h[i] < h[j])
					cnt++;
			}
			System.out.printf("%d ", cnt + 1);
		}	
		sc.close();
	}
}
