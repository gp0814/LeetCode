import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Set<List<Integer>> numSet = new HashSet<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    numSet.add(Arrays.asList(nums[i], nums[j]));
                    numSet.add(Arrays.asList(nums[j], nums[i]));
                }
            }
        }

        int ans = numSet.size();
        if (k != 0) {
            ans /= 2;
        }

        return ans;
    }
}
