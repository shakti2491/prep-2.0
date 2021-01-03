package algods.dp.unboundedknapsack;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class RecursiveUnboundedKnapsack {
    private final int weights[];
    private final int profits[];
    private final int size;



    public int solveKnapsack(int capacity, Integer[][] cache) {
        return knapsack3(capacity);
    }

    public int solveKnapsack2(int capacity) {
        return knapsack2(capacity, profits.length - 1);
    }

    /*
algods.dp[i, w] = max(algods.dp[i - 1, w], algods.dp[i, w - weights[i]] + val[i])

Result = algods.dp[n - 1, W], where n = total number of items, W = weight we need to put in knapsack

Base case:
algods.dp[i, 0] = 0, for all i. The maximum value we can get is 0 when we are to put 0 weight in knapsack.
 */
    private int knapsack1(int capacity, int i, Integer[][] cache) {



        if(capacity<=0 || i <0)
            return 0;

        if(cache[i][capacity]!=null)
            return cache[i][capacity];

        int profit1 = 0;
        if(weights[i]<=capacity)
            profit1 = knapsack1(capacity-weights[i],i,cache)+profits[i];

        int profit2 = knapsack1(capacity,i-1,cache);
        int profit = Math.max(profit1, profit2);
        cache[i][capacity] = profit;
        return profit;
    }

    private int knapsack2(int capacity, int index) {
        if(capacity<=0 || index <0)
            return 0;

        int profit1 = 0;
        if(weights[index]<=capacity){
            int i = 1;
            while(weights[index]*i<=capacity){
                profit1 = Math.max(profit1,
                        knapsack2(capacity-weights[index]*i,
                                index-1)+i*profits[index]);
                i++;
            }
        }
        int profit2 = knapsack2(capacity,index-1);
        return Math.max(profit1,profit2);

    }
    /*

    algods.dp[w] = max(algods.dp[w - weights[i]] + val[i], // include item i
                algods.dp[w]) // do not include item i
            where i varies from 0 to n-1 such that:
            weights[i] <= w

     */
    private int knapsack3(int capacity){
        if(capacity<=0)
            return 0;

        int profit = 0;
        for(int i =0;i<size;i++){
            if(weights[i]<=capacity)
                profit = Math.max(profit,knapsack3(capacity-weights[i])+profits[i]);
        }
       return profit;
    }


        public static void main(String[] args) {
        int[] profits = {1,4,6,8};
        int[] weights = {1,2,4,7};

        RecursiveUnboundedKnapsack unboundedKnapsack = RecursiveUnboundedKnapsack.builder()
                .weights(weights)
                .profits(profits)
                .size(profits.length)
                .build();

        Integer[][] cache =new Integer[profits.length][16];
        int profit = unboundedKnapsack.solveKnapsack(15,cache);
        System.out.println(profit);
        profit = unboundedKnapsack.solveKnapsack2(15);
            System.out.println(profit);
    }
}
