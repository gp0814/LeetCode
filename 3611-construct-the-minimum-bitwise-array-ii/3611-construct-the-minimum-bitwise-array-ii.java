import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        List<Integer> ans = new ArrayList<>();
        
        for (int num : nums) {
            List<Integer> candidates = new ArrayList<>();
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    int x = num & ~(1 << i);
                    if ((x | (x + 1)) == num) {
                        candidates.add(x);
                    }
                }
            }
            if (candidates.isEmpty()) {
                ans.add(-1);
            } else {
                int minCandidate = Integer.MAX_VALUE;
                for (int candidate : candidates) {
                    minCandidate = Math.min(minCandidate, candidate);
                }
                ans.add(minCandidate);
            }
        }
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}
