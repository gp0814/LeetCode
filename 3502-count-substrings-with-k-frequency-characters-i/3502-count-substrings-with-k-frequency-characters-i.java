import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int totalSubstrings = 0;

        // Two pointers for the sliding window
        int start = 0;

        // Frequency map to count occurrences of characters in the current window
        Map<Character, Integer> charCount = new HashMap<>();

        // Iterate over the string with the end pointer
        for (int end = 0; end < n; ++end) {
            char currentChar = s.charAt(end);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

            // Shrink the window from the left until it's valid
            while (isValidSubstring(charCount, k)) {
                // All substrings starting from 'start' to 'end' are valid
                totalSubstrings += (n - end);
                
                // Shrink the window by moving 'start' and updating frequency map
                char startChar = s.charAt(start);
                charCount.put(startChar, charCount.get(startChar) - 1);
                
                // If a character's count drops to zero, remove it from the map
                if (charCount.get(startChar) == 0) {
                    charCount.remove(startChar);
                }
                start++;
            }
        }

        return totalSubstrings;
    }

    // Helper function to check if any character in the window has a frequency >= k
    private boolean isValidSubstring(Map<Character, Integer> charCount, int k) {
        for (int count : charCount.values()) {
            if (count >= k) {
                return true;
            }
        }
        return false;
    }


}
