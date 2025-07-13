class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        int n = players.length;
        int m = trainers.length;

        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;
        int count = 0;

        while(i<n && j<m){

            if(players[i]<=trainers[j]){
                count++;
                i++;
                j++;
            }
            else{
                j++;
            }

        }
        return count;
        
    }
}