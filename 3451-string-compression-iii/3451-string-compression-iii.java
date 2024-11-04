class Solution {
    public String compressedString(String word) {
        int count = 1;
        StringBuilder res = new StringBuilder();
        char cchar = word.charAt(0);
        for(int i=1;i<word.length();i++){
            char nchar = word.charAt(i);
            if(nchar==cchar && count<9){
                count++;
            }
            else{
                res.append(count).append(cchar);
                cchar = nchar;
                count = 1;

            }
        }
        res.append(count).append(cchar);
        return res.toString();
    }
}