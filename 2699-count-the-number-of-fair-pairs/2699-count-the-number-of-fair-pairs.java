class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return cal(nums,upper)-cal(nums,lower-1);
        
    }
    private long cal(int[] nums, int value){
        int l=0;
        int r=nums.length-1;
        long res =0;
        while(l<r){
            int sum=nums[l]+nums[r];
            if(sum<=value){
                res+=(r-l);
                l++;
            }
            else{
                r--;
            }

        }
        return res;
    }
}