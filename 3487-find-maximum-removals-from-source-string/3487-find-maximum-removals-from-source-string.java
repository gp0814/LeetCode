class Solution {
    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        int n = source.length();
        int m = pattern.length();
        int[] dp = new int[m + 1];
        
        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        boolean[] isTarget = new boolean[n];
        for (int idx : targetIndices) {
            isTarget[idx] = true;
        }
        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                if (source.charAt(i) == pattern.charAt(j - 1) && dp[j - 1] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - 1] + (isTarget[i] ? 1 : 0));
                }
            }
        }
        return targetIndices.length - (dp[m] == Integer.MAX_VALUE ? 0 : dp[m]);
    }
}