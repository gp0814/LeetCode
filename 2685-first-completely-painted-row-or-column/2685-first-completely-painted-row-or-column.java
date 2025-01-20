import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, int[]> mp = new HashMap<>();
        int[] r = new int[m];
        int[] c = new int[n];
        
        for(int i = 0; i < m; i++) {
            r[i] = n;
        }
        for(int i = 0; i < n; i++) {
            c[i] = m;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                mp.put(mat[i][j], new int[]{i, j});
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            int[] pos = mp.get(arr[i]);
            int row = pos[0], col = pos[1];
            r[row]--;
            c[col]--;
            if(r[row] == 0 || c[col] == 0) return i;
        }
        
        return -1;
    }
}