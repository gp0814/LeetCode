// class Solution {
//     public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
//         int n = s.length();
//         long[] prefixZeros = new long[n + 1];
//         long[] prefixOnes = new long[n + 1];

        
//         for (int i = 0; i < n; i++) {
//             prefixZeros[i + 1] = prefixZeros[i] + (s.charAt(i) == '0' ? 1 : 0);
//             prefixOnes[i + 1] = prefixOnes[i] + (s.charAt(i) == '1' ? 1 : 0);
//         }

//         long[] result = new long[queries.length];

        
//         for (int i = 0; i < queries.length; i++) {
//             int li = queries[i][0];
//             int ri = queries[i][1];
//             long count = 0;

            
//             for (int start = li; start <= ri; start++) {
//                 for (int end = start; end <= ri; end++) {
//                     long zeros = prefixZeros[end + 1] - prefixZeros[start];
//                     long ones = prefixOnes[end + 1] - prefixOnes[start];
//                     if (zeros <= k || ones <= k) {
//                         count++;
//                     }
//                 }
//             }

//             result[i] = count;
//         }

//         return result;
//     }
// }

class Solution {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length(), m = queries.length;
        
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = s.charAt(i) - '0';
        }
        
        long pre = 0;
        long[] presum = new long[n];
        int[] thresholdEndWith = new int[n];
        int[] runningCounts = new int[2];
        for (int i = 0, j = 0; i < n; i++) {
            while (j < n) {
                runningCounts[data[j]]++;
                if (runningCounts[0] <= k || runningCounts[1] <= k) {
                    thresholdEndWith[j] = i;
                    j++;
                } else {
                    runningCounts[data[j]]--;
                    break;
                }
            }
            pre = presum[i] = pre + (j - i);
            runningCounts[data[i]]--;
        }
        
        long[] ans = new long[m];
        for (int i = 0; i < m; i++) {
            int[] q = queries[i];
            int th = Math.max(q[0], thresholdEndWith[q[1]]);
            if (q[0] < th) {
                // left (pink-background) part, by presum approach
                ans[i] = presum[th - 1] - (q[0] == 0 ? 0 : presum[q[0] - 1]);
            }
            // right (blue-background) part, by mathematical fomula
            ans[i] += (long)(q[1] - th + 2) * (q[1] - th + 1) / 2;
        }
        return ans;
    }
}