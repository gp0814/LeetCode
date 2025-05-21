/***class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;

                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1||col[j]==1){
                    matrix[i][j]=0;
                }
            }
        }
        
        
    }
}***/
class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n= matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] column = new boolean[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    rows[i]=true;
                    column[j]=true;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(rows[i] || column[j])
                {
                    matrix[i][j]=0;            }
            }
        }


        }
}