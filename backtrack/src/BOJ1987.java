// 알파벳
import java.util.Scanner;

public class Main {

	static String[] board;
	static boolean[] visit = new boolean[128];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int r, c;
	static int max = 0;
	static void move(int x, int y, int cnt)
	{	
		visit[board[x].charAt(y)] = true;
		if(max < cnt) max = cnt;
		for(int i = 0; i < 4; i++)
		{
			int tx = x + dx[i];
			int ty = y + dy[i];
			if(tx < 0 || tx == r || ty < 0 || ty == c) continue;
			if(visit[board[tx].charAt(ty)]) continue;
			
			move(tx, ty, cnt + 1);
		}
		visit[board[x].charAt(y)] = false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		board = new String[r];
		for(int i = 0; i < r; i++)
			board[i] = sc.next();
		move(0, 0, 1);
		System.out.println(max);
		sc.close();
	}
}
