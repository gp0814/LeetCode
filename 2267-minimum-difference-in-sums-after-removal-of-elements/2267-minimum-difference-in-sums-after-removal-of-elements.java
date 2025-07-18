class Solution 
{
    public long minimumDifference(int[] A) 
    {
        int n = A.length / 3;
        int len = A.length;

        // Step 1: Prefix - Max heap to track smallest n numbers
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long[] left = new long[len];
        long sum = 0;

        // Step 2: Build left[] where left[i] is min sum of n elements from 0 to i
        for (int i = 0; i < len; ++i) 
        {
            maxHeap.add(A[i]);
            sum += A[i];
            if (maxHeap.size() > n) 
            {
                sum -= maxHeap.poll();
            }

            if (i >= n - 1)
            {
                left[i] = sum;
            } 
        }

        // Step 3: Suffix - Min heap to track largest n numbers
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long[] right = new long[len + 1];
        sum = 0;

        // Step 4: Build right[] where right[i] is max sum of n elements from i to end
        for (int i = len - 1; i >= 0; --i) 
        {
            minHeap.add(A[i]);
            sum += A[i];
            if (minHeap.size() > n) 
            {
                sum -= minHeap.poll();
            }

            if (i <= len - n)
            {
                right[i] = sum;
            } 
        }

        // Step 5: Find minimum difference between left and right parts
        long ans = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; ++i) 
        {
            ans = Math.min(ans, left[i] - right[i + 1]);
        }

        return ans;
    }
}