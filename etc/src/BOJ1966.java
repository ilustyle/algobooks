// 프린터 큐 https://www.acmicpc.net/problem/1966

import java.util.*;

public class BOJ1966 {
	static int SIZE = 300;
	static class Item{
		int id, val;
		Item(int i, int v){ id = i; val = v;}
	};

	static Vector<Item> Q = new Vector<Item>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while (T-- > 0)
		{
			int N = sc.nextInt(); 
			int M = sc.nextInt();
			
			for (int i = 0; i < N; i++)
			{
				int val = sc.nextInt();
				Q.add(new Item(i, val));
			}
			int nth = 0;
			while (!Q.isEmpty())
			{
				Item t = Q.remove(0);
				
				int i;
				for (i = 0; i < Q.size(); i++)
				{
					if (t.val < Q.get(i).val) break;
				}
				if (i < Q.size())
				{
					Q.add(t);
				} else{
					++nth;
					if (t.id == M) break;
				}
			}
			System.out.printf("%d\n", nth);
			Q.clear();
		}
		sc.close();
	}
}
