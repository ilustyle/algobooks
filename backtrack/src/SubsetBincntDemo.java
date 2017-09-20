package Day03;

public class SubsetDemo {
	static char[] str = new char[]{'A', 'B', 'C', 'D'};
	static boolean[] bits = new boolean[str.length];	
	static int cnt = 0;
	
	
	// binary counting 으로 생성하기
	public static void subset(int N)
	{
		for(int i = 0; i < (1 << N); i++)
		{
			System.out.printf("%3d ", ++cnt);
			for(int bit = 0; bit < N; bit++)
			{
				if((i & (1 << bit)) != 0) System.out.print(1);
				else System.out.print(0);
			}
			System.out.print("|");
			for(int bit = 0; bit < N; bit++)
			{
				if((i & (1 << bit)) != 0) 
					System.out.print(str[bit] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		subset(4);
	}

}
