
public class Perm1 {
	static int[] arr = {10, 20, 30, 40};	
	static int N = arr.length;
	static int[] order = new int[N];
	static int cnt;
	static void processSolution() {
		System.out.printf("%2d> ", ++cnt);
		for(int i = 0; i < N; i++)
			System.out.print(arr[order[i]] + " ");
		System.out.println();
	}
	static void perm(int k) {
		if(k == N) {
			processSolution();
			return;
		}
		// 가능한 선택지 찾기
		boolean[] used = new boolean[N];
		for(int i = 0; i < k; i++) 
			used[order[i]] = true;
		
		for(int i = 0; i < N; i++) {
			if(used[i]) continue;
			order[k] = i;
			perm(k + 1);
		}
	}
	
	public static void main(String[] args) {
	
		perm(0);

	}

}
