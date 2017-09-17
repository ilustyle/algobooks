
public class PermIter {
	static int[] arr = {10, 20, 30};
	static int N = arr.length;
	
	static void Perm(){
		// 3개의 for문을 중첩
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(i == j) continue;
				for(int k = 0; k < N; k++)
				{
					if(k == i || k == j) continue;
					System.out.printf("%d %d %d\n", arr[i], arr[j], arr[k]);
				}
			}	
		}
			
	}
	public static void main(String[] args) {		
		Perm();
	}
}
