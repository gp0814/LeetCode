class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        //finding the index from where we have to break so that we can swap and get next permutation
        for(int i = n-2; i >= 0 ; i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1){
            reverse(nums,0);
            return;
        }
        else{

            // now finding the elemnets which is greater than the break point and smallest in the left group so that after swapping we get next smallest grater number
            for(int i = n-1;i>idx;i--){
                if(nums[idx] < nums[i]){
                    swap(nums, idx,i);
                    break;
                }
            }
            reverse(nums,idx+1);
        }
        
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int start){
        int i = start;
        int j = nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}