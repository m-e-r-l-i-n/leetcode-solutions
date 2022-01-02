//Tamonash Chakraborty
//O(n)
class Solution {
    public int maximumInvitations(int[] favorite) {
        int n=favorite.length,i;
        ArrayList<Integer> g[]=new ArrayList[n];
        int cir[]=new int[n],dep[]=new int[n];
        for(i=0;i<n;i++) 
        {
            g[i]=new ArrayList<>();
            cir[i]=dep[i]=-1;
        }
        
        boolean bad[]=new boolean[n];
        int ans=0;
        for(i=0;i<n;i++)
        {
            g[favorite[i]].add(i);  //this employee will be invited only if its favorite person is invited
            if(dep[i]!=-1)  //not visited
            continue;
            
            dep[i]=0;
            cir[i]=i;
            int j=favorite[i],prev=i;
            while(dep[j]==-1)
            {
                dep[j]=dep[prev]+1;
                cir[j]=i;
                prev=j;
                j=favorite[j];  //move along the path
            }
            
            if(prev==favorite[j])   //a<->b condition
            continue;
            if(cir[j]==i) //cycle found
            {
                bad[j]=true;    //we cannot use any node belonging or connected to cycle
                ans=Math.max(ans,dep[prev]-dep[j]+1);   //this cycle can be called
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<n;i++)
        if(bad[i]) q.add(i);
        while(!q.isEmpty()) //remove all cyclic nodes
        {
            int p=q.poll();
            for(int x:g[p])
            if(!bad[x])
            {
                bad[x]=true;
                q.add(x);
            }
        }
        
        //now we need to form chains, chains can only be of type 1->2->3<->4<-5<-6<-7
        int chain=0;
        boolean vis[]=new boolean[n];
        for(i=0;i<n;i++)
        if(!bad[i] && !vis[i])  //we can be sure that bad nodes can never be connected to good ones
        {
            if(favorite[favorite[i]]!=i) continue;  //cannot be a root
            int max=0; vis[i]=true;
            dfs(g,vis,dep,i);
            for(int x:g[i])
            if(x!=favorite[i]) max=Math.max(max,dep[x]);
            max+=dep[favorite[i]];  //we have to use favorite, for the chain
            chain+=max;
            chain++;    //the current node
        }
        ans=Math.max(ans,chain);
        return ans;
    }
    
    void dfs(ArrayList<Integer> g[],boolean vis[],int d[],int n)
    {
        d[n]=0;
        for(int x:g[n]) //deepest child in a directed tree
        if(!vis[x])
        {
            vis[x]=true;
            dfs(g,vis,d,x);
            d[n]=Math.max(d[n],d[x]);
        }
        d[n]++;
    }
}
