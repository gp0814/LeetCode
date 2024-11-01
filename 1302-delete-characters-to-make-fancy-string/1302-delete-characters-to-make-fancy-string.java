class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); 
            int len = result.length();
            
            if (len < 2 || !(result.charAt(len - 1) == result.charAt(len - 2) && result.charAt(len - 1) == ch)) {
                result.append(ch);
            }
        }
        
        return result.toString();
    }
}
