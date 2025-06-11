// class Solution {
//     public int maxDifference(String s, int k) {
//         int n = s.length();
//         int maxDiff = -1;

//         for (int start = 0; start <= n - k; start++) {
//             int[] freq = new int[5];

//             for (int end = start; end < n; end++) {
//                 int digit = s.charAt(end) - '0';
//                 freq[digit]++;

//                 if (end - start + 1 >= k) {
//                     // Find max(freq[a] - freq[b]) where a is odd, b is even and freq[b] > 0
//                     for (int a = 0; a < 5; a++) {
//                         if (freq[a] % 2 == 1) {
//                             for (int b = 0; b < 5; b++) {
//                                 if (freq[b] % 2 == 0 && freq[b] > 0) {
//                                     maxDiff = Math.max(maxDiff, freq[a] - freq[b]);
//                                 }
//                             }
//                         }
//                     }
//                 }
//             }
//         }

//         return maxDiff;
//     }
// }

class Solution {
    private int getState(int count_a, int count_b)
	{
		int parity_a = count_a&1;
		int parity_b = count_b&1;
		
		if(parity_a==0 && parity_b==0) return 0; // even even
		
		if(parity_a==0 && parity_b==1) return 1; // even odd
		
		if(parity_a==1 && parity_b==0) return 2; // odd even
		
		return 3; // odd odd
	}
	
	public int maxDifference(String s, int k) 
    {
        int n = s.length();
        
        int res = Integer.MIN_VALUE;
        
        for(char a='0';a<='4';a++)
        {
        	for(char b='0';b<='4';b++)
        	{
        		if(a==b) continue;
        		
        		// stateMinPrev_a_b = stores the smallest value of count of a - count of b
        		int stateMinPrev_a_v[] = new int[4];
        		
        		Arrays.fill(stateMinPrev_a_v, Integer.MAX_VALUE);
        		
        		// Count of a and count of b till index r
        		int count_a = 0;
        		int count_b = 0;
        		
        		// Count of a and count of b till prev index l
        		int prev_a = 0;
        		int prev_b = 0;
        		
        		// Let's start the sliding window
        		int l = -1;
        		int r = 0;
        		
        		while(r<n)
        		{
        			count_a += (s.charAt(r)==a) ? 1 : 0;
        			count_b += (s.charAt(r)==b) ? 1 : 0;
        			
        			// Now try to shrink from l
        			while(r-l>=k && count_b-prev_b>=2 && count_a-prev_a>=1)
        			{
        				int leftState = getState(prev_a, prev_b);
        				
        				stateMinPrev_a_v[leftState] = Math.min(stateMinPrev_a_v[leftState], prev_a-prev_b);
        				
        				l++;
        				
        				prev_a += (s.charAt(l)==a) ? 1 : 0;
        				prev_b += (s.charAt(l)==b) ? 1 : 0;
        			}
        			
        			int rightState = getState(count_a, count_b);
        			
        			int bestLeftState = rightState ^ 2;
        			
        			int bestMinDiffValueLeft = stateMinPrev_a_v[bestLeftState];
        			
        			if(bestMinDiffValueLeft!= Integer.MAX_VALUE)
        			{
        				res = Math.max(res, (count_a - count_b) - bestMinDiffValueLeft);
        			}
        			
        			r++;
        		}
        	}
        }
        
        return res;
    }
}