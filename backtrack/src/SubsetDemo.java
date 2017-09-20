package Day03;

public class SubsetDemo {
	static char[] str = new char[]{'A', 'B', 'C', 'D'};
	static boolean[] bits = new boolean[str.length];	
	static int cnt = 0;
	
	// 재귀 
	public static void subset(int k, int n)
	{
		if(k == n)
		{
			System.out.printf("%3d> ", ++cnt);			
			for(int i = 0; i < k; i++)
				if(bits[i]) 
					System.out.printf("%c ", str[i]);
			System.out.println();
			return;
		}
		bits[k] = true; subset(k + 1, n);
		bits[k] = false; subset(k + 1, n);
		
	}	
	// 반복 
	public static void subset_iter()
	{
		int[] bits = new int[4];
		for(int i = 0; i < 2; i++)
		{
			bits[0] = i;
			for(int j = 0; j < 2; j++)
			{
				bits[1] = j;
				for(int k = 0; k < 2; k++)
				{
					bits[2] = k;
					for(int l = 0; l < 2; l++)
					{
						bits[3] = l;
						System.out.println(bits[0]+" "+bits[1]+" "+ bits[2]+" "+ bits[3]);
					}
				}
			}			
		}
	}
	public static void main(String[] args) {
		//subset(0, 4);
		subset_iter();
	}

}
