
public class GetMaxDemo {

	static int cnt = 0;
	static int[] arr = new int[]{25, 6, 73, 62, 90, 24, 15, 38, 50, 54};
	
	// len: 배열의 크기
	public static int getMax(int[] arr, int len)
	{
		if(len == 1) return arr[0];
		int ret = getMax(arr, len - 1);
		return ret > arr[len - 1]? ret: arr[len - 1];
	}
	// lo: 시작 인덱스, hi: 끝 인덱스
	public static int getMax(int[] arr, int lo, int hi)
	{
		if(lo == hi) return arr[lo];
		int mid = (lo + hi) / 2;
		int left = getMax(arr, lo, mid);
		int right = getMax(arr, mid  +1, hi);
		return left > right? left: right;
	}
	public static void main(String[] args)
	{
		for(int val: arr)
			System.out.print(val + " ");		
		System.out.println();
		
		System.out.println("최대값 = " + getMax(arr, 10));
		System.out.println("최대값 = " + getMax(arr, 0, 9));
	}
}
