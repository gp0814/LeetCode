class Solution {
    public long maxKelements(int[] nums, int k) {
       
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        long count = 0; 
        while (k > 0) {
            int maxElement = maxHeap.poll(); 
            count += maxElement; 
            maxHeap.add((int) Math.ceil(maxElement / 3.0)); 
            k--;
        }
        
        return count;
    }
}
