class Solution {
    public int maxDiff(int num) {
        // Convert the number to a char array
        char[] original = String.valueOf(num).toCharArray();

        // === MAXIMIZE: Replace first non-9 digit with '9' ===
        char[] maxArray = original.clone();
        char toReplaceMax = 0;
        for (char c : maxArray) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        if (toReplaceMax != 0) {
            for (int i = 0; i < maxArray.length; i++) {
                if (maxArray[i] == toReplaceMax) {
                    maxArray[i] = '9';
                }
            }
        }

        // === MINIMIZE: Replace first digit (if not '1') with '1',
        // otherwise find next digit != '0' and replace with '0'
        char[] minArray = original.clone();
        char toReplaceMin = 0;

        if (minArray[0] != '1') {
            toReplaceMin = minArray[0];
            for (int i = 0; i < minArray.length; i++) {
                if (minArray[i] == toReplaceMin) {
                    minArray[i] = '1';
                }
            }
        } else {
            for (int i = 1; i < minArray.length; i++) {
                if (minArray[i] != '0' && minArray[i] != '1') {
                    toReplaceMin = minArray[i];
                    break;
                }
            }
            if (toReplaceMin != 0) {
                for (int i = 1; i < minArray.length; i++) {
                    if (minArray[i] == toReplaceMin) {
                        minArray[i] = '0';
                    }
                }
            }
        }

        int max = Integer.parseInt(new String(maxArray));
        int min = Integer.parseInt(new String(minArray));

        return max - min;
    }
}
