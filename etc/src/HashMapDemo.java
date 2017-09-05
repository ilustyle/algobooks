import java.util.*;

public class HashMapDemo {
	public static void main(String[] args)
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("이수근", 1);
		map.put("유재석", 5);
		map.put("신동엽", 2);
		map.put("김구라", 3);
		map.put("강호동", 2);
		
		Set<String> strSet = map.keySet(); 
		for(String key: strSet)
			System.out.println(key);
		
		System.out.print("김구라의 value = ");
		System.out.println(map.get("김구라"));
		
		System.out.println("신동엽 삭제");
		System.out.println(map.remove("신동엽")); // 신동엽의 value 반환
		
		System.out.println(map.containsKey("신동엽"));
		
		System.out.print("강호동 삽입 = ");
		System.out.println(map.put("강호동", 8)); // Map에 저장된 key의 value 반환
		
	}
}
