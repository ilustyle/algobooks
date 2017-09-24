public class DisjointSetSimple {
	static int[] p = null;	
	
	public static void make_set(int N)
	{
		p = new int[N + 1];
		
		for(int i = 1; i <= N; i++) // N개의 집합 생성
			p[i] = i;		
	}
	public static int find_set(int x)
	{
		if(x == p[x]) return x; 
		
		return find_set(p[x]);
	}
	public static void union(int x, int y)
	{
		p[find_set(y)] = find_set(x);
	}
	public static void main(String[] args) {		
		make_set(10);
		print_set(10);
		
		union(1, 3); 
		union(2, 10); 
		union(7, 5); 
		union(3, 7); 
		union(2, 8);
		
		System.out.printf("\nunion 연산의 결과>\n");		
		System.out.println("3의 집합 대표자 -->" + find_set(3));
		System.out.println("5의 집합 대표자 -->" + find_set(5));
		print_set(10);
		
	}
	public static void print_set(int N)
	{
		System.out.printf("p[] 배열>\n정점 ");
		for(int i = 1; i <= N; i++)
			System.out.printf("%2d ", i);
		System.out.printf("\n---------------------------------------\n부모 ");
		for(int i = 1; i <= N; i++)
			System.out.printf("%2d ", p[i]);
		System.out.println();
	}
}
