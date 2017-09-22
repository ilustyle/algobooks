import java.util.Scanner;

public class BOJ10868 {
	static int[] tree;
	static int N, M, base, last;
	
	
	static int query(int a, int b){
		
		int min = 0x7fffffff;
		a = base + a - 1;
		b = base + b - 1;
		
		while(a < b){
			
			if((a & 1) != 0) { min = Math.min(min, tree[a]); a++;}
			if((b & 1) == 0) { min = Math.min(min, tree[b]); b--;}
			
			a >>= 1; b >>= 1;
		}
		if(a == b)  min = Math.min(min, tree[a]);
		return min;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();		
		
		base = 1;
		while(base < N)
			base <<= 1;
		
		tree = new int[base * 2 + 1];
		last = base + N - 1;
		for(int i = base; i < base + N; i++)
			tree[i] = sc.nextInt();
		for(int i = base + N; i < base + base; i++)
			tree[i] = 0x7fffffff;
		
		for(int i = base - 1; i != 0; i--)
		{
			tree[i] =  Math.min(tree[i << 1], tree[(i << 1) + 1]);
		}
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println(query(a, b));
		}
		sc.close();
	}
}
