class Solution {
    public int minCapability(int[] nums, int k) {   
        int left = 1;
        int right = Arrays.stream(nums).max().orElseThrow();
        int ans = right;

        while(left <= right){
            int mid = (left+right)/2;

            if(canRob(nums,mid,k)){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
     return ans;
    }

    private static boolean canRob(int[] nums, int mid, int k){
        int count =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] <= mid){
                count++;
                i++;
            }
        }
        return count >= k;
    }

}
