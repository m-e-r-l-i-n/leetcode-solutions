class RandomizedSet {
    ArrayList<Integer> al;
    HashMap<Integer,Integer> hm;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        al=new ArrayList<>();
        hm=new HashMap<>();
        r=new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.get(val)==null)
        {
            hm.put(val,al.size());
            al.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int ind=hm.getOrDefault(val,-1);
        if(ind==-1) return false;
        Collections.swap(al,ind,al.size()-1);
        int sw=al.get(ind);
        hm.put(sw,ind);    //adjusting values in the hashmap as well
        al.remove(al.size()-1);
        hm.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int v=r.nextInt(al.size());
        return al.get(v);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
