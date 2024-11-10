class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int end = 0;
        int start  = 0;
        int curr = 0;
        int ans= Integer.MAX_VALUE;
        int[] arr = new int[32];


        while(end < nums.length){
            update(arr,nums[end],1);
            curr = convert(arr);
            while(start<=end && curr>=k){
                ans = Math.min(ans, end-start+1);
                update(arr,nums[start],-1);
                start++;
                curr = convert(arr);
            }
            end++;
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }

    private int convert(int[] arr){
        int ans = 0;
        for(int i = 0;i<32;i++){
            if(arr[i]!=0){
                ans = ans | (1<<i);
            }
        }
        return ans;
    }
    private void update(int[] arr, int num, int d){
        for(int i =0;i<32;i++){
            if( ((num>>i) & 1) !=0){
                arr[i]+=d;
            }
        }
    }
}