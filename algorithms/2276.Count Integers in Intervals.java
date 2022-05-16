//Tamonash Chakraborty
//O(logn) for add
//O(1) for count
class CountIntervals {
    TreeMap<Integer,Integer> tm;
    int c;
    public CountIntervals() {   //set to default values
        tm=new TreeMap<>();
        c=0;
    }
    
    public void add(int l,int r) {
        if(tm.lowerKey(l+1)!=null)  //the previous may overlap with this
        {
            int u=tm.lowerKey(l+1),v=tm.get(u);
            if(v>=l)
            {
                tm.remove(u);
                c-=v-u+1;
                l=u;
                r=Math.max(v,r);
                l=Math.min(l,u);
            }
        }
        
        while(tm.higherKey(l-1)!=null)  //remove all which overlap with it and u>l
        {
            int u=tm.higherKey(l-1),v=tm.get(u);
            if(u>r) break;
            r=Math.max(v,r);
            
            tm.remove(u);
            c-=v-u+1;
        }
        c+=r-l+1;
        tm.put(l,r);    //add this segment
    }
    
    public int count() {
        return c;   //just return the sum of size of each set
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */
