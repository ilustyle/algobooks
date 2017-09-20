
public class comb1 {
	static int[] arr = {10, 20, 30, 40, 50};	
	static int N = arr.length;	
	static int R = 3;
	static int[] order = new int[N];
	static int[] picked = new int[R];
	static int cnt;
	// n개에서 r개를 선택하기, k: 선택된 요소수, start: 선택할 요소의 시작 인덱스
	public static void comb(int k, int start)
	{
		if(k == R){
			System.out.printf("%2d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(picked[i] + " ");
			System.out.print('\n');
			return;
		}
		for(int i = start; i < N; i++)
		{
			picked[k] = arr[i];
			comb(k + 1, i + 1); // 이전 선택 요소 다음 부터
		
		}
	}
	public static void main(String[] args) {
		comb(0, 0);

	}

}
