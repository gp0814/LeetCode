class Solution 
{
    //Function to reverse words in a given string.
    public String reverseWords(String S)
    {
        // code here
        String[] words=S.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);
            if(i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}