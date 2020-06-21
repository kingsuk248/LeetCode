package challenge.coding.june;

//TODO
public class CoinChange2 {
	public static void main(String[] args) {
		CoinChange2 cc2 = new CoinChange2();
		int amount = 5;
		int[] coins = { 1, 2, 5 };
		// Time limit exceeded. Try with DP
		System.out.println(cc2.change(amount, coins));
	}

	public int change(int amount, int[] coins) {
		return coinChange(coins, coins.length, amount);
	}

	private int coinChange(int[] coins, int l, int amount) {
		if (amount == 0) {
			return 1;
		}
		if (amount <= 0 || (l <= 0 && amount >= 1) ) {
			return 0;
		}
		int incl = coinChange(coins, l - 1, amount);
		int excl = coinChange(coins, l, amount - coins[l - 1]);
		return incl + excl;
	}
}
