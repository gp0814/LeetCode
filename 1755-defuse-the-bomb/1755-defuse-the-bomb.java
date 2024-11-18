class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if(k==0){
            return res;
        }

        int s = 1;
        int e = k;
        int sum = 0;
        if(k<0){
            s = n- Math.abs(k);
            e = n-1;
        }
        for(int i =s ; i<= e;i++){
            sum+=code[i];
        }

        for(int i=0;i<n;i++){
            res[i] = sum;
            sum-=code[s%n];
            sum+=code[(e+1)%n];
            s++;
            e++;
        }
        return res;
        
    }
}