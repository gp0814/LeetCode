class Solution {
    public int subarraySum(int[] nums) {
        int total = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int start = Math.max(0,i-nums[i]);
           while(start<=i){
               total += nums[start];
               start++;
           }
        }
        return total;
    }
}