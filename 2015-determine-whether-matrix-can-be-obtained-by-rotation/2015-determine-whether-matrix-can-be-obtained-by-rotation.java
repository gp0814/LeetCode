class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {

        for(int i = 0 ; i < 4 ; i++){
            if(isEqual(mat,target)){
                return true;
            }
            mat = rotate(mat);
        }
        return false;
        
    }

    public static int[][] rotate(int[][] mat){
        int[][] ans = mat;
        int n = ans.length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int temp = ans[i][j];
                ans[i][j] = ans[j][i];
                ans[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = ans[i][j];
                ans[i][j] = ans[i][n-1-j];
                ans[i][n-1-j] = temp;
            }
        }
        return ans;
    }

    public static boolean isEqual(int[][] m1, int[][] m2){
        if(m1.length != m2.length){
            return false;
        }
         if(m1[0].length != m2[0].length){
            return false;
        }

        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[0].length;j++){
                if(m1[i][j] != m2[i][j]){
                    return false;
                }
            }
        }
        return true;
        
    }
}