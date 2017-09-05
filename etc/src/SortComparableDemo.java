
import java.util.Arrays;
import java.util.Collections;


public class SortComparableDemo {
	static class Node implements Comparable<Node> {
		String name;
		int id;
		Node(String _name, int _id)	
		{
			name = _name; id = _id;
		}
		public String toString()
		{
			return "(" + name + ", " + id + ")";
		}
		
		public int compareTo(Node arg) {
			return name.compareTo(arg.name);	
			//return id - arg.id;		
		}
	}

	public static void main(String[] args)
	{
		Node[] nodes = new Node[5];
		nodes[0] = new Node("신동엽", 3);
		nodes[1] = new Node("이수근", 1);
		nodes[2] = new Node("유재석", 5);
		nodes[3] = new Node("강호동", 4);
		nodes[4] = new Node("김구라", 2);
		
		// 오름차순 정렬
		Arrays.sort(nodes);		
		for(Node node: nodes)
			System.out.println(node);;
		
		System.out.println("----------------------------");
			 
		// 내림차순 정렬
		Arrays.sort(nodes, Collections.reverseOrder());
		for(Node node: nodes)
			System.out.println(node);
	}
}
