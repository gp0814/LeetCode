import java.util.*;

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> suspiciousMethods = new HashSet<>();
        suspiciousMethods.add(k);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);

        // Graph representation: method a invokes method b
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] invocation : invocations) {
            graph.computeIfAbsent(invocation[0], x -> new ArrayList<>()).add(invocation[1]);
        }

        // BFS to mark all methods that can be reached from method k
        while (!queue.isEmpty()) {
            int method = queue.poll();
            List<Integer> invokedMethods = graph.getOrDefault(method, Collections.emptyList());
            
            for (int invokedMethod : invokedMethods) {
                if (suspiciousMethods.add(invokedMethod)) {
                    queue.add(invokedMethod);
                }
            }
        }

        // Early return: Check if any suspicious method is invoked by a non-suspicious method
        for (int[] invocation : invocations) {
            int caller = invocation[0];
            int callee = invocation[1];
            if (!suspiciousMethods.contains(caller) && suspiciousMethods.contains(callee)) {
                return createFullList(n);
            }
        }

        // Collect non-suspicious methods
        List<Integer> remainingMethods = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspiciousMethods.contains(i)) {
                remainingMethods.add(i);
            }
        }

        return remainingMethods;
    }

    // Helper method to return a list from 0 to n-1
    private List<Integer> createFullList(int n) {
        List<Integer> fullList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            fullList.add(i);
        }
        return fullList;
    }
}
