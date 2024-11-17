import java.util.PriorityQueue;

class Pair{
    long sumValue;
    int index;
    Pair(long sumValue, int index){
        this.sumValue = sumValue;
        this.index = index;
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        long prefixSum =0;
        PriorityQueue<Pair> psh = new PriorityQueue<>((a, b) -> Long.compare(a.sumValue, b.sumValue));
        for(int j =0; j<n; j++){
            prefixSum+= nums[j];
            if(prefixSum>=k){
                ans = Math.min(ans,j+1);
            }
            while(!psh.isEmpty() && prefixSum - psh.peek().sumValue >=k){
                ans = Math.min(ans, j-psh.poll().index);
            }
            psh.add(new Pair(prefixSum,j));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
