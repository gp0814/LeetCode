class Solution {
    public int minAddToMakeValid(String s) {
        int ob =0;
        int cb=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                ob++;
            }
            else{
                if(ob>0){
                    ob--;
                }
                else{
                    cb++;
                }
            }
        }
        return ob+cb;
        
    }
}