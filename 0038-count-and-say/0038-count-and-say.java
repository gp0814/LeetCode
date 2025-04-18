class Solution {
    public static List<int[]> getDigitFrequencyPairs(String s) {
        List<int[]> pairs = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            char digit = s.charAt(i);
            int count = 1;
            i++;
            while (i < s.length() && s.charAt(i) == digit) {
                count++;
                i++;
            }
            pairs.add(new int[]{digit - '0', count});
        }

        return pairs;
    }
    public static String buildFromPairs(List<int[]> pairs) {
        StringBuilder sb = new StringBuilder();
        for (int[] pair : pairs) {
            sb.append(pair[1]).append(pair[0]);
        }
        return sb.toString();
    }

    public String countAndSay(int n) {
        String current = "1";
        for (int i = 1; i < n; i++) {
            List<int[]> pairs = getDigitFrequencyPairs(current);
            current = buildFromPairs(pairs);
        }
        return current;
        
    }
}