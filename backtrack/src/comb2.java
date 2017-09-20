// 재귀적 정의에 의한 생성
public class comb2 {
	static int[] arr = {10, 20, 30, 40, 50};	
	static int N = arr.length;	
	static int R = 3;
	static int[] order = new int[N];
	static int[] picked = new int[R];
	static int cnt;
	// n개에서 r개를 선택하기, k: 선택된 요소수, 
	public static void comb(int n, int r)
	{
		if(r == 0){
			System.out.printf("%2d> ", ++cnt);
			for(int i = 0; i < R; i++)
				System.out.print(picked[i] + " ");
			System.out.print('\n');
			return;
		}
		if(n < r) return;
		
		picked[r - 1] = arr[n - 1];
		comb(n - 1, r - 1);
		comb(n - 1, r);
	}
	public static void main(String[] args) {
		comb(N, R);

	}
}
