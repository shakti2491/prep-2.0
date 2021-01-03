package algods.dp.unboundedknapsack;

import java.util.Arrays;

public class CoinChange {


    public static int coinChangeRecursive(int amount, int[] coins){
        if(amount<=0)
            return 0;

        int count = Integer.MAX_VALUE;
        for(int i =0;i<coins.length;i++){
            if(coins[i]<=amount)
                count = Math.min(count, coinChangeRecursive(amount-coins[i],coins)+1);
        }
        return count;
    }


    public static int coinChangeIterative(int amount, int[] coins){
        int count[] = new int[amount+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        count[0] = 0;
        for(int i =0;i<coins.length;i++){
        for(int value = 1;value<=amount;value++){

                if(coins[i]<=value)
                    count[value] = Math.min(count[value], count[value-coins[i]]+1);
            }
        }
       return count[amount] == Integer.MAX_VALUE ?-1:count[amount];
    }


    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // mark all of them in algods.dp[][] as IMPOSSIBLE since we do not which ones would be possible / feasible.
        // example: coins = [2], amount = 3 is an impossible combination.
        // so we will start with marking all as impossible and then
        // in the later stage we will compute the ones possible and left the rest as impossible. This is the plan.
        //
        // So initialize with INFINITY (Integer.MAX_VALUE) then we will later compute the one
        // which are possible (since not all denominations will make up to the amount)
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], amount+1);
        }
        // if amount = 0, algods.dp result = 0 since you do not need any coin to make up amount 0.
        // algods.dp[i][0] = 0 for all i
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int len = 1; len <= n; len++) {
            for (int amt = 1; amt <= amount; amt++) {
                if(coins[len-1]>amt){
                    dp[len][amt] = dp[len - 1][amt];//exclude
                }
                 else {
                        dp[len][amt] = Math.min(dp[len-1][amt], dp[len][amt - coins[len-1]] + 1); // include
                }
            }
        }
        return dp[n][amount] == amount+1 ? -1 : dp[n][amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChangeIterative(11, new int[]{1,2,5}));
        System.out.println(coinChange( new int[]{1,2,5},11));

    }
}
