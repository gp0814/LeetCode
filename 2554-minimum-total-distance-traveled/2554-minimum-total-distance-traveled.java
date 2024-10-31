class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int n = robot.size();
        int m = factory.length;
        
        
        long[][] dp = new long[m + 1][n + 1];
        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            int factoryPos = factory[i - 1][0];
            int limit = factory[i - 1][1];

            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];

                long distance = 0;
                for (int k = 1; k <= limit && j - k >= 0; k++) {
                    distance += Math.abs(robot.get(j - k) - factoryPos);
                    if (dp[i - 1][j - k] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + distance);
                    }
                }
            }
        }

        return dp[m][n];
    }
}