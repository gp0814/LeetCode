class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int xorsum = 0;
        for(int i=0;i<n;i++){
            xorsum^=derived[i];
        }
        return xorsum==0;
        
    }
}