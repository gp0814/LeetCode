class Solution {
    public int minMaxDifference(int num) {
        String str = Integer.toString(num);
        char[] max = str.toCharArray();
        char[] min = str.toCharArray();

        char replaceForMax = ' ';
        for(char c : max){
            if(c!='9'){
                replaceForMax = c;
                break;
            }
        }

        for(int i=0;i<max.length;i++){
            if(max[i]==replaceForMax){
                max[i]='9';
            }
        }

        char replaceForMin = min[0];
        for(int i=0;i<min.length;i++){
            if(min[i]==replaceForMin){
                min[i]='0';
            }
        }
        int maxVal = Integer.parseInt(new String(max));
        int minVal = Integer.parseInt(new String(min));

        return maxVal-minVal;
        
    }
}