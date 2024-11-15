class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int l = 0;
        while(l+1<n && arr[l]<=arr[l+1]){
            l++;
        }

        if(l==n-1){
            return 0;
        }
        int r = n-1;
        while(r>0 && arr[r-1]<=arr[r]){
            r--;
        }
        int res = Math.min(n-l-1,r);
        int i=0, j=r;
        while(i<=l && j<n){
            if(arr[i] <= arr[j]){
                res = Math.min(res, j-i-1);
                i++;
            }
            else{
                j++;
            }
        }
        return res;
        
    }
}