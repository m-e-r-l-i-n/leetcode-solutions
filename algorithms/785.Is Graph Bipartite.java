class Solution {
    public boolean isBipartite(int[][] g) 
    {
        int i,n=g.length,c[]=new int[n];
        for(i=0;i<n;i++)
        if(c[i]==0)    
        {
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            c[i]=1;
            while(!q.isEmpty())
            {
                int p=q.poll();
                for(int x:g[p])
                if(c[x]==0)
                {
                    c[x]=c[p]==1?2:1;
                    q.add(x);
                }
                else if(c[x]==c[p]) return false;
            }
        }
        return true;
    }
}
