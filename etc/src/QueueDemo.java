import java.util.*;

public class QueueDemo {

	public static void main(String args[]) 
	{
		int[] arr = new int[]{1, 2, 3, 4, 5};		
		
		Queue<Integer> Q = new LinkedList<Integer>();

		for(int val: arr)
			Q.add(val);
		
		while(!Q.isEmpty())		 
			System.out.println(Q.poll());
	}
}
