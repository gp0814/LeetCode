class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for(int num:nums){
            maxOR |= num;
        }
        int[] count = new int[1];
        backT(nums,0,0,maxOR,count);
        return count[0];
        
    }
    public void backT(int[] nums, int index, int currentOR, int maxOR, int[] count){
        if(currentOR==maxOR){
            count[0]++;
        }
        for(int i = index;i<nums.length;i++){
            backT(nums,i+1,currentOR | nums[i], maxOR, count);
        }
    }
}