// 전화번호 목록 https://www.acmicpc.net/problem/5052

import java.util.*;

public class BOJ5052 {

	static String[] S = new String[10000];	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);		
		
		int T = sc.nextInt();
		while(T-- > 0)
		{
			int N = sc.nextInt();
			
			for(int i = 0; i < N; i++)			
				S[i] = sc.next();				
			
			// 길이순으로 정렬
			Arrays.sort(S, 0, N);
			
			boolean ans = true;
			for(int i = 0; i < N - 1; i++)
			{
				for(int j = i + 1; j < N; j++)
				{
					if(S[i].length() < S[j].length())
					{
						if(S[j].startsWith(S[i]))
						{
							ans = false; i = N; break;
						}
					}
				}
			}
			if(ans) System.out.println("YES");
			else System.out.println("NO");
		}
		sc.close();
	}
}
