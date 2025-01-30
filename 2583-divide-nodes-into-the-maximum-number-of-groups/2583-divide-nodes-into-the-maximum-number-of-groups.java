class Solution {
    ArrayList<Integer>[] graph;
    ArrayList<ArrayList<Integer>> components = new ArrayList<>();

    void build_graph(int[][] edges) {
        for (int e[] : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
    }

    int findComp(int n) {
        int[] visited = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (visited[i] != 0) continue;
            ArrayList<Integer> comp = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            comp.add(i);
            visited[i] = 1;
            q.add(i);
            while (!q.isEmpty()) {
                int current = q.poll();
                ArrayList<Integer> nei = graph[current];
                for (int x : nei) {
                    if (visited[x] == 0) {
                        visited[x] = visited[current] + 1;
                        q.add(x);
                        comp.add(x);
                    }else if (Math.abs(visited[x] - visited[current]) != 1) {
                        return -1;
                    }
                }
            }
            components.add(comp);
        }
        return 0;
    }

    public int magnificentSets(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        build_graph(edges);
        int k=findComp(n);
        if(k==-1)return k;
        int maxAll = 0;
        for (ArrayList<Integer> comp : components) {
            int maxComp = -1;
            for (int s : comp) {
                int groups = 0;
                Queue<Integer> q = new LinkedList<>();
                int[] visited = new int[n + 1];
                visited[s] = 1;
                q.add(s);
                while (q.size() != 0) {
                    int size = q.size();
                    groups++;
                    for (int i = 0; i < size; i++) {
                        int current = q.poll();
                        ArrayList<Integer> nei = graph[current];
                        for (int x : nei) {
                            if (visited[x] == 0) {
                                visited[x] = visited[current] + 1;
                                q.add(x);
                            }
                        }
                    }
                }
                maxComp = Math.max(maxComp, groups);
            }
            maxAll += maxComp;
        }
        return maxAll;
    }
}