public class Iter1 {
	static int M = 3, cnt = 0;	
	public static void main(String[] args) {

		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < M; j++)
			{
				System.out.printf("%d %d\n", i, j);
			}
		}
	}
}
/*
출력 결과
0 0
0 1
0 2
1 0
1 1
1 2
2 0
2 1
2 2
*/
