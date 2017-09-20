// 중복 순열 생성하기
public class Perm4 {
	static int[] arr = {10, 20, 30};	
	static int N = arr.length;
	static int[] order = new int[N];
	static int cnt;
	
	public static void perm(int k)
	{
		if(k == N)	
		{
			System.out.printf("%2d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(arr[order[i]] + " ");
			System.out.println();
			return;
		}
		for(int i = 0; i < N; i++){
			order[k] = i;
			perm(k + 1);			
		}
	}
	public static void main(String[] args) {	
		perm(0);
	}
}
