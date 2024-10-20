class Solution {
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();
        StringBuilder screen = new StringBuilder();  // Screen starts empty
        
        // Iterate through each character in the target string
        for (char ch : target.toCharArray()) {
            // Step 1: Append 'a' (Key 1)
            screen.append('a');
            result.add(screen.toString());
            
            // Step 2: Increment the last character (Key 2) until it matches target character
            while (screen.charAt(screen.length() - 1) != ch) {
                // Increment last character
                char lastChar = screen.charAt(screen.length() - 1);
                lastChar++;
                screen.setCharAt(screen.length() - 1, lastChar);  // Update the last character
                result.add(screen.toString());  // Add the updated screen to the result
            }
        }
        
        return result;
        
    }
}