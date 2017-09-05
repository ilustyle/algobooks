public class SetDemo {

	public static void printBits(String str, int set)
	{
		for(int i = str.length() - 1; i >= 0; i--)
		{
			if( (set & (1 << i)) != 0) 
				System.out.print(str.charAt(i) + " ");
		}
		System.out.println();
	}	
	
	public static void main(String[] args) {
		
		String str = new String("ABCDEFGH");				
		int U = 0xff;		
		System.out.print("전체집합> "); printBits(str, U);
		
		int A = 0x2D, B = 0x65;
		
		System.out.print("A  집합> "); printBits(str, A);		
		System.out.print("B  집합> "); printBits(str, B);
		System.out.print("A 여집합> "); printBits(str, ~A);
		System.out.print("A|B합집합> "); printBits(str, A|B);
		System.out.print("A&B교집합> "); printBits(str, A&B);
		System.out.print("A-B차집합> "); printBits(str, A & ~B);
	}

}
