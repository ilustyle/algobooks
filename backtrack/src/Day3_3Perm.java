import java.util.Scanner;

public class Day3_3Perm0 {
	static int N = 11;
	static int min;
	static int sx, sy, ex, ey;
	static int[] x = new int[N];
	static int[] y = new int[N];
	static int[] order = new int[N];
	
	static int calcDist(int x1, int y1, int x2, int y2){
		int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		return dist;
	}
	
	static void findPath(int k, int dist, int visit)
	{
		if (dist >= min) return;
		
		if (k == N){ // 모든 선택이 끝남.
			
			dist += calcDist(x[order[k-1]], y[order[k-1]], ex, ey);
			
			if (dist < min) 
				min = dist;			
			
		}else{
			
			for (int i = 0; i < N; i++){
				
				if ((visit & (1 << i)) != 0) continue;				
				order[k] = i;
				int add;
				if(k == 0) add = calcDist(sx, sy, x[i], y[i]);
				else add = calcDist(x[order[k-1]], y[order[k-1]], x[i], y[i]);
				
				findPath(k + 1, dist + add, visit | (1 << i));
			}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			sx = sc.nextInt(); sy = sc.nextInt(); 
			ex = sc.nextInt(); ey = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			
			min = 0xffffff;
			findPath(0, 0, 0);
			System.out.println(min);		
		}
		sc.close();
	}
}
