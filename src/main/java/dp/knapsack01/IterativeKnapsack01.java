package dp.knapsack01;
/*

knapsack(n,C) =  if W(n) > C
                        knapsack(n-1,C)
                 else if(W(n)<= C)
                        Max(knapsack(n-1,C),P(n)+knapsack(n-1,C-P(n))
 */

// cache[i][j] represents the profit till the ith index and j capacity left.
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class IterativeKnapsack01 {
    private final int[] profits;
    private final int[] weights;

    public int solveKnapsack(int capacity) {
        return knapsackOptimize(capacity);
    }
//runtime O(nC)
    // space O(nC)
    private int knapsackIterative(int capacity){
        int[][] cache = new int[profits.length+1][capacity+1];
        int n = profits.length;
        for(int i = 1; i<=n;i++){
            for(int j = 1; j<=capacity;j++){
                if(weights[i-1]>j){
                   cache[i][j] = cache[i-1][j];
                }else{
                    cache[i][j] = Math.max(cache[i-1][j], profits[i-1]+cache[i-1][j-weights[i-1]]);
                }
            }
        }
        return cache[n][capacity];
    }


    private int knapsackOptimize(int capacity){
        int[] cache = new int[capacity+1];
        int n = profits.length;
        for(int i =0; i<n; i++){
            for(int j = capacity; j>=weights[i];j--){
                cache[j] = Math.max(cache[j], profits[i]+cache[j-weights[i]]);
            }
        }
        return cache[capacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 6,  2,  2,4,6,3,1,5,9,1,3,2,5,2};
        int[] weights = {1, 2, 3,  5,  2,  5,6,7,8,9,7,9,6,8,6,5,5};

        int[] profits1 = {2,3,4,10};
        int[] weights1 = {1, 2,4,5};
        IterativeKnapsack01 knapsack01 = IterativeKnapsack01.builder()
                .profits(profits)
                .weights(weights)
                .build();
        System.out.println("Profit -->"+knapsack01.solveKnapsack(5));

    }
}
