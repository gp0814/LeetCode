class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] undef = new boolean[n];
        Arrays.fill(undef,true);

        for(int[] edge:edges){
            int winner = edge[0];
            int losser = edge[1];
            undef[losser] = false;
        }

        int champ = -1;
        int champCount =0;

        for(int i =0;i<n;i++){
            if(undef[i]){
                champ = i;
                champCount++;
            }
        }

        return champCount == 1 ? champ : -1;

        
    }
}