public class CoinChangeRecur {
	
	static int[] coin = new int[]{1, 4, 6};

	public static int coinChange(int money)
	{
		if(money == 0) return 0;
		
		int min = 0xfff;
		for(int i = 0; i < coin.length; i++)
		{
			if(money < coin[i]) continue;

			int ret = coinChange(money - coin[i]);
			
			if(min > ret) min = ret;
		}
		return min + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(coinChange(8));
	}
}
