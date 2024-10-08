class Solution {
    public int minSwaps(String s) {
        int o =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['){
                o++;
            }
            else{
                if(o>0){
                    o--;
                }
            }
        }
        return (o+1)/2;
        
    }
}