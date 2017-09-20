
public class perm3 {
	static int[] arr = {10, 20, 30, 40};	
	static int N = arr.length;
	static int cnt;
	public static void swap(int i, int j)
	{
		int t = arr[i]; arr[i] = arr[j]; 
		arr[j] = t;		
	}
	
	// 교환을 통한 생성
	public static void perm(int k)
	{
		if(k == N)	// N - 1
		{
			System.out.printf("%2d> ", ++cnt);
			for(int i = 0; i < k; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		for(int i = k; i < N; i++)
		{
			swap(k, i);
			perm(k + 1);
			swap(k, i);
		}
	}
	public static void main(String[] args) {	
		perm(0);
	}
}
