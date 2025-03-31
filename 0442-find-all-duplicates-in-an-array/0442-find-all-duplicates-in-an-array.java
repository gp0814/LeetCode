class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashSet<Integer> map= new HashSet<>();
        List<Integer> list= new ArrayList<>();
        for(int num:nums){
            if(!map.add(num)){
                list.add(num);
            }
        }
        return list;
        
    }
}