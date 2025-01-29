class Solution {
    public int findParent(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node], parent);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        
        
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        
        int[] ans = new int[2];

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];

            int p1 = findParent(n1, parent);
            int p2 = findParent(n2, parent);

            if (p1 == p2) {
                ans[0] = n1;
                ans[1] = n2;
            } else {
                parent[p2] = p1;
            }
        }
        
        return ans;
    }
}
