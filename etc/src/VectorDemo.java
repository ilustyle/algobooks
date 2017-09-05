import java.util.*;

public class VectorDemo {
	public static void main(String args[]) 
	{
		int[] arr = new int[]{1, 2, 3, 4, 5};		
		
		Vector<Integer> v = new Vector<Integer>();
		
		// Stack으로 사용
		for(int val: arr) 
			v.add(val);
		
		while(!v.isEmpty())
		{
			System.out.println(v.lastElement());
			v.remove(v.size() - 1);
		}
		
		// Queue로 사용
		for(int val: arr)
			v.add(val);
		
		while(!v.isEmpty())
		{
			System.out.println(v.firstElement());
			v.remove(0);
		}
		
	}
}
