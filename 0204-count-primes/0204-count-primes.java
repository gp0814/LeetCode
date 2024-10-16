class Solution {
    public int countPrimes(int n) {
        boolean[] isp = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++){
            isp[i]=true;
        }
        for(int i=2;i<n;i++){
            if(isp[i]){
                count++;
                for(int j =i*2;j<n;j+=i){
                    isp[j]=false;
                }
            }
        }
        return count;

        
    }
}