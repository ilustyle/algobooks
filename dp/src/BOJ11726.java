import java.util.Scanner;

public class BOJ11726 {
    static int[] memo;
    static int tiling_iter(int n)
    {
        int[] memo = new int[n + 1];
        
        memo[1] = 1; 
        if(n >= 2) memo[2] = 2;
        
        for(int i = 3; i <= n; i++)
            memo[i] = (memo[i - 1] + memo[i - 2]) % 10007;
        
        return memo[n];
    }
    static int tiling(int n)
    {
        if(memo[n] != 0) return memo[n];
        if(n <= 2) return memo[n] = n;
        return memo[n] = (tiling(n - 2) + tiling(n - 1)) % 10007;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new int[n + 1];
        //System.out.println(tiling(n));
        System.out.println(tiling_iter(n));
        sc.close();
    }
}
