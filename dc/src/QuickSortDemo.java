import java.util.Random;

public class QuickSortDemo {

	public static void quickSort(int arr[], int lo, int hi)
	{
		if(lo < hi)
		{
			int i = lo,  j = hi;
			while(i < j)
			{
				while(i <= hi && arr[lo] >= arr[i]) i++;
				while(arr[lo] < arr[j]) j--;
				if(i < j)
				{
					int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
				}
			}
			int tmp = arr[lo]; arr[lo] = arr[j]; arr[j] = tmp;
			
			quickSort(arr, lo, j - 1);
			quickSort(arr, j + 1, hi);
		}
	}
	public static void main(String[] args) {
		int N = 15;
		Random random = new Random();
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = random.nextInt(100) + 1;
		
		for(int val: arr) System.out.print(val + " ");
		System.out.println();
		
		// 퀵정렬
		quickSort(arr, 0, N - 1);
		
		for(int val: arr) System.out.print(val + " ");
		System.out.println();
	}

}
