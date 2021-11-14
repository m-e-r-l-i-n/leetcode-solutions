//Tamonash Chakraborty
//O(nlogn+restrictions*requests)
class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int p[]=new int[n],i;
        Set<Integer> g[]=new HashSet[n];
        for(i=0;i<n;i++)
        {
            p[i]=i;
            g[i]=new HashSet<>();
        }
        
        for(int x[]:restrictions)
        {
            g[x[0]].add(x[1]);  //add restrictions
            g[x[1]].add(x[0]);
        }
        
        int q=requests.length; boolean ans[]=new boolean[q];
        for(i=0;i<q;i++)
        {
            int u=requests[i][0],v=requests[i][1];
            u=parent(p,u); v=parent(p,v);
            if(u==v) {ans[i]=true; continue;}   //same group
            
            if(g[u].size()>g[v].size()) u=u^v^(v=u);
            boolean pos=true;
            for(int x:g[u]) //go through smaller set of restrictions
            if(parent(p,x)==v) {pos=false; break;}
            if(!pos) continue;
            
            p[u]=v; ans[i]=true;
            for(int x:g[u]) g[v].add(parent(p,x));  //add the restrictions
        }
        return ans;
    }
    
    int parent(int p[],int i)
    {
        if(p[i]==i) return i;
        return p[i]=parent(p,p[i]);
    }
}
