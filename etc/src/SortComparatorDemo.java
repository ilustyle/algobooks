
import java.util.Arrays;
import java.util.Comparator;

public class SortComparatorDemo {
	static class Node 
	{
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
	}
	
	public static void usingComparator()
	{
		Comparator<Node> compareNode = new Comparator<Node>(){
			
			public int compare(Node n1, Node n2)
			{
				return n2.name.compareTo(n1.name);	
				//return n2.id - n1.id;
			}
		};
		
		Node[] nodes = new Node[5];
		nodes[0] = new Node("신동엽", 3);
		nodes[1] = new Node("이수근", 1);
		nodes[2] = new Node("유재석", 5);
		nodes[3] = new Node("강호동", 4);
		nodes[4] = new Node("김구라", 2);
		
		// 오름 차순 정렬
		Arrays.sort(nodes, compareNode);		
		for(Node node: nodes)
			System.out.println(node);
		
		System.out.println("----------------------------");
	}
	
	public static void main(String[] args)
	{
		usingComparator();
	}
}
