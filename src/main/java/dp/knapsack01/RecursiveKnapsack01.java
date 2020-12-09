package dp.knapsack01;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Builder
public class RecursiveKnapsack01 {

    private final int[] profits;
    private final int[] weights;

    public int solveKnapsack(int capacity, Integer[][] cache) {
        return knapsackRecursive(capacity, profits.length - 1,cache);
    }


    private int knapsackRecursive(int capacity, int index,Integer[][] cache) {

        // base case
        if (index == -1 || capacity <= 0)
            return 0;
        if(cache[capacity][index]!=null)
            return cache[capacity][index];

        int profit1 = 0;
        if (capacity - weights[index] >= 0) {
            profit1 = knapsackRecursive(capacity - weights[index], index - 1,cache) + profits[index];
        }
        int profit2 = knapsackRecursive(capacity, index - 1,cache);
        int profit = Math.max(profit1, profit2);
        cache[capacity][index] = profit;
        return profit;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] profits = {1, 6,10,6,2,2,4,6,3,1,5,9,1,3,2,5,2};
        int[] weights = {1, 2,3,5,2,5,6,7,8,9,7,9,6,8,6,5,5};

        RecursiveKnapsack01 knapsack01 = RecursiveKnapsack01.builder()
                .profits(profits)
                .weights(weights)
                .build();

        int[] capacities = new int[]{4,5,6,7,8,9,10,12,14,15,14,2,1,0,-1};
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        if(weights.length == profits.length) {
            for (int capacity : capacities) {
                System.out.println("Capacity-->>" + capacity +
                        "Total knapsack profit ---> " + knapsack01.solveKnapsack(capacity, new Integer[capacity+1][profits.length]));
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken"+(endTime-startTime));


            for (int capacity : capacities) {
                futures.add(CompletableFuture.supplyAsync(()-> knapsack01.solveKnapsack(capacity,new Integer[capacity+1][profits.length])));
            }

            Thread.sleep(20);
        startTime = System.currentTimeMillis();
        for (int i=0;i<capacities.length;i++) {
            System.out.println("Capacity-->>" + capacities[i] + "Total knapsack profit ---> " + futures.get(i).get());
        }
         endTime = System.currentTimeMillis();
        System.out.println("Time taken"+(endTime-startTime));
    }
}
