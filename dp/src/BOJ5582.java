import java.util.*;
public class Main {	
	static final int MAXN = 4000;
	
	static int[][] dp = new int[MAXN + 2][MAXN + 2];

	
	public static void main(String[] args)
	{		
	    Scanner sc = new Scanner(System.in);
	    String x = sc.next();
	    String y = sc.next();
        int m = x.length();
        int n = y.length();
		int max = 0;
		
		for (int i = 1; i <= m; ++i)
		{
			for (int j = 1; j <= n; ++j)
			{
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;					
					max = Math.max(max, dp[i][j]);
				}
                // else dp[i][j] = 0;
			}
		}
		System.out.println(max);
	    sc.close();
	}
}
