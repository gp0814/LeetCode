class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] fre = new int[2 * n]; // Allocate sufficient size for frequency counts
        int[] res = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            fre[A[i]]++;
            if (fre[A[i]] == 2) {
                count++;
            }
            fre[B[i]]++;
            if (fre[B[i]] == 2) {
                count++;
            }
            res[i] = count;
        }

        return res;
    }
}
