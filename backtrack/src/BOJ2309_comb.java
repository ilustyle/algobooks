// 일곱난쟁이 https://www.acmicpc.net/problem/2309
// 조합
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2309_comb {
static ArrayList<Integer> arr = new ArrayList<Integer>();
    static int n = 9, r = 7;
    static int[] choices = new int[r];

    static boolean comb(int k, int start, int sum)
    {
        if(sum > 100) return false;
        if(k == r)
        {
            if(sum == 100){
                for(int i = 0; i < r; i++)					
                    System.out.println(choices[i]);
                return true;
            }else return false;			
        }
        
        for(int i = start; i < n; i++)
        {
            choices[k] = arr.get(i);
            if(comb(k + 1, i + 1, sum + choices[k])) return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0; i < n; i++)
            arr.add(sc.nextInt());
        
        Collections.sort(arr);
        
        comb(0, 0, 0);
        
        sc.close();
    }	
}

