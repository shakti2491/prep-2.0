package dp.unboundedknapsack;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IterativeUnboundedKnapsack {
    private final int weights[];
    private final int[] profits;

    public int solveKnapsack(int capacity, Integer[][] cache) {
        return knapsack(capacity);
    }

    private int knapsack(int capacity){
        int[]cache = new int[capacity+1];
        int n = profits.length;
        for(int i = 0; i<=capacity ; i++){
            for(int j= 0; j<n ;j++){
                if(weights[j]<=i)
                cache[i] = Math.max(cache[i], cache[i-weights[j]]+profits[j]);
            }

        }
        return cache[capacity];
    }
}
