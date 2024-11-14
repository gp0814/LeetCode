class Solution {
    private boolean isPossible(int n, int[] quantities, int value){
        int noStore = 0;
        for(int q:quantities){
            noStore+=Math.ceil((q*1.0)/value);
        }
        return (noStore<=n);
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int maxquan =0;
        for(int quan : quantities){
            maxquan = Math.max(maxquan,quan);
        }
        int l =0,r = maxquan,ans=m;
        while(l<=r){
            int mid = (l+r)/2;
            if(isPossible(n, quantities,mid)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
        
    }
    
}