
public class CombIter {
	static int[] arr = {10, 20, 30};	
	static int N = arr.length;
	static int[] pick = new int[N]; // ªÃ¿∫ ø‰º“µÈ¿« ¿Œµ¶Ω∫
	
	static void Comb(int k, int r, int start){
		if(k == r){
			for(int i = 0; i < r; i++)
				System.out.printf(arr[pick[i]] + " ");
			System.out.println();
			return;
		}
		for(int i = start; i < N; i++)
		{
			pick[k] = i;
			comb(k + 1, r, i + 1);
		}
	}
	public static void main(String[] args) {		
		Comb(0, 2, 0);
	}
}
