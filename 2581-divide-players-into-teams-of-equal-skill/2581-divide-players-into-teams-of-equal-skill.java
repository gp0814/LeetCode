class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int n_2=n/2;
        long sum =0;
        for(int num:skill){
            sum+=num;
        }
        if(sum%n_2!=0){
            return -1;
        }
        int team_sill=(int)sum/n_2;
        Arrays.sort(skill);
        long chem =0;
        for(int i=0;i<n_2;i++){
            long l =skill[i];
            long r = skill[n-1-i];
            if(l+r!=team_sill){
                return -1;
            }
            else{
                chem+=l*r;
            }
        }
        return chem;
        
    }
}