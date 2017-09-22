import java.util.Scanner;

public class BOJ2042 {	
	static long[] tree;
	static int N, M, K, base;
	
	static void update(int p, int v){		
		p = base + p - 1;
		long diff = v - tree[p];
		tree[p] = v;		
		p >>= 1;
		while(p > 0){
			tree[p] += diff;
			p >>= 1;
		}
	}
	static long query(int a, int b){
		
		long sum = 0;
		a = base + a - 1;
		b = base + b - 1;
		
		while(a < b){
			
			if((a & 1) != 0) { sum += tree[a]; a++;}
			if((b & 1) == 0) { sum += tree[b]; b--;}
			
			a >>= 1; b >>= 1;
		}
		if(a == b) sum += tree[a];
		return sum;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		base = 1;
		while(base < N)
			base <<= 1;
		
		tree = new long[base * 2 + 1];
		
		for(int i = base; i < base + N; i++)
			tree[i] = sc.nextInt();
		
		for(int i = base - 1; i != 0; i--)
			tree[i] = tree[i << 1] + tree[(i << 1) + 1];
		
		for(int i = 0; i < M + K; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a == 1) update(b, c);
			else
				System.out.println(query(b, c));
		}
		sc.close();
	}
}
