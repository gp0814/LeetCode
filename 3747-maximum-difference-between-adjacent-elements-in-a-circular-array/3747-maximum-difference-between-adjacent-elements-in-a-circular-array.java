class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxdiff = 0;

        
        for (int i = 0; i < n; i++) {
        
            int diff = Math.abs(nums[i] - nums[(i + 1) % n]); 
            maxdiff = Math.max(maxdiff, diff);
        }

        return maxdiff;
        
    }
}