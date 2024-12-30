// class Solution {
//     public int maximumProduct(int[] nums, int k) {
//         int n=nums.length;
//         long mod=1_000_000_007;
//         long ot=1;
        
//             while(k>0){
//                 Arrays.sort(nums);
//                 nums[0]=nums[0]+1;
//                 k=k-1;
//             }
        
//         for(int i=0;i<n;i++){
//             ot=(nums[i]*ot)%mod;
//         }
//         return (int)ot;


        
//     }
// }
class Solution {
    public int maximumProduct(int[] nums, int k) {
        long prod = 1;
        long mod = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums) pq.add(n);
        while(k>0){
            pq.offer(pq.poll() + 1);
            k--;
        }
        while(!pq.isEmpty()) prod = (prod * pq.poll()) % mod;
        return (int)(prod);
    }
}