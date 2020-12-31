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
    private final int size;

    public int solveKnapsack(int capacity) {
        return knapsackIterative(capacity);
    }
//runtime O(nC)
    // space O(nC)

    /*

    Define M[i,w] to be the maximum value
    that can be attained with weight less than or equal to w
     using items up to i (first i items).

  m[0, w]=0
  m[i, w]=  m[i-1, w] if w_{i}>w  (the new item is more than the current weight limit)
  m[i, w]=  max(m[i-1, w], m[i-1,w-w_{i}]+v_{i}) if  w_{i} <= w.
     */

    private int knapsackIterative(int maxCapacity){
        int[][] M = new int[profits.length+1][maxCapacity+1];
        for(int element = 1; element<=size;element++){
            for(int capacity = 1; capacity<=maxCapacity;capacity++){
                if(weights[element-1]>capacity){
                   M[element][capacity] = M[element-1][capacity];
                }else{
                    M[element][capacity] = Math.max(M[element-1][capacity],
                            profits[element-1]+M[element-1][capacity-weights[element-1]]);
                }
            }
        }
        return M[size][maxCapacity];
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
                .size(profits.length)
                .build();
        System.out.println("Profit -->"+knapsack01.solveKnapsack(15));

    }
}
