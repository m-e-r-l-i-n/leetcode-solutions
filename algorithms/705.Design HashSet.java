//memory efficient
class MyHashSet {

    /** Initialize your data structure here. */
    ArrayList<Integer> a;
    public MyHashSet() {
        a=new ArrayList<>();
    }
    
    public void add(int key) {
        int p=bsearch(key);
        if(p<0) 
        {
            p=-p-1;
            a.add(p,key);
        }
    }
    
    public void remove(int key) {
        int p=bsearch(key);
        if(p>=0) 
        {
            Integer i=key;
            a.remove(i);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bsearch(key)>=0;
    }
    
    int bsearch(int k)
    {
        int l=0,r=a.size()-1,mid;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a.get(mid)==k) return mid;
            if(a.get(mid)<k) l=mid+1;
            else r=mid-1;
        }
        
        return -(l+1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
 
 
 
 
 
 
 //time efficient
 class MyHashSet {

    /** Initialize your data structure here. */
    boolean a[];
    public MyHashSet() {
        a=new boolean[1000001];
    }
    
    public void add(int key) {
        if(!a[key]) a[key]=true;
    }
    
    public void remove(int key) {
        a[key]=false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return a[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
