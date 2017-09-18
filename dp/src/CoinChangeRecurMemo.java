public class CoinChangeRecurMemo {
	static int[] coin = new int[]{1, 4, 6};	
	static int[] memo = new int[1000];
	//재귀 + 메모
	public static int coinChange(int money)
	{ 
		if(memo[money] != 0) return memo[money];
		if(money == 0) return memo[money] = 0;
		
		int min = 0xfff;
		for(int i = 0; i < coin.length; i++)
		{
			if(money < coin[i]) continue;

			int ret = coinChange(money - coin[i]);
			
			if(min > ret) min = ret;
		}
		System.out.printf("memo[%d] = %2d\n", money, min + 1);
		return memo[money] = min + 1;
	}
	
	public static void main(String[] args) {		
		System.out.println(coinChange(8));				
	}
}
