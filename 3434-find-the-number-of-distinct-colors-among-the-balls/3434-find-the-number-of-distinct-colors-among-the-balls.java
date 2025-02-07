class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> cMap = new HashMap<>();
        Map<Integer, Integer> bMap = new HashMap<>();

        int n = queries.length;
        int []ans = new int[n];

        for(int i =0;i<n;i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            if(bMap.containsKey(ball)){
                int oldcolor = bMap.get(ball);
                cMap.put(oldcolor, cMap.get(oldcolor)-1);
                if(cMap.get(oldcolor)==0){
                    cMap.remove(oldcolor);
                }
            } 
            bMap.put(ball,color);
            cMap.put(color, cMap.getOrDefault(color,0)+1);
            ans[i]=cMap.size();
        }

        return ans;
   }
}