
import java.util.*;

class Solution {

    public int[] resultsArray(int[] nums, int k){
        int n = nums.length;
        int[] results = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutiveSorted = true;

            
            for (int j = 1; j < k; j++) {
                if (nums[i + j] != nums[i + j - 1] + 1) {
                    isConsecutiveSorted = false;
                    break;
                }
            }

            if (isConsecutiveSorted) {
                results[i] = findMax(nums, i, i + k);
            } else {
                results[i] = -1;
            }
        }

        return results;
    }

    private static int findMax(int[] nums, int start, int end) {
        int max = nums[start];
        for (int i = start + 1; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
