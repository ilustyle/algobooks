public class QuickHoare {
	
	static int[] arr = new int[]{23, 45, 2, 5, 88, 12, 7, 49, 45, 16};
	static int N = arr.length;
	
	static void swap(int i, int j){
		int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
	}		
	
	static void Quick(int lo, int hi)
	{
		if(lo < hi){
			
			int i = lo, j = hi;
			
			while(i < j){				
				while(i <= hi && arr[i] <= arr[lo]) i++;
				while(arr[j] > arr[lo]) j--;
				
				if(i >= j) break;
				
				swap(i, j);
			}
			swap(lo, j);
			Quick(lo, j - 1);
			Quick(j + 1, hi);
		}
	}
	public static void main(String[] args) {
		Quick(0, N - 1);
		for(int val : arr)
			System.out.print(val + " ");
	}	
}
