class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            
            dp[i].put((2 * nums[i]) % k, 1); 
            for (int j = 0; j < i; j++) {
                int modSum = (nums[i] + nums[j]) % k;
                int prevLen = dp[j].getOrDefault(modSum, 1); 
                int newLen = prevLen + 1;
                dp[i].put(modSum, Math.max(dp[i].getOrDefault(modSum, 1), newLen));
                maxLen = Math.max(maxLen, dp[i].get(modSum));
            }
        }

        return maxLen;
    }
}
