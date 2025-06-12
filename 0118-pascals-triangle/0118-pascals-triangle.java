class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int row = 1;row<= numRows;row++){
            res.add(generateRow(row));
        }
        return res;
        
    }
    public List<Integer> generateRow(int row){
        List<Integer> rowList = new ArrayList<>();
        long ans = 1;
        rowList.add(1);
        for(int col =1;col<row;col++){
            ans = ans*(row-col);
            ans= ans/col;
            rowList.add((int) ans);
        }
        return rowList;
    }
}