import java.util.*;

public class MergeSortDemo {	
	public static List<Integer> mergesort(List<Integer> list)
	{
		if(list.size() <= 1) return list;
		
		int size = list.size()/2;
		
		List<Integer> left = mergesort(new LinkedList<Integer>(list.subList(0, size)));
		List<Integer> right = mergesort(new LinkedList<Integer>(list.subList(size, list.size())));
		
		return merge(left, right);		
	}
	static List<Integer> merge(List<Integer> left, List<Integer> right)
	{
		List<Integer> list = new LinkedList<Integer>();
		
		while(!left.isEmpty() && !right.isEmpty())
			if(left.get(0) < right.get(0))
				list.add(left.remove(0));
			else
				list.add(right.remove(0));
		
		if(!left.isEmpty()) list.addAll(left);
		else list.addAll(right);
		
		return list;
	}
	public static void main(String[] args) {
		
		
		List<Integer> list = new LinkedList<Integer>();
		Random random = new Random();
		for(int i = 0; i < 20; i++)
			list.add(random.nextInt(100));
		System.out.println(list);
		
		// 퀵정렬
		list = mergesort(list);
		
		System.out.println(list);
	}
}