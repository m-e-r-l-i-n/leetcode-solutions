class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int i,n=amount.length;
        ArrayList<Integer> g[]=new ArrayList[n];
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        for(i=0;i<n-1;i++)
        {
            g[edges[i][0]].add(edges[i][1]);
            g[edges[i][1]].add(edges[i][0]);
        }
        
        int dbob[]=new int[n],dalice[]=new int[n],par[]=new int[n];
        Queue<Integer> q=new LinkedList<>();
        dalice[0]=1; par[0]=-1;
        q.add(0);
        while(!q.isEmpty()) //distance from 0, parents of each node
        {
            int cur=q.poll();
            for(int x:g[cur])
            if(dalice[x]==0)
            {
                par[x]=cur; dalice[x]=dalice[cur]+1;
                q.add(x);
            }
        }
        
        boolean isbob[]=new boolean[n];
        dbob[bob]=1; 
        while(bob!=0)  //find bob's path
        {
            dbob[par[bob]]=dbob[bob]+1;
            isbob[bob]=true;
            bob=par[bob];
        } 
        isbob[bob]=true;
        
        int ans[]=new int[n],M=-(int)2e9;
        Arrays.fill(ans,M); 
        q.add(0); ans[0]=amount[0];
        while(!q.isEmpty()) //check for alice
        {
            int cur=q.poll();
            for(int x:g[cur])
            if(ans[x]==M)
            {
                q.add(x);
                ans[x]=ans[cur]+amount[x];  //all cases, we add the value
                if(isbob[x] && dalice[x]==dbob[x]) ans[x]-=amount[x]/2; //visiting at same time
                if(isbob[x] && dalice[x]>dbob[x]) ans[x]-=amount[x];    //visiting later
            }
        }
        
        int fin=M;
        for(i=1;i<n;i++)
        if(g[i].size()==1) fin=Math.max(fin,ans[i]);
        return fin;
    }
}
