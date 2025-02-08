class NumberContainers {
    private Map<Integer, Integer> mp;
    private Map<Integer, TreeSet<Integer>> mpp;

    public NumberContainers() {
        mp = new HashMap<>();
        mpp = new HashMap<>();
        
    }
    
    public void change(int index, int number) {
        if(mp.containsKey(index) && mp.get(index)!=number){
            mpp.get(mp.get(index)).remove(index);
            if(mpp.get(mp.get(index)).isEmpty()){
                mpp.remove(mp.get(index));
            }
        }
        mp.put(index,number);
        mpp.computeIfAbsent(number, k-> new TreeSet<>()).add(index);
        
    }
    
    public int find(int number) {
        return mpp.containsKey(number) && !mpp.get(number).isEmpty() ? mpp.get(number).first() : -1;
        
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */