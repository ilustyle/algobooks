
public class BinaryCnt {
	static int[] arr = {10, 20, 30};
	static int N = arr.length;
		
	// 바이너티 카운팅으로 부분 집합 생성하기
	static void Subset(){		
		for(int i = 0; i < (1 << N) ; i++){
			
			for(int j = 0; j < N; j++){		// 비트 표현 출력
				if((i & (1 << j)) != 0) System.out.print(1);
				else System.out.print(0);							
			}
			System.out.print(" > ");
			for(int j = 0; j < N; j++){
				if((i & (1 << j)) != 0) 
					System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {		
		Subset();
	}
}
