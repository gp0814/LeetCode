class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int maxV = Integer.MIN_VALUE;

        for(int i =0;i<k;i++){
            minHeap.offer(new int[] {nums.get(i).get(0),i,0});
            maxV = Math.max(maxV , nums.get(i).get(0));
        }

        int rs = 0;
        int re = Integer.MAX_VALUE;

        while(!minHeap.isEmpty()){
            int[] minE = minHeap.poll();
            int minV = minE[0], row = minE[1], col = minE[2];

            if(maxV - minV < re - rs){
                rs = minV;
                re = maxV;
            }
            if(col+1<nums.get(row).size()){
                minHeap.offer(new int[] {nums.get(row).get(col+1),row,col+1});
                maxV = Math.max(maxV,nums.get(row).get(col+1));
            }
            else{
                break;
            }
        }
        return new int[] {rs,re};
        
    }
}