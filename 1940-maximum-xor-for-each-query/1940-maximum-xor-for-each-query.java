class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int c = 0, Max_XOR = (1 << maximumBit) - 1;
        for(int num : nums)
        {
            c ^= num;
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
        {
            res[i] = Max_XOR ^ c;
            c ^= nums[n - 1 - i];
        }
        return res;
    }
}