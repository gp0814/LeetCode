class Solution {
    // Direction vectors for moving in four directions: right, left, down, up
    int[][] dir = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    int m, n;
    boolean[][] visited;

    public int minimumTime(int[][] grid) {
        // Base case: Agar dono adjacent cells start se inaccessible hain, to -1 return karo
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        // Grid ke dimensions initialize karo
        m = grid.length;
        n = grid[0].length;

        // Priority queue use karte hain Dijkstra's algorithm ke liye (min-heap time ke basis pe)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        visited = new boolean[m][n];

        // Starting cell ko priority queue mein daalo: {row, col, time}
        pq.offer(new int[]{0, 0, 0});

        // Priority queue ko process karo jab tak woh empty na ho
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int row = curr[0], col = curr[1], time = curr[2];

            // Agar bottom-right cell tak pahuch gaye, to time return karo
            if (row == m - 1 && col == n - 1) return time;

            // Agar current cell already visited hai to skip karo
            if (visited[row][col]) continue;

            // Current cell ko visited mark karo
            visited[row][col] = true;

            // Chaar possible directions explore karo
            for (int[] d : dir) {
                int r = row + d[0], c = col + d[1];

                // Check karo ki neighboring cell valid hai (bounds ke andar aur not visited)
                if (!valid(r, c)) continue;

                // Neighboring cell tak pahuchne ka earliest time calculate karo
                // Time ko parity ke basis par adjust karo taaki cell ke constraint match karein
                int f = (grid[r][c] - time) % 2 == 0 ? 1 : 0;
                int t = Math.max(time + 1, grid[r][c] + f);

                // Neighboring cell ko priority queue mein daalo
                pq.offer(new int[]{r, c, t});
            }
        }
        // Agar bottom-right cell tak nahi pahuch sakte, to -1 return karo
        return -1;
    }

    // Helper method to check karo ki cell bounds ke andar hai aur visited nahi hai
    private boolean valid(int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n && !visited[i][j];
    }
}
