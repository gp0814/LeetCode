class Solution {

    static class Pair {
        String first;
        int second;

        public Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.first;
            int steps = pair.second;

            if (word.equals(endWord))
                return steps;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }

        }

        return 0;
    }
}