class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0; 
        int maxPrev = values[0]; // Initial value for values[i] + i
        
        for (int j = 1; j < values.length; j++) {
            // Calculate max score with the current element as the second point
            maxScore = Math.max(maxScore, maxPrev + values[j] - j);
            
            // Update maxPrev for the next iteration
            maxPrev = Math.max(maxPrev, values[j] + j);
        }
        
        return maxScore;
    }
}
