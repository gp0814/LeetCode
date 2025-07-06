class FindSumPairs {
    int[] nums1 = new int[1000];
    int[] nums2 = new int[1000];
    HashMap<Integer,Integer>mp= new HashMap<>();
    public FindSumPairs(int[] n1, int[] n2) {
        this.nums1=n1;
        this.nums2=n2;
        for(int i=0;i<nums2.length;i++)
        {
            mp.put(nums2[i],mp.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int i, int val) {
        mp.put(nums2[i],mp.getOrDefault(nums2[i],0)-1);
        nums2[i]+=val;
        mp.put(nums2[i],mp.getOrDefault(nums2[i],0)+1);
    }
    
    public int count(int tot) {
        int cnt=0;
        for(int i=0;i<nums1.length;i++)
        {
            int second = tot-nums1[i];
            cnt+=mp.getOrDefault(second,0);
        }
        return cnt;
    }
}


/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */