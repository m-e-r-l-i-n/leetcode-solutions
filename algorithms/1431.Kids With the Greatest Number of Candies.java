class Solution {
    public List<Boolean> kidsWithCandies(int[] c, int e) 
    {
        int n=c.length,i,max=0;
        for(i=0;i<n;i++)
        if(c[i]>max) max=c[i];
        List<Boolean> l=new ArrayList<>();
        for(i=0;i<n;i++)
            if(c[i]+e>=max) l.add(true);
            else l.add(false);
        return l;
    }
}
