// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//         int closest = nums[0] + nums[1] + nums[2];

//         for (int i = 0; i < nums.length - 2; i++) {
//             for (int j = i + 1; j < nums.length - 1; j++) {
//                 for (int k = j + 1; k < nums.length; k++) {
//                     int currentSum = nums[i] + nums[j] + nums[k];
//                     if (Math.abs(target - currentSum) < Math.abs(target - closest)) {
//                         closest = currentSum;
//                     }
//                 }
//             }
//         }

//         return closest;
//     }
// }
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int currSum = nums[i] + nums[left] + nums[right];

                if (currSum == target) {
                    return target;
                }

                if (Math.abs(currSum - target) < Math.abs(closest - target)) {
                    closest = currSum;
                }

                if (currSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closest;
    }
}