class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum =0;
        for(int num:nums){
            sum+=num;
        }
        long rem =sum%p;
        System.out.println(rem);
        if(rem==0){
            return 0;
        }
        return fss(nums,p,rem);

        
    }
    private int fss(int[] nums, int p,long rem){
        HashMap<Long,Integer> pmm = new HashMap<>();
        pmm.put(0L,-1);
        long cs =0;
        int ml = nums.length;
        for(int i=0;i<nums.length;i++){
            cs+=nums[i];
            long cm = cs%p;
            long tm = (cm-rem+p)%p;
            if(pmm.containsKey(tm)){
                ml=Math.min(ml,i-pmm.get(tm));
            }
            pmm.put(cm,i);
        }
        return ml==nums.length?-1:ml;
    }
}
/**public class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int remainder = (int)(totalSum % p);
        if (remainder == 0) return 0;

        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, -1);

        int n = nums.length;
        int prefixSum = 0;
        int minLength = n;

        for (int i = 0; i < n; i++) {
            prefixSum = (prefixSum + nums[i]) % p;
            if (prefixSum < 0) {
                prefixSum += p;  // Adjust for negative remainders
            }

            int target = (prefixSum - remainder + p) % p;
            if (prefixSums.containsKey(target)) {
                minLength = Math.min(minLength, i - prefixSums.get(target));
            }

            prefixSums.put(prefixSum, i);
        }

        return minLength == n ? -1 : minLength;
    }
}**/