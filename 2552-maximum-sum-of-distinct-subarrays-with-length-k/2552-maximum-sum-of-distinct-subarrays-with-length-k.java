// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         int n = nums.length;
//         long res = Long.MIN_VALUE; // long liya kyuki constrainnts ke karan tle maar sakta hai
//         for (int j = 0; j <= n - k; j++) { // window lete hue jiska size k hoga 
//             long sum = 0;
//             int i = j;
//             if (isdiff(nums, j, k)) { // isdiff function call krte bue kaati pta chl jaye iss window me sabhi elements alag hai yaa nahi
//                 while (i < k + j) {
//                     sum += nums[i];
//                     i++;
//                 }
//                 res = Math.max(sum, res); // res to update krte hue kyuki hame maximum sub find krna hai
//             }
//         }
//         return res == Long.MIN_VALUE ? 0 : res; // agar valid subarray nahi hai toh edge cases
//     }

//     public boolean isdiff(int[] nums, int start, int k) {
//         // hashset me distinct elements daalne ke liye
//         HashSet<Integer> set = new HashSet<>();
//         for (int i = start; i < start + k; i++) {
//             if (!set.add(nums[i])) {
//                 return false; // agar duplicate mila toh
//             }
//         }
//         return true; // Agar sabhi elements different hai  toh
//     }
// }
//upper wala code sahi hai pr tle maar diya hai

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long res = 0, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0, j = 0; j < n; j++) {
            // ye check krega ki jo window me elements hai wo distincts hai yaa nahi
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            
            // agr number pehle se nahi hai hashset me to add karega or sum me v add kr dega uska value
            set.add(nums[j]);
            sum += nums[j];
            
            // yaha window ka size k tak maintain krega
            if (j - i + 1 == k) {
                res = Math.max(res, sum);
                // abb agla window me sum find krega
                set.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
        }
        
        return res;
    }
}
