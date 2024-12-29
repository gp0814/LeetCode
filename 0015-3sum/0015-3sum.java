class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> list = new HashSet<>();
        for(int i = 0; i<= nums.length-3 ; i++){
            int low = i+1;
            int high = nums.length-1;
            int target = -1 * nums[i];

            while(low < high){
                if(nums[low] + nums[high] > target){
                    high--;
                }
                else if(nums[low] + nums[high] < target){
                    low++;
                }
                else{
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[low]);
                    newList.add(nums[high]);

                    list.add(newList);
                    low++;
                    high--;
                }
            }
        }

        return new ArrayList<>(list);
        
    }
}