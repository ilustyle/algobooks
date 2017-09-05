// RGB 거리
import java.util.Scanner;

public class BOJ1149 {

    static int[][] rgb;
    static int[][] house;
    static int N;

    static int solve(int n, int color)
    {
        if(house[n][color] != 0) return house[n][color];
        if(n == 1){
            return house[1][color] = rgb[1][color];
        }		
        int min = 0xfffffff;		
        for(int i = 0; i < 3; i++)
        {
            if(i == color) continue;
            int ret = solve(n - 1, i); 
            if(min > ret) min = ret;			
        }
        return house[n][color] = min  + rgb[n][color]; 
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        house = new int[N + 1][3];
        rgb = new int[N + 1][3];
        
        for(int i = 1; i <= N; i++)
        {
            rgb[i][0] = sc.nextInt();
            rgb[i][1] = sc.nextInt();
            rgb[i][2] = sc.nextInt();
        }
        int min = 0xfffffff;
        for(int i = 0; i < 3; i++)
        {
            min = Math.min(min, solve(N, i));
        }
        System.out.println(min);

        sc.close();
    }
}

