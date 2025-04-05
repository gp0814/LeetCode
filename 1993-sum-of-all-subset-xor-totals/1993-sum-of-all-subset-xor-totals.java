class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length, total = 0;
        for (int j = 0; j < (1 << n); j++) {
            int subsetXor = 0;
            for (int i = 0; i < n; i++) {
                if ((j & (1 << i)) != 0) {
                    subsetXor ^= nums[i];
                }
            }
            total += subsetXor;
        }
        return total;
    }
}