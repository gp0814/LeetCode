class Solution {
    int maxx = -1;
    public int lenLongestFibSubseq(int[] arr) 
    {
        int max = -1;
        HashSet<Integer> hs = new HashSet<>();
        for(int x : arr)
        hs.add(x);
        for(int i=0; i< arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                maxx = Math.max(f(arr[i], arr[j], hs, 2), maxx);
            }
        }
        return maxx == 2 ? 0 : maxx;
    }
    public int f(int f, int s, HashSet<Integer> hs, int len)
    {
        if(hs.contains(f+s))
        {
            return f(s, f+s, hs, len+1);
        }
        return len;
    }
}