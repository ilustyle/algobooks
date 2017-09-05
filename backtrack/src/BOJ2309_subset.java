// 일곱난쟁이 https://www.acmicpc.net/problem/2309

import java.util.*;

public class BOJ2309 {

	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	static int[] bits = new int[9];
	
	static boolean subset(int k, int sum, int cnt)
	{
		if(sum > 100) return false;
		if(cnt == 7 && sum == 100)
		{
			for(int i = 0; i < 9; i++)
				if(bits[i] == 1)
					System.out.println(arr.get(i));
			return true;
		}
		if(k == 9) return false;
		
		bits[k] = 1;
		if(subset(k + 1, sum + arr.get(k), cnt + 1))
			return true;
		bits[k] = 0;
		if(subset(k + 1, sum, cnt))
			return true;
		
		return false;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 9; i++)
			arr.add(sc.nextInt());
		
		Collections.sort(arr);
		
		subset(0, 0, 0);
		
		sc.close();
	}	
}
