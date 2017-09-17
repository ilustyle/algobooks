
public class PermRecur1 {
	static int[] arr = {10, 20, 30};
	static int N = arr.length;
	static int[] order = new int[N];		// 요소들의 인덱스
	static boolean[] used = new boolean[N];	// 이미 선택된 요소들
	
	static void perm(int k){
		if(k == N){
			for(int i = 0; i < N; i++)
				System.out.print(arr[order[i]] + " ");
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++){
			if(used[i]) continue;
			used[i] = true;
		
			order[k] = i;
			perm(k + 1);
			
			used[i] = false;
		}			
	}
	public static void main(String[] args) {		
		perm(0);
	}
}
