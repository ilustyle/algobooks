import java.util.*;

public class Day3_2 {

	static int N;		// 사람수
	static int M = 4;	// 방수	
	static int[][] G;	// 관계 정보
	static int[] person;	// 방번호 저장
	static int min;		// 최소 방수
	static int[] room = new int[M + 1];
	// 중복 순열로
	static boolean isPossible(int k, int n) // k번 사람에게 n번 방 배정이 가능한가?
	{
		for(int i = 0; i < k; i++) {
			if(person[i] == n && G[k][i] == 1)
				return false;
		}
		return true;
	}
	public static void solve(int k, int cnt)
	{
		if(cnt >= min) return;
		if(k == N){
			if(cnt < min) {
				min = cnt;			
				for(int i = 0; i < N; i++) System.out.printf("%d ", person[i]);
				System.out.println();
				for(int i = 0; i < M; i++) System.out.println("룸"+i+": " + room[i]);
			}
			return;
		}
		for(int i = 0; i < M; i++)
		{
			if(!isPossible(k, i)) continue;
			person[k] = i;
			
			int add = 0;
			if(room[i] == 0) add++;
			room[i]++;
			solve(k + 1, cnt + add);			
			room[i]--;
			
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		G = new int[N][N];
		person = new int[N];
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				G[i][j] = sc.nextInt();
		}
		
		min = 5;
		solve(0, 0);	
		System.out.println(min);
		sc.close();
	}
}
