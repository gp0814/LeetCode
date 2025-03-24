class Solution {
    public int countDays(int days, int[][] meetings) {
      Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int busyDays = 0;
        int prevStart = -1, prevEnd = -1;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (prevEnd < start - 1) { // No overlap, count previous interval
                if (prevStart != -1) {
                    busyDays += (prevEnd - prevStart + 1);
                }
                prevStart = start;
                prevEnd = end;
            } else { // Merge overlapping intervals
                prevEnd = Math.max(prevEnd, end);
            }
        }
        // Add the last merged interval
        if (prevStart != -1) {
            busyDays += (prevEnd - prevStart + 1);
        }

        // Return available days
        return days - busyDays;
        
    }
}
