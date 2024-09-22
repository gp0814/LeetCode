

class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0, high = 1;
        while (!isPossible(high, mountainHeight, workerTimes)) {
            high *= 2;
        }
        while (low < high) {
            long mid = (low + high) / 2;
            if (isPossible(mid, mountainHeight, workerTimes)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    boolean isPossible(long maxTime, int mountainHeight, int[] workerTimes) {
        int totalHeight = 0;

        for (int time : workerTimes) {
            long maxLevels = (long) ((-1 + Math.sqrt(1 + 8.0 * maxTime / time)) / 2);
            totalHeight += maxLevels;
            if (totalHeight >= mountainHeight) {
                return true;
            }
        }
        return totalHeight >= mountainHeight;
    }
}
