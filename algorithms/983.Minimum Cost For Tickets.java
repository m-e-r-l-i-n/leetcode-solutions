class Solution {
    public int mincostTickets(int[] d, int[] c) 
    {
        boolean v[]=new boolean[366];
        int min[]=new int[366],i,m;
        for(i=0;i<d.length;i++)
        v[d[i]]=true;
        
        for(i=1;i<366;i++)
        {
            if(!v[i]) {min[i]=min[i-1]; continue;}
            m=min[i-1]+c[0];
            m=Math.min(m,min[Math.max(0,i-7)]+c[1]);
            m=Math.min(m,min[Math.max(0,i-30)]+c[2]);
            min[i]=m;
        }    
        return min[365];
    }
}
