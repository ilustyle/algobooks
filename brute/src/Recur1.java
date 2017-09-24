public class Recur1 {
	static int M = 3, N = 2, cnt = 0;
	static int[] is = new int[N]; // 인덱스 저장
	
	static void recur(int k){
		if(k == N){	
			System.out.printf("%d %d\n", is[0], is[1]);			
		}
		
		for(int i = 0; i < M; i++)
		{
			is[k] = i;
			recur(k + 1);
		}
	}
	public static void main(String[] args) {		
		recur(0);		
	}
}
