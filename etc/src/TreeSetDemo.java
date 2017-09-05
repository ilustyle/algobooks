import java.util.TreeSet;

public class TreeSetDemo {
	static int[] keys = {15, 23, 6, 82, 36, 47, 5, 19};
	
	public static void main(String[] args) {

		System.out.println("TreeSet Demo........");

		TreeSet<Integer> bst = new TreeSet<Integer>();
		for(int key: keys)
		{
			bst.add(key);
		}

		System.out.println(bst);
		System.out.println(bst.contains(47));
		bst.remove(47);
		System.out.println(bst.contains(47));
		System.out.println(bst);
		bst.remove(19);
		System.out.println(bst);
	}
}
