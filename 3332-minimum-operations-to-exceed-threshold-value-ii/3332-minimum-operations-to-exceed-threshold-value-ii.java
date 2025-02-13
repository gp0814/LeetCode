class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Double> res = new PriorityQueue<>();
        for(int num:nums){
            res.add((double)num);
        }
        int count =0;
        while(res.size()>1){
            double x = res.poll();
            double y = res.poll();
            if(x>=k){
                return count;
            }
            double n = Math.min(x,y)*2+Math.max(x,y);
            res.add(n);
            count++;
        }
        return count;
        
    }
}