public class QuickLomuto {
	
	static int[] arr = new int[]{23, 45, 2, 5, 88, 12, 7, 49, 45, 16};
	static int N = arr.length;
	
	static void swap(int i, int j){
		int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
	}			
	static void Quick(int lo, int hi)	// Lomuto 분할 알고리즘 사용
	{
		if(lo < hi){
			
			int i = lo - 1, j;
			
			for(j = lo; j < hi; j++){
				if(arr[hi] > arr[j])
					swap(++i, j);
			}
			swap(++i, hi);
			Quick(lo, i - 1);
			Quick(i + 1, hi);
		}
	}
	public static void main(String[] args) {
		Quick(0, N - 1);
		for(int val : arr)
			System.out.print(val + " ");
	}	
}
