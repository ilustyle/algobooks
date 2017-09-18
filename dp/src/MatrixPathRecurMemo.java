/* 입력
4
6 7 12 5
5 3 11 18
7 17 3 3
8 10 14 9
*/

import java.util.Scanner;

public class MatrixPathRecurMemo {

	static int[][] MAT;
	static int[][] D;
	static int N;
	
	static int matrixPath(int i, int j)
	{
		if(i == 1 && j == 1) return D[1][1] = MAT[1][1];
		if(i == 1) return matrixPath(1, j - 1) + MAT[1][j]; 
		if(j == 1) return matrixPath(i - 1, 1) + MAT[i][1];
		
		int a = matrixPath(i, j - 1); 
		int b = matrixPath(i - 1, j);  
		a = a < b ? a : b; 
		return D[i][j] = a + MAT[i][j];
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		MAT = new int[N + 1][N + 1];
		D = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++)	// 1 ~ N
		for(int j = 1; j <= N; j++)
		{
			MAT[i][j] = sc.nextInt();			
			D[i][j] = -1;
		}

		System.out.printf("%2d\n", matrixPath(N, N));		
		sc.close();
	}
}
