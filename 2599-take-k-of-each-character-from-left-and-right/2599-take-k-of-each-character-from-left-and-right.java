class Solution {
    public int takeCharacters(String s, int k) {
        //Total count ke liye array
        int[] count = new int[3]; // size 3 is liye kyuki string me sirf a,b,c hi hai
        for(char c: s.toCharArray()){
            count[c - 'a']++;  // -a kyuki a ke ascii value me se a ko minus krenge to index 0 aayega waise hi b ka 1 or c ka 3 
        }
        if(Math.min(Math.min(count[0],count[1]),count[2])<k){   // condition iss liye kyuki agr ek v char agr k se kam hua toh kabhi milega hi nahi
            return -1;
        }

        // abb sliding window lgate hue 
        int res = Integer.MAX_VALUE;
        int l =0;
        for(int r =0;r<s.length();r++){
            count[s.charAt(r) - 'a']--;
            while(Math.min(Math.min(count[0], count[1]), count[2]) <k){
                count[s.charAt(l) - 'a']++;
                l++;
            }
            res = Math.min(res, s.length() - (r-l+1));
        }
        return res;
        
        
    }
}