class Solution {
    public int compress(char[] chars) {
        int i =0;
        int j =0;
        while(j<chars.length){
            int count =0;
            char cchar = chars[j];
            while(j<chars.length && cchar == chars[j]){
                j++;
                count++;
            }
            chars[i]=cchar;
            i++;
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char ch : countStr.toCharArray()) {
                    chars[i] = ch;
                    i++;
                }
            }
        }
        return i;
        
    }
}