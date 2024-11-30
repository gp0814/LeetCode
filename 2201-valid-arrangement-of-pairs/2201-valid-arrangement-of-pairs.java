import java.util.*;

public class Solution {
    // Time = Space = O(V+E), V = no of Vertex/nodes and E = no of edges in Graph
    public int[][] validArrangement(int[][] pairs) {
        int l = pairs.length; // Total number of pairs ka size store kar rahe hain
        Map<Integer, List<Integer>> g = new HashMap<>(); // Graph ko adjacency list ke roop me store karne ke liye
        int start, end; // Har pair ka start aur end vertex
        Map<Integer, int[]> inOutDegree = new HashMap<>(); // Har node ke liye [In-degree, Out-degree] store karenge

        // Pairs traverse karte hain aur graph aur degree calculate karte hain
        for (int[] pair : pairs) {
            start = pair[0]; // Current pair ka start node
            end = pair[1];   // Current pair ka end node
            
            // Graph me edge add kar rahe hain
            g.computeIfAbsent(start, k -> new ArrayList<>()).add(end); // Start node ke liye adjacency list banakar end add karte hain
            g.putIfAbsent(end, new ArrayList<>()); // Agar end node graph me nahi hai to uske liye empty list banayenge
            
            // Out-degree update karte hain
            inOutDegree.putIfAbsent(start, new int[2]); // Agar start node pehla occurrence hai to [0, 0] initialize karte hain
            inOutDegree.get(start)[1]++; // Out-degree increment karte hain
            
            // In-degree update karte hain
            inOutDegree.putIfAbsent(end, new int[2]); // Agar end node pehla occurrence hai to [0, 0] initialize karte hain
            inOutDegree.get(end)[0]++; // In-degree increment karte hain
        }

        // Eulerian Circuit check karte hain aur source node identify karte hain
        int srcNode = pairs[0][0]; // Default source node pehle pair ka start node
        for (Map.Entry<Integer, int[]> entry : inOutDegree.entrySet()) {
            if (entry.getValue()[1] - entry.getValue()[0] == 1) { // Agar Out-degree - In-degree == 1
                srcNode = entry.getKey(); // Is node ko source node banate hain
                break;
            }
        }

        Stack<Integer> curPath = new Stack<>(); // Eulerian path build karte waqt current path track karne ke liye
        List<Integer> eulerianPath = new ArrayList<>(); // Final Eulerian path store karne ke liye
        curPath.push(srcNode); // Source node ko stack me daal dete hain
        while (!curPath.isEmpty()) {
            int node = curPath.peek(); // Current node dekhte hain
            if (g.get(node).isEmpty()) { // Agar current node ka Out-degree 0 hai, to backtrack karenge
                eulerianPath.add(node); // Node ko final path me add karte hain
                curPath.pop(); // Stack se remove karte hain
            } else {
                int next = g.get(node).remove(0); // Next node ko adjacency list se nikalte hain
                curPath.push(next); // Stack me push karte hain
            }
        }

        int i = -1; // Answer array ke liye index
        int[][] ans = new int[l][2]; // Final answer array
        // Eulerian path ko reverse me traverse karte hain aur answer build karte hain
        for (int j = eulerianPath.size() - 2; j >= 0; j--) {
            ans[++i][0] = eulerianPath.get(j + 1); // Start node
            ans[i][1] = eulerianPath.get(j); // End node
        }
        return ans; // Final result return karte hain
    }
}
