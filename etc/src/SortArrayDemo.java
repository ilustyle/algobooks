import java.util.*;

public class SortArrayDemo {
	public static void main(String[] args)
	{
		int[] arr = new int[]{10, 7, 5, 9, 3, 2, 15, 6, 1, 12};
		Arrays.sort(arr);
		
		for(int val: arr)
			System.out.println(val);
	
		System.out.println("----------------------------");
		
		List<String> names = new ArrayList<String>();		 
		names.add("신동엽");		names.add("이수근");
		names.add("유재석");		names.add("강호동");
		names.add("김구라");		
		
		Collections.sort(names);
		
		for(String name: names)
			System.out.println(name);
		
		System.out.println("----------------------------");
		
		Collections.sort(names, Collections.reverseOrder());
		
		for(String name: names)
			System.out.println(name);
	}
}
