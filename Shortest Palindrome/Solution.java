

public class Solution {

    public String shortestPalindrome(String s) {
        int n = s.length();
        String original = s;

        // Reverse the original string
        String reversed_s = new StringBuilder(s).reverse().toString();

        // Create the new string for KMP processing
        String str = s + "*" + reversed_s;

        // KMP algorithm to create LPS (longest prefix suffix) array
        int[] lps = new int[2 * n + 1];
        int i = 0, j = 1;

        while (j < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }

        // Calculate the number of characters to append
        int diff = n - lps[2 * n];

        // Append the necessary characters in reverse order
        String to_append = reversed_s.substring(0, diff);
        return to_append + original;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aacecaaa";
        System.out.println("Shortest palindrome: " + solution.shortestPalindrome(s));
    }
}
