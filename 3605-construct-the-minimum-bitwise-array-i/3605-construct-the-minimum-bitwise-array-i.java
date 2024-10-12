import java.util.List;

public class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        // Iterate over each element in nums
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            boolean found = false;
            
            // Try to find the smallest x such that x OR (x + 1) == num
            for (int x = 0; x <= num; x++) {
                if ((x | (x + 1)) == num) {
                    ans[i] = x;
                    found = true;
                    break;
                }
            }
            
            // If no valid x is found, set ans[i] to -1
            if (!found) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}