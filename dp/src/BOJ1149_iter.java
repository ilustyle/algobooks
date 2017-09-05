import java.util.*;

public class Main {
    static int[][] memo;
    static int N;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        memo = new int[N + 1][3];
        
        
        for(int i = 1; i <= N; i++)
        {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            
            memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + r;
            memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + g;
            memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + b;
            
        }
        int min =Math.min(memo[N][0], memo[N][1]);
        min =Math.min(min, memo[N][2]);
        
        System.out.println(min);
        
        sc.close();
    }
}
