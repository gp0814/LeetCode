class Solution {
    public int maximumLength(String s) {
        int n = s.length(); // String ka length nikal lo
        int max_len = -1; // Maximum length ka initial value -1 rakha

        // 1 se leke n tak ke sab length ke liye loop chalao
        for (int len = 1; len <= n; ++len) {
            Map<String, Integer> freq = new HashMap<>(); // Substring ka frequency track karne ke liye map banaya

            // Current length ke sab substrings ka loop chalao
            for (int i = 0; i <= n - len; ++i) {
                String sub = s.substring(i, i + len); // Substring nikalo i se i+len tak

                boolean isSpecial = true; // Is substring "special" hai ya nahi, check karne ke liye flag

                // Substring ke sab characters check karo
                for (int j = 1; j < len; ++j) {
                    if (sub.charAt(j) != sub.charAt(0)) { // Agar sab characters same nahi hain
                        isSpecial = false; // "Special" nahi hai
                        break; // Loop break kar do
                    }
                }

                if (isSpecial) { // Agar substring special hai
                    freq.put(sub, freq.getOrDefault(sub, 0) + 1); // Frequency update karo

                    // Agar frequency 3 ya usse zyada ho
                    if (freq.get(sub) >= 3) {
                        max_len = Math.max(max_len, len); // Max length update karo
                    }
                }
            }
        }

        return max_len; // Maximum special substring length return karo
    }
}
