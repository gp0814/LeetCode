class Solution {
    public boolean checkTwoChessboards(String co1, String co2) {
        int c1 = (int)co1.charAt(0) - 96;
        int c2 = (int)co2.charAt(0) - 96;
        if ( (c1+(int)co1.charAt(1)-48) %2==0 ) c1=0;
        else c1=1;
        if ( (c2+(int)co2.charAt(1)-48) %2==0 ) c2=0;
        else c2=1;
        return (c1==c2);
    }
}