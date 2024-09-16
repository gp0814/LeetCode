class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        
        
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        
        
        int[] result = new int[2]; 
        int index = 0;
        for (int num : frequency.keySet()) {
            if (frequency.get(num) == 2) {
                result[index++] = num;
                if (index == 2) break; 
            }
        }
        
        return result;
    }

}