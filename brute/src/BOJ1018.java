
// 체스판 다시 칠하기 https://www.acmicpc.net/problem/1018
// bit 연산 활용
import java.util.*;

public class BOJ1018 
{
	// WBWB WBWB ,  BWBW BWBW
	// 0101 0101    1010 1010
	// 0x55         0xAA
	
	static void print_bit(long bits, int n)
	{
		int cnt = 0;
		for (int i = n - 1; i >= 0; i--)
		{
			if ((bits & (1 << i)) != 0) System.out.printf("1");
			else System.out.printf("0");
			if ((++cnt % 4) == 0) System.out.printf(" ");
		}
		System.out.printf("\n");
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int[] line = new int[2];
		line[0] = 0x55; line[1] = 0xAA;
		long[] board = new long[50];

		int M = sc.nextInt();
		int N = sc.nextInt();
		

		for (int i = 0; i < M; i++)
		{
			String str = sc.next();
			for (int j = 0; j < N; j++)
			{
				board[i] <<= 1;
				if (str.charAt(j) == 'B')
					board[i] |= 1;
			}
		}
	
		long mask = 0xff;
		int wcnt, bcnt, ans = 0xffffff;
		for (int i = 0; i <= M - 8; i++)
		{
			for (int j = 0; j <= N - 8; j++)
			{
				wcnt = bcnt = 0;
				for (int row = 0; row < 8; row++)
				{
					long t = (board[i + row] >> j) & mask;
					long tw, tb;
					if ((row & 1) != 0){
						tw = t ^ 0x55;
						tb = t ^ 0xAA;
					}
					else{
						tw = t ^ 0xAA;
						tb = t ^ 0x55;
					}

					for (int k = 0; k < 8; k++)
					{
						if ((tw & (1 << k)) != 0) wcnt++;
						if ((tb & (1 << k)) != 0) bcnt++;
					}
				}
				ans = Math.min(ans, wcnt);
				ans = Math.min(ans, bcnt);
			}
		}
		System.out.println( ans);
		
	}
}
