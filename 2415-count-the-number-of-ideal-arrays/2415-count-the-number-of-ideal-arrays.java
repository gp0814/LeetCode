class Solution {
    // Modulo value to prevent overflow (as required by the problem)
    static final int MOD = 1_000_000_007;

    // Upper limit for factorials, should be >= max(n, maxValue)
    static final int MAX = 10000 + 10;

    // Arrays to store factorials and inverse factorials for computing combinations (nCr)
    long[] factorial = new long[MAX];
    long[] invFactorial = new long[MAX];

    public int idealArrays(int n, int maxValue) {
        // Precompute factorials and inverse factorials for use in nCr
        precomputeFactorials();

        int maxLen = 14; // Maximum depth of divisibility chains is log2(maxValue), about 14 for 10^4

        // count[len][val] = number of ideal arrays of length 'len' ending with 'val'
        long[][] count = new long[maxLen + 1][maxValue + 1];

        // Initialize base case: all sequences of length 1 (just one number)
        for (int v = 1; v <= maxValue; v++) {
            count[1][v] = 1;
        }

        // Fill count array for sequences of length > 1 using multiplication chains
        for (int len = 2; len <= maxLen; len++) {
            for (int val = 1; val <= maxValue; val++) {
                // All multiples of val can come after val in an ideal array
                for (int mult = 2 * val; mult <= maxValue; mult += val) {
                    count[len][mult] = (count[len][mult] + count[len - 1][val]) % MOD;
                }
            }
        }

        // Final result accumulator
        long result = 0;

        // For each possible sequence length
        for (int len = 1; len <= maxLen; len++) {
            // Compute how many ways to choose positions in array of length n for len elements
            // (n-1 choose len-1) — placing increases at len-1 positions
            long ways = nCr(n - 1, len - 1);

            // For each possible value as the last element
            for (int v = 1; v <= maxValue; v++) {
                // Add to result: number of such sequences * number of ways to place them
                result = (result + count[len][v] * ways % MOD) % MOD;
            }
        }

        return (int) result;
    }

    // Precompute factorials and their modular inverses
    void precomputeFactorials() {
        factorial[0] = invFactorial[0] = 1;
        for (int i = 1; i < MAX; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;               // factorial[i] = i!
            invFactorial[i] = modInverse(factorial[i]);               // inverse of factorial[i] modulo MOD
        }
    }

    // Compute nCr = C(n, r) = n! / (r! * (n - r)!) mod MOD
    long nCr(int n, int r) {
        if (r > n || r < 0) return 0; // invalid case
        return factorial[n] * invFactorial[r] % MOD * invFactorial[n - r] % MOD;
    }

    // Compute modular inverse using Fermat's Little Theorem: a^(MOD-2) mod MOD
    long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    // Binary exponentiation: compute a^b mod MOD efficiently
    long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;  // If current bit is 1, multiply result
            a = a * a % MOD;                        // Square the base
            b >>= 1;                                // Move to next bit
        }
        return res;
    }
}