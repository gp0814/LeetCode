class Solution {
    public int findKthNumber(int n, int k) {
        int prefix = 1;
        k--; // Adjust k to be zero-indexed

        while (k > 0) {
            int steps = countSteps(prefix, n);
            if (steps <= k) {
                // Move to the next prefix
                prefix++;
                k -= steps;
            } else {
                // Drill down to the next level
                prefix *= 10;
                k--;
            }
        }

        return prefix;
    }

    // Helper function to count the steps between two prefixes in the lexicographical order
    private int countSteps(int prefix, long n) {
        int steps = 0;
        long first = prefix;
        long last = prefix;

        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }

        return steps;
    }
}
