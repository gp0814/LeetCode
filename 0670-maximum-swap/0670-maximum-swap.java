class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        
        for (int i = 0; i < n; i++) {
            char maxDigit = digits[i];
            int index = -1;
            
            // Find the maximum digit on the right side of digits[i]
            for (int j = n - 1; j > i; j--) {
                if (digits[j] > maxDigit) {
                    maxDigit = digits[j];
                    index = j;
                }
            }
            
            // If a greater digit is found, swap and break
            if (index != -1) {
                char temp = digits[i];
                digits[i] = digits[index];
                digits[index] = temp;
                break;
            }
        }
        
        return Integer.parseInt(new String(digits));
    }
}