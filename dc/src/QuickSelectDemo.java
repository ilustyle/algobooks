import java.io.FileInputStream;
import java.util.Scanner;

public class QuickSelectDemo {
	static int N;
	static int[] arr = new int[10000];
	public static void main(String[] args)
	{
		int kth = 5735;
		readInput("quickselect.in");
		System.out.printf("%d-th = %d\n", kth, quickSelect(kth - 1, 0, N - 1));
	}
	public static int quickSelect(int kth, int lo, int hi)
	{
		int i, j, tmp;
		
		do{
			i = lo; j = hi;
			while(i < j)
			{
				while(i <= hi && arr[lo] >= arr[i]) i++;
				while( arr[lo] < arr[j]) j--;
				if(i < j)
				{
					tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
				}		
			}
			tmp = arr[j]; arr[j] = arr[lo]; arr[lo] = tmp;
			
			if(j < kth) lo = j + 1;
			else hi = j - 1;
		}while(kth != j);
		return arr[kth];
	}
	public static void readInput(String file)
	{
		Scanner sc;
		
		try{
			if(file == null) sc = new Scanner(System.in);
			else sc = new Scanner(new FileInputStream(file));
			
			N = sc.nextInt();
	
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
							
			sc.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
