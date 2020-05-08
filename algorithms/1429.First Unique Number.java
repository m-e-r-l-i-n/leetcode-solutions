class FirstUnique {
    Map<Integer,Integer> hm;
    ArrayList<Integer> sin;
    public FirstUnique(int[] nums) 
    {
        hm=new LinkedHashMap<>();   //order will be the same as input
        sin=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.get(nums[i])==null) 
            hm.put(nums[i],1);
            else 
            hm.put(nums[i],hm.get(nums[i])+1);
        }
        for(int x:hm.keySet())
            if(hm.get(x)==1) sin.add(x);
    }
    
    public int showFirstUnique() 
    {
        if(sin.size()==0) return -1;
        else return sin.get(0);
    }
    
    public void add(int value) 
    {
        if(hm.get(value)==null)
        {sin.add(value);
        hm.put(value,1);}
        else
        {
            Integer v=new Integer(value);
            int val=hm.get(value);
            hm.put(value,val+1); 
            if(val==1) sin.remove(v);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
