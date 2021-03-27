class Solution {
    public int[] advantageCount(int[] a, int[] b) 
    {
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        int i,n=a.length,ans[]=new int[n];
        for(i=0;i<n;i++)
        tm.put(a[i],tm.getOrDefault(a[i],0)+1);
        
        for(i=0;i<n;i++)
        {
            Integer h=tm.higherKey(b[i]);
            if(h==null) ans[i]=-1;
            else
            {
                ans[i]=h;
                if(tm.get(h)==1) tm.remove(h);
                else tm.put(h,tm.get(h)-1);
            }
        }
        for(i=0;i<n;i++)
        if(ans[i]==-1)
        {
            ans[i]=tm.higherKey(-1);
            if(tm.get(ans[i])==1) tm.remove(ans[i]);
            else tm.put(ans[i],tm.get(ans[i])-1);
        }
        return ans;
    }
}
