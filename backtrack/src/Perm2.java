// 1부터 N까지 순열
public class Perm2 {
	static int[] arr = {0, 10, 20, 30, 40};	
	static int N = arr.length;
	static int[] order = new int[N];
	static int cnt;
	static void processSolution() {
		System.out.printf("%2d> ", ++cnt);
		for(int i = 1; i < N; i++)
			System.out.print(arr[order[i]] + " ");
		System.out.println();
	}
	static void perm(int k) {
		if(k == N) {
			processSolution();
			return;
		}		
		boolean[] used = new boolean[N];
		for(int i = 1; i < k; i++) 
			used[order[i]] = true;
		
		for(int i = 1; i < N; i++) {
			if(used[i]) continue;
			order[k] = i;
			perm(k + 1);
		}
	}
	
	public static void main(String[] args) {	
		perm(1);

	}
}
