package algods.dp.unboundedknapsack;

/*
two ways to write DP
TC(amount) = Sum(TC(amount-coin)) for all coin in coins


count(S, n, total) = count(S, n, total-S[n]) + count(S, n-1, total);

    // Use Case of Unbounded Knapsack concept
    // memo[0][i] = 0 for all i because if coins[] is empty there is no way to make i amount
    // memo[i][0] = 1 for all i >= 0, since if amount is zero then

 */
public class CoinChangeTotalCombination {
    public static int totalCombinations(int[] coins, int n,int amount){
        if(amount ==0)
            return 1;
        if(amount < 0 || n<0)
            return 0;

        int inc = totalCombinations(coins,n,amount-coins[n]);
        int exc = totalCombinations(coins,n-1,amount);
        return inc+exc;
    }


    public static int totalCombinations2(int [] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0;i<=n;i++)
            dp[i][0] = 1;


        for(int index = 1; index <=n;index++){
            for(int total = 1; total<=amount;total++){
                                /*
                IF coin[i - 1] > amount: do not include coin[i - 1]
                algods.dp[i][j] = algods.dp[i - 1][j];
                */

                dp[index][total] = dp[index-1][total]; // exclude

                /*
                ELSE:
                1. include coin[i - 1] once or multiple times: algods.dp[i][j] = algods.dp[i][amount - coin[i - 1]]
                3. do not include coin[i - 1]: algods.dp[i][j] = algods.dp[i - 1][j]
                        */

                if(coins[index-1]<=total){
                    if(dp[index][total-coins[index-1]]!=-1)
                            dp[index][total] += dp[index][total-coins[index-1]];
                }
            }
        }
        return dp[n][amount];

    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int target = 5;
        System.out.println(totalCombinations(coins,coins.length-1,target));
    }
}
