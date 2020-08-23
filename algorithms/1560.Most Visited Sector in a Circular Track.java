class Solution {
    public List<Integer> mostVisited(int n, int[] r) {
        int v[]=new int[n],i,cur=r[0]-1;
        for(i=1;i<r.length;i++)
        {
            r[i]--;
            while(cur!=r[i])
            {
                v[cur++]++;
                cur%=n;
            }
            v[cur++]++;
            cur%=n;
        }    
        List<Integer> l=new ArrayList<>();
        int max=0;
        for(i=0;i<n;i++)
        if(v[i]>max)
        {
            max=v[i];
            l=new ArrayList<>();
            l.add(i+1);
        }
        else if(v[i]==max) l.add(i+1);
        return l;
    }
}
