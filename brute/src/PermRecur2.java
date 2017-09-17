
public class PermRecur2 {
	static int[] arr = {10, 20, 30};
	static int N = arr.length;
	static int[] order = new int[N];		// 요소들의 순서	
	
	static void perm(int k, int used){		// used: 이미 선택된 요소들
		if(k == N){
			for(int i = 0; i < N; i++)
				System.out.print(arr[order[i]] + " ");
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++){
			if((used & (1 << i)) != 0) continue;
			
			order[k] = i;
			perm(k + 1, used | (1 << i));			
		}			
	}
	public static void main(String[] args) {		
		perm(0, 0);
	}
}
