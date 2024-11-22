class Solution {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        // Ek map banaye jo pattern aur unki frequency ko store karega.
        Map<String, Integer> patFreq = new HashMap<>();
        
        // Matrix ki har row ke liye loop chalayen.
        for (int[] row : mat) {
            StringBuilder pattern = new StringBuilder();
            
            // Agar pehla element 0 hai, to pattern waise ka waisa rakhein.
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit); // Har bit ko add karein.
            } else {
                // Agar pehla element 1 hai, to har bit ko flip karein (XOR operation).
                for (int bit : row) pattern.append(bit ^ 1);
            }
            
            // Pattern ko map mein uski frequency ke sath update karein.
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }
        
        // Map mein sabse zyada frequency wale pattern ki count return karein.
        return Collections.max(patFreq.values());
    }
}
