class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int m = rowIndex+1;
        for(int i=1;i<m;i++){
            res.add((int)((long)res.get(i - 1) * (m - i) / i));
        }
        return res;
        
    }
}