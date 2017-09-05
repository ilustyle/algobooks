// 입국 심사
import java.util.Scanner;

public class BOJ3079 {	
	static int MAXN = 100000;
	static int[] T = new int[MAXN];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();

		long max = 0;
		
		for (int i = 0; i < N; i++)
		{
			T[i] = sc.nextInt();
			if (max < T[i]) max = T[i];
		}

		long lo = 1, hi = max * M, mid;

		while (lo < hi)
		{
			mid = (lo + hi) >> 1;

			long tmp = 0;

			for (int i = 0; i < N; i++)
			{
				tmp = tmp + (mid / T[i]);
			}
			if (tmp < M) lo = mid + 1;
			else hi = mid;
		}
		System.out.println(lo);
		sc.close();
	}
}
