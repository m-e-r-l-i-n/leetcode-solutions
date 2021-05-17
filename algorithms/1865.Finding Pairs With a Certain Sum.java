class FindSumPairs {
    HashMap<Integer,Integer> hm;
    int a[],b[];
    public FindSumPairs(int[] n1, int[] n2) {
        int n=n1.length,m=n2.length,i;
        a=new int[n]; b=new int[m];
        hm=new HashMap<>();
        for(i=0;i<n;i++) a[i]=n1[i];
        for(i=0;i<m;i++)
        {
            b[i]=n2[i];
            hm.put(b[i],hm.getOrDefault(b[i],0)+1);
        }    
    }
    
    public void add(int i, int v) {
        int x=hm.get(b[i]);
        x--;
        if(x==0) hm.remove(b[i]);
        else hm.put(b[i],x);
        b[i]+=v;
        hm.put(b[i],hm.getOrDefault(b[i],0)+1);
    }
    
    public int count(int tot) {
        int c=0,i;
        for(i=0;i<a.length;i++)
        c+=hm.getOrDefault(tot-a[i],0);
        return c;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
