class Solution {
    class Pair{
        int n;
        int l;
        public Pair(int n,int l)
        {
            this.n=n;
            this.l=l;
        }
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            al.add(new ArrayList<>(List.of(i+1)));
        }
        int l= queries.length,k=0;
        int[] ans = new int[l];
        for(int i[] : queries)
        {
            al.get(i[0]).add(i[1]);
            ans[k++] = dfs(al,n);
        }
        return ans;
    }
    public int dfs(List<List<Integer>> al,int n)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        HashSet<Integer> h = new HashSet<>();
        h.add(0);
        while (!q.isEmpty())
        {
            Pair t = q.poll();
            if(t.n==n-1)
            {
                return t.l;
            }
            for(int i : al.get(t.n))
            {
                if(!h.contains(i))
                {
                    q.add(new Pair(i,t.l+1));
                    h.add(i);
                }
            }
        }
        return n-1;
    }
}