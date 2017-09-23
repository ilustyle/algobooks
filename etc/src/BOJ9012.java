// 괄호 https://www.acmicpc.net/problem/9012

import java.util.*;

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int tc = 0; tc < N; tc++)
		{
			String str = sc.next();
			Stack<Character> S = new Stack<Character>();
			
			boolean yes = true;
			for(int i = 0; i < str.length(); i++)
			{
				if(str.charAt(i) == '(')
					S.push('(');
				else{
					if(S.isEmpty()){ yes = false; break; }
					S.pop();
				}
			}
			if(!S.isEmpty()) yes = false;
			if(yes) System.out.println("YES");
			else System.out.println("NO");
		}
		
		sc.close();
		
	}
}