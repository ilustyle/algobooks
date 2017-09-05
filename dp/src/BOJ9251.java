import java.util.*;

public class BOJ9251 { // 재귀호출 -> 런타임에러
	
	static final int MAXN = 1000;	
	static int[][] memo = new int[MAXN + 2][MAXN + 2];
	static String x, y;
	
    static int LCS_iter(int m, int n)
	{
        for(int i = 0; i <= m; i++) memo[i][0] = 0;
        for(int i = 0; i <= n; i++) memo[0][i] = 0;
        
	    for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(x.charAt(i - 1) == y.charAt(j - 1))
					memo[i][j] = memo[i - 1][j - 1] + 1;
				else					
					memo[i][j] = memo[i - 1][j] > memo[i][j - 1]? memo[i - 1][j] : memo[i][j - 1];
			}
		}
		return memo[m][n];		
	}
	
	public static void main(String[] args)
	{	
		
	    Scanner sc = new Scanner(System.in);
	    x = sc.next();
	    y = sc.next();	
		
        System.out.println( LCS_iter(x.length(), y.length()) );   
	    sc.close();
	}
}
