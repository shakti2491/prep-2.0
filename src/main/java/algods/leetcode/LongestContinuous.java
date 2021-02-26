package algods.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuous {

    public int longestSubarray(int[] nums, int limit) {

        // minDQ will have smallest element at it's head and largest at it's tail
        Deque<Integer> minDQ = new LinkedList<>();
        // maxDQ will have largest element at it's head and smallest at it's tail
        Deque<Integer> maxDQ = new LinkedList<>();
        int start = 0;
        int end = 0;
        int maxLength = 1;
        while (end < nums.length) {
            while (!minDQ.isEmpty() && nums[minDQ.peekLast()] >= nums[end]) {
                // maintain minDQ increasing from first to last
                minDQ.pollLast();
            }
            // add the element in it's sorted position
            minDQ.addLast(end);
            while(!maxDQ.isEmpty() && nums[maxDQ.peekLast()] <= nums[end]) {
                // maintain maxPD decreasing from first to last
                maxDQ.pollLast();
            }
            // add the element in it's sorted position
            maxDQ.addLast(end);

            int min = nums[minDQ.peekFirst()];
            int max = nums[maxDQ.peekFirst()];
            if (max - min <= limit) {
                maxLength = Math.max(maxLength, end-start+1);
                end++;
            } else {
                // not a valid subarray
                while(!minDQ.isEmpty() && minDQ.peekFirst() <= start) {
                    // remove all elements which has appeared before start
                    minDQ.pollFirst();
                }
                while(!maxDQ.isEmpty() && maxDQ.peekFirst() <= start) {
                    // remove all elements which has appeared before start
                    maxDQ.pollFirst();
                }
                start++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        new LongestContinuous().longestSubarray(new int[]{8,2,4,7},4);
    }
}
