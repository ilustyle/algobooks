
public class SubsetRecur {
	static int[] arr = {10, 20, 30};
	static int N = arr.length;
	static int[] bits = new int[N];	

	static void Subset(int k){
		if(k == N){
			for(int i = 0; i < N; i++)
				if(bits[i] == 1) System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		bits[k] = 1; Subset(k + 1);	// k번째 요소 포함
		bits[k] = 0; Subset(k + 1);	// k번째 요소 미포함
	}
	public static void main(String[] args) {		
		Subset(0);
	}
}
