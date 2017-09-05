// 쿼드 트리
import java.util.*;
public class BOJ1992 {
	static String[] data;
	static int N;
	static void quadtree(int x, int y, int size)
	{
		if(size == 0){
			System.out.print(data[x].charAt(y));
			return;
		}
		boolean flag = true;
		for(int i = x; i < x + size; i++)
		for(int j = y; j < y + size; j++)
		{
			if(data[x].charAt(y) != data[i].charAt(j))
			{
				flag = false; i = x + size;
				break;
			}
		}
		if(flag)
			System.out.print(data[x].charAt(y));		
		else{
			System.out.print("(");
			size >>= 1;
			quadtree(x, y, size); 			// 좌상
			quadtree(x, y + size, size);	// 우상
			quadtree(x + size, y, size);	// 좌하			
			quadtree(x + size, y + size, size);// 우하
			System.out.print(")");
		}
	}
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		data = new String[N];
		
		for(int i = 0; i < N; i++)
			data[i] = sc.next();
		
		quadtree(0, 0, N);
		sc.close();
	}
}
