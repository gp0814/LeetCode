class Solution {
    public long findScore(int[] nums) {
        int arr[][] = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        boolean mark[] = new boolean[nums.length];
        long score = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mark[arr[i][1]] == false) {
                score += arr[i][0];
                if ((arr[i][1] - 1) >= 0)
                    mark[arr[i][1] - 1] = true;
                if ((arr[i][1] + 1) < nums.length)
                    mark[arr[i][1] + 1] = true;
            }
        }
        return score;
    }
}