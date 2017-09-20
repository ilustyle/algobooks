//중복 조합
public class comb3 {
	static int[] arr = {10, 20, 30, 40, 50};	
	static int N = arr.length;	
	static int R = 3;
	static int[] order = new int[N];
	static int[] picked = new int[R];
	static int cnt;
	// n개에서 r개를 선택하기, k: 선택된 요소수, 
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
			comb(k + 1, i); // 이전에 선택한 요소부터 다시 선택하도록 한다.
		
		}
	}
	public static void main(String[] args) {
		comb(0, 0);

	}

}