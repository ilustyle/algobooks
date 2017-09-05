// 미로 탐색 DFS - https://www.acmicpc.net/problem/2178

import java.util.*;

public class BOJ2178 {	
	static int N, M;	// 행과 열의 크기
	static String[] MAP = new String[100];
	static int[][] D = new int[100][100];	
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	
	
	public static void dfs(int x, int y)
	{
		if(D[x][y] > D[N-1][M-1]) return;
		
		for (int k = 0; k < 4; k++){
			int tx = x + dx[k]; 
			int ty = y + dy[k];

			if (tx < 0 || tx >= N || ty < 0 || ty >= M) continue;
			
			if (MAP[tx].charAt(ty) == '1' && D[tx][ty] > D[x][y] + 1){
				D[tx][ty] = D[x][y] + 1;
				dfs(tx, ty);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i = 0; i < N; i++)
			MAP[i] = sc.next();
			
		for(int i = 0; i < N; i++)
		for(int j = 0; j < M; j++)
			D[i][j] = 0xffffff;
		D[0][0] = 1;
		
		dfs(0, 0);
		System.out.println(D[N-1][M-1]);
		
		sc.close();
	}

}
