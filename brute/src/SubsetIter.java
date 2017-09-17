
public class SubsetIter {
	static int[] arr = {10, 20, 30};
	static int N = arr.length;
	static int[] bits = new int[N];	
	
	static void Subset(){		
		for(int i = 0; i < 2; i++){
			bits[0] = i;
			for(int j = 0; j < 2; j++){
				bits[1] = j;
				for(int k = 0; k < 2; k++){
					bits[2] = k;
					System.out.printf("%d%d%d > ", bits[0], bits[1], bits[2]);
					for(int x = 0; x < N; x++)
						if(bits[x] == 1) System.out.print(arr[x] + " ");
					System.out.println();
				}
			}
		}
	}
	public static void main(String[] args) {		
		Subset();
	}
}
