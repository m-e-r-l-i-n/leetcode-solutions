class Solution {
    int max,p[],s[];
    public int largestComponentSize(int[] a) {
        int i,n=a.length,j;
        p=new int[n]; s=new int[n]; max=1;
        for(i=0;i<n;i++)
        {
            p[i]=i;
            s[i]=1;
        }
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
            for(j=2;j*j<=a[i];j++)
            if(a[i]%j==0)
            {
                if(hm.get(j)==null) hm.put(j,i);
                else union(i,hm.get(j));
                
                if(hm.get(a[i]/j)==null) hm.put(a[i]/j,i);
                else union(i,hm.get(a[i]/j));
            }
            if(hm.get(a[i])==null) hm.put(a[i],i);
            else union(i,hm.get(a[i]));
        }
        return max;
    }
    
    void union(int x,int y)
    {
        int rx=find(x),ry=find(y);
        if(rx!=ry)
        {
            p[rx]=ry;
            s[ry]+=s[rx];
            max=Math.max(max,s[ry]);
        }
    }
    
    int find(int x)
    {
        if(x==p[x]) return x;
        return p[x]=find(p[x]);
    }
}
