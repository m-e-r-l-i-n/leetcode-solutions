class Solution {
    public int findPairs(int[] a, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int i,c=0;
        for(i=0;i<a.length;i++)
        if(hm.get(a[i])==null) hm.put(a[i],1);
        else hm.put(a[i],hm.get(a[i])+1);
        
        for(int x:hm.keySet())
        if(k==0 && hm.get(x)>1) c++;
        else if(k>0 && hm.get(x-k)!=null) c++;
        return c;
    }
}
