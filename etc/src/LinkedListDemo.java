import java.util.*;

public class LinkedListDemo {
	
	public static void main(String args[]) 
	{
		int[] arr = new int[]{1, 3, 4, 2, 5};		
		
		List<Integer> list = new LinkedList<Integer>();

		for(int val: arr)
			list.add(val);
		
		Collections.sort(list);
		
		System.out.println(list);
		
		System.out.println(list.subList(1, 4)); // [1, 4) --> [1, 3] 
	}
}
