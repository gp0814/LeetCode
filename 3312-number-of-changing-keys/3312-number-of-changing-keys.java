class Solution {
    public int countKeyChanges(String s) {
        s = s.toLowerCase();
        int ans =0;
        int n = s.length();
        for(int i =1 ; i<n;i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                ans++;
            }
        }
        return ans;

        
    }
}