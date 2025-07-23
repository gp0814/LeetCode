class Solution {
    public int maximumGain(String s, int x, int y) {
    int counta=0;
    int countb=0;
    int res =0;
    int less=Math.min(x,y);

    int n= s.length();
    for(int i=0;i<n;i++){
        char ch=s.charAt(i);

        if(ch>'b'){
            res+=Math.min(counta,countb)*less;
            counta=0;
            countb=0;
        }
        else if(ch=='a'){
            if(x<y&&countb>0){
                countb--;
                res+=y;
            }
            else{
                counta++;
            }
        }
        else{
            if(x>y&&counta>0){
                counta--;
                res+=x;
            }
            else{
                countb++;
            }
        }
    }
    res+=Math.min(counta,countb)*less;
    return res;
        
    }
}