
public class RecursionDemo {
	static int cnt = 0;
	static int[] arr = new int[]{25, 6, 73, 62, 90, 24, 15, 38, 50, 54};
	
	public static void printHello(int k, int n)
	{
		if(k == n)
		{
			for(int i = 0; i < k; i++) System.out.printf("\t");				
			System.out.printf("%2d> (%d %d)\n", ++cnt, k, n);
			return;
		}else{
			for(int i = 0; i < k; i++) System.out.printf("\t");
			System.out.printf("%2d> (%d %d)\n", ++cnt, k, n);
			
			printHello(k + 1, n);
			printHello(k + 1, n);
		}

	}

	public static int recurFunc(int k, int n)
	{
		if(k == n) return 1;
		
		return recurFunc(k + 1, n) + recurFunc(k + 1, n);
	}

	public static void main(String[] args)
	{
		printHello(0, 3);
		
		System.out.println("반환값 = " + recurFunc(0, 3));
		
	}
}
