class NumberContainers {

    HashMap<Integer,Integer> ind;
    HashMap<Integer,TreeSet<Integer>> num;
    public NumberContainers() {
        ind=new HashMap<>();
        num=new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(ind.get(index)!=null)
        num.get(ind.get(index)).remove(index);
        
        ind.put(index,number);
        if(num.get(number)==null) num.put(number,new TreeSet<>());
        num.get(number).add(index);
    }
    
    public int find(int number) {
        if(num.get(number)==null || num.get(number).higher(-1)==null) return -1;
        return num.get(number).higher(-1);
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
