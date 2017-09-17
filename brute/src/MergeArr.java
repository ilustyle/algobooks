public class MergeArr {
	
	static int[] arr = new int[]{23, 45, 2, 5, 88, 12, 7, 49, 45, 16};
	static int N = arr.length;
	static int[] sorted =  new int[N]; 
	static void MergeSort(int l, int r){
		
		if(l == r) return;
		
		int mid = (l + r) / 2;
		
		MergeSort(l, mid);
		MergeSort(mid + 1, r);
		
		int i = l, j = mid + 1, k = l;
		while(i <= mid && j <= r)
		{
			if(arr[i] < arr[j]) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}
		if(i <= mid) 
			while(i <= mid) sorted[k++] = arr[i++];
		else
			while(j <= r) sorted[k++] = arr[j++];
		
		for(int idx = l; idx <= r; idx++)
			arr[idx] = sorted[idx];
	}
	public static void main(String[] args) {
		MergeSort(0, N - 1);
		for(int val : arr)
			System.out.print(val + " ");
	}	
}
