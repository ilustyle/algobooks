// 단어정렬 https://www.acmicpc.net/problem/1181

import java.util.*;

public class BOJ1181 {
	static String[] strs;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Vector<String> strs = new Vector<String>();		 
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < N; i++)
		{
			String key = sc.next();
			if(map.containsKey(key)) continue;			
			map.put(key, i);
			strs.add(key);
		}
		
		Comparator<String> compareString = new Comparator<String>(){
			
			public int compare(String a, String b)
			{
				if(a.length() != b.length())
					return a.length() - b.length();
				else
					return a.compareTo(b);
			}
		};
		Collections.sort(strs, compareString);
		
		for(String s : strs)
			System.out.println(s);
		sc.close();
	}
}
