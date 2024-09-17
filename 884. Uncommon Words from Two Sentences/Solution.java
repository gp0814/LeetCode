class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String s = s1 + " " + s2;
        
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        
        String[] words = s.split(" ");
        
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        
        List<String> store = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                store.add(entry.getKey());
            }
        }
        int h = store.size();
        String[] result = new String[h];
        for(int i=0;i<h;i++){
            result[i]= store.get(i);
        }
        
        return result;
    }
}