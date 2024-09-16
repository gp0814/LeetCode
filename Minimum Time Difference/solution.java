import java.util.*;

class Solution {
    // Method to convert time in "HH:MM" format to minutes
    public int timeConvertToMinutes(String time) {
        int hourToMinute = Integer.parseInt(time.substring(0, 2)) * 60;
        int minute = Integer.parseInt(time.substring(3));
        return hourToMinute + minute;
    }

    // Method to find the minimum time difference
    public int findMinDifference(List<String> timePoints) {
        // Sort the time points
        Collections.sort(timePoints);

        int ans = Integer.MAX_VALUE;
        List<Integer> minutes = new ArrayList<>();

        // Convert all time points to minutes
        for (String time : timePoints) {
            minutes.add(timeConvertToMinutes(time));
        }

        // Add the circular point (first point + 1440 minutes)
        minutes.add(minutes.get(0) + 1440);

        // Find the minimum difference
        for (int i = 1; i < minutes.size(); i++) {
            ans = Math.min(ans, minutes.get(i) - minutes.get(i - 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> timePoints = Arrays.asList("23:45", "00:30", "11:20");
        System.out.println(sol.findMinDifference(timePoints));  // Output the minimum time difference
    }
}
