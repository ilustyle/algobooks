
public class CombIter {
	static int[] arr = {10, 20, 30};	
	static int N = arr.length;	
	
	static void Comb(){
		
		for(int i = 0; i < N - 1; i++)
		{
			for(int j = 0; j < N; j++)
			{
				System.out.printf("%d %d\n", arr[i], arr[j]);
			}
		}
	}
	public static void main(String[] args) {		
		Comb();
	}
}
