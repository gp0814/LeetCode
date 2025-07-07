import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, n = events.length, day = 1, count = 0;
        int lastDay = Arrays.stream(events).mapToInt(e -> e[1]).max().getAsInt();

        while (day <= lastDay && (i < n || !pq.isEmpty())) {
            // Skip to next available day
            if (pq.isEmpty() && i < n) {
                day = Math.max(day, events[i][0]);
            }

            // Remove events that ended before today
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Add all events starting today
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Attend the event that ends earliest
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }

            day++;
        }

        return count;
    }
}