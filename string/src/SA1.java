import java.util.*;

public class SA1 
{
	static int N;	// text의 길이 저장
	static char[] text;
	static int[] SA;
	static int[] LCP;
	
	public static int StrCmp(int s1, int s2)
	{
		
		int i = 0;
		while(text[s1 + i] != '$')
		{
			if(text[s1 + i] != text[s2 + i]) break;
			i++;
		}		
		return text[s1 + i] - text[s2 + i];
	}
	public static void QuickSort(int lo, int hi)
	{
		if(lo < hi)
		{
			int i = lo,  j = hi;
			while(i < j)
			{
				while(i <= hi && StrCmp(SA[lo], SA[i]) >= 0) i++;
				while(StrCmp(SA[lo], SA[j]) < 0) j--;
				if(i < j)
				{
					int tmp = SA[i]; SA[i] = SA[j]; SA[j] = tmp;
				}
			}
			int tmp = SA[lo]; SA[lo] = SA[j]; SA[j] = tmp;
			
			QuickSort(lo, j - 1);
			QuickSort(j + 1, hi);
		}
	}
	public static int ComputeLCP(int s1, int s2)
	{
		
		int i = 0;
		while(text[s1 + i] != '$')
		{
			if(text[s1 + i] != text[s2 + i]) break;
			i++;
		}
		return i;
	}
	public static void ConstructSuffixArray()
	{
		SA = new int[N + 1];
		LCP = new int[N + 1];
		for(int i = 0; i < N; i++)
			SA[i] = i;
		
		QuickSort(0, N - 1);
		
		LCP[0] = 0;		
		for(int i = 1; i < N; i++)
			LCP[i] = ComputeLCP(SA[i-1], SA[i]);
			
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();	
		N = str.length();
		str += "$";
		text = str.toCharArray();
		
		ConstructSuffixArray();
		
		System.out.printf("SA\tLCP\tSuffix\n");
		for(int i = 0; i < N; i++)
		{
			System.out.printf("%-3d\t%-3d\t%s\n", SA[i], LCP[i], str.substring(SA[i]));
		}
		
		sc.close();		
	}
}
