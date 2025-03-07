import java.math.BigInteger;

import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        if (right - left < 1) return new int[]{-1, -1};

        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = Math.max(left, 2); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        if (primes.size() < 2) return new int[]{-1, -1};

        int[] result = {primes.get(0), primes.get(1)};
        int minDiff = result[1] - result[0];

        for (int i = 1; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i);
                result[1] = primes.get(i + 1);
            }
        }

        return result;
    }

}