package dp.unboundedknapsack;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class RecursiveUnboundedKnapsack {
    private final int weights[];
    private final int profits[];


    public int solveKnapsack(int capacity, Integer[][] cache) {
        return knapsackRecursive(capacity, profits.length - 1,cache);
    }

    public int solveKnapsack2(int capacity) {
        return knapsackRecursive2(capacity, profits.length - 1);
    }
    private int knapsackRecursive(int capacity, int i, Integer[][] cache) {



        if(capacity<=0 || i <0)
            return 0;

        if(cache[i][capacity]!=null)
            return cache[i][capacity];

        int profit1 = 0;
        if(weights[i]<=capacity)
            profit1 = knapsackRecursive(capacity-weights[i],i,cache)+profits[i];

        int profit2 = knapsackRecursive(capacity,i-1,cache);
        int profit = Math.max(profit1, profit2);
        cache[i][capacity] = profit;
        return profit;
    }

    private int knapsackRecursive2(int capacity, int index) {
        if(capacity<=0 || index <0)
            return 0;

        int profit1 = 0;
        if(weights[index]<=capacity){
            int i = 1;
            while(weights[index]*i<=capacity){
                profit1 = Math.max(profit1,
                        knapsackRecursive2(capacity-weights[index]*i,
                                index-1)+i*profits[index]);
                i++;
            }
        }
        int profit2 = knapsackRecursive2(capacity,index-1);
        return Math.max(profit1,profit2);

    }

        public static void main(String[] args) {
        int[] profits = {1,4,6,8};
        int[] weights = {1,2,4,7};

        RecursiveUnboundedKnapsack unboundedKnapsack = RecursiveUnboundedKnapsack.builder()
                .weights(weights)
                .profits(profits)
                .build();

        Integer[][] cache =new Integer[profits.length][16];
        int profit = unboundedKnapsack.solveKnapsack(15,cache);
        System.out.println(profit);
        profit = unboundedKnapsack.solveKnapsack2(15);
            System.out.println(profit);
    }
}
