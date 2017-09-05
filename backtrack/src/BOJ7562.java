// 나이트의 이동
import java.util.*;

public class Main {
	static int T, size;
	static int curx, cury, endx, endy;
	static int[] dx = new int[]{ 2, 2, 1, -1, -2, -2, -1, 1 };
	static int[] dy = new int[]{ -1, 1, 2, 2, 1, -1, -2, -2 };
	
	public static class Pos {
		int x, y, cnt, d;
		Pos(int _x, int _y, int _cnt){ 
			x = _x; y = _y; cnt = _cnt;
			d = Math.abs(x - endx) + Math.abs(y - endy);
		}		
		public String toString()
		{
			return "(" + x + "," + y + ")";
		}
	}

	static Queue<Pos> Q = new LinkedList<Pos>();
	
	public static int bfs()
	{
		boolean[][] visited = new boolean[size + 1][size + 1];
		Q.clear();
		Q.add(new Pos(curx, cury, 0));
		visited[curx][cury] = true;
		
		while(!Q.isEmpty())
		{
			Pos pos = Q.remove();		
			
			if(pos.x == endx && pos.y == endy) return pos.cnt;
			
			for(int i = 0; i < 8; i++)
			{
				int tmpx = pos.x + dx[i]; 
				int tmpy = pos.y + dy[i];
				if(tmpx < 0 || tmpx >= size || tmpy < 0 || tmpy >= size) continue;
				if(visited[tmpx][tmpy]) continue;
				
				Q.add(new Pos(tmpx, tmpy, pos.cnt + 1));
				visited[tmpx][tmpy] = true;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		while(T-- > 0)
		{
			size = sc.nextInt();
			curx = sc.nextInt(); cury = sc.nextInt();
			endx = sc.nextInt(); endy = sc.nextInt();
			
			System.out.println(bfs());
		}
		
		sc.close();
	}

}
