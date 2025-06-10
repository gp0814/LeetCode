class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int max = 0;

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
                
            } else {
                count++;
                max = Math.max(max,count);
            }
        }
        return max;
    }
}