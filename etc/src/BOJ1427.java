// 소트인사이드 https://www.acmicpc.net/problem/1427
import java.util.*;

public class BOJ1427 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int[] cnt = new int[10];
		
		for(int i = 0; i < str.length(); i++)
		{
			cnt[str.charAt(i) - '0']++;
		}
		
		for(int i = 9; i >= 0; i--)
			for(int j = 0; j < cnt[i]; j++)
				System.out.print(i);
		
		sc.close();
	}
	
}
