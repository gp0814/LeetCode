// Using Slop concept for the optimal solution
// keeping trace of the increasing slop and descreasing slop


class Solution {
    public int candy(int[] ratings) {
        int sum = 1;
        int i = 1;
        int n = ratings.length;
        while(i <n){
            if(ratings[i]==ratings[i-1]){
                sum+=1;
                i++;
                continue;
            }
            int peak = 1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak+=1;
                sum+=peak;
                i++;
            }
            int down = 1;
            while(i<n && ratings[i]<ratings[i-1]){
                sum+=down;
                down++;
                i++;
            }
            if(down > peak){
                sum+=(down-peak);
            }

        }

        return sum;
        
    }
}