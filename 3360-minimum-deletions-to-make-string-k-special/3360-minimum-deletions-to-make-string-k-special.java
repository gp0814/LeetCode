class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> fre = new HashMap<>();
        for(char c: word.toCharArray()){
            fre.put(c,fre.getOrDefault(c,0) + 1);
        }

        List<Integer> freq = new ArrayList<>(fre.values());
        Collections.sort(freq);

        int minDel = Integer.MAX_VALUE;
        int n = freq.size();

        for(int i=0;i<n;i++){
            int base = freq.get(i);
            int totalDel = 0;

            for(int j = 0; j<i; j++){
                totalDel += freq.get(j);
            }

            for(int j = i; j<n;j++){
                if(freq.get(j) > base +k){
                    totalDel += freq.get(j) - (base +k);
                }
            }

            if(totalDel < minDel){
                minDel = totalDel;
            }
        }

        return minDel;
        
    }
}