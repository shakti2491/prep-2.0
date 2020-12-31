package dp.unboundedknapsack;


/*

dp[w] = max(dp[w - weights[i]] + val[i], // include item i
            dp[w]) // do not include item i
        where i varies from 0 to n-1 such that:
        weights[i] <= w

 */
import lombok.Builder;
import lombok.RequiredArgsConstructor;
@Builder
@RequiredArgsConstructor
public class IterativeUnboundedKnapsack {
    private final int weights[];
    private final int[] profits;
    private final int size;

    public int solveKnapsack(int capacity) {
        return knapsack(capacity);
    }
    /*

    dp[w] = max(dp[w - weights[i]] + val[i], // include item i
                dp[w]) // do not include item i
            where i varies from 0 to n-1 such that:
            weights[i] <= w

     */
    private int knapsack(int maxCapacity){
        int[]cache = new int[maxCapacity+1];
        int n = profits.length;
        for(int j= 0; j<n ;j++){
        for(int capacity = 1; capacity<=maxCapacity ; capacity++){
                if(weights[j]<=capacity)
                cache[capacity] = Math.max(cache[capacity], cache[capacity-weights[j]]+profits[j]);
            }

        }
        return cache[maxCapacity];
    }

    /*
    dp[i, w] = max(dp[i - 1, w], dp[i, w - weights[i]] + val[i])

Result = dp[n - 1, W], where n = total number of items, W = weight we need to put in knapsack

Base case:
dp[i, 0] = 0, for all i. The maximum value we can get is 0 when we are to put 0 weight in knapsack.
     */

    private int knapsack2(int maxCapacity){
        int[][] cache = new int[size+1][maxCapacity+1];

        for(int element = 1; element<=size;element++){
            for(int capacity = 1; capacity<=maxCapacity;capacity++){
                if(weights[element-1]>capacity)
                    cache[element][capacity] = cache[element-1][capacity];
                else{
                    cache[element][capacity] = Math.max(cache[element-1][capacity],
                            cache[element][capacity-weights[element-1]]+profits[element-1]);
                }
            }
        }
        return cache[size][maxCapacity];
    }
    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 6};
        int[] weights = {1, 2, 3,  5};
        IterativeUnboundedKnapsack knapsack = IterativeUnboundedKnapsack.builder()
                .profits(profits)
                .weights(weights)
                .size(profits.length).build();

        System.out.println("Profit 1-->> "+knapsack.knapsack(7));
        System.out.println("Profit 2-->> "+knapsack.knapsack2(7));
    }
}
