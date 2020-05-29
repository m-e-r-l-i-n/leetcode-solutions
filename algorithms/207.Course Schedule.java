class Solution {
    public boolean canFinish(int n, int[][] pr) {
        ArrayList<Integer> g[]=new ArrayList[n];
        int i;
        for(i=0;i<n;i++)
        g[i]=new ArrayList<>();
        for(i=0;i<pr.length;i++)
        g[pr[i][0]].add(pr[i][1]);
        
        boolean vis[]=new boolean[n],exp[]=new boolean[n];
        for(i=0;i<n;i++)
        if(!vis[i])
            if(cycle(i,g,vis,exp)) return false;
        return true;
    }
    
    boolean cycle(int n,ArrayList<Integer> g[],boolean vis[],boolean exp[])
    {
        vis[n]=true;
        for(int i:g[n])
        if(!vis[i]) 
        {if(cycle(i,g,vis,exp)) return true;}
        else if(!exp[i]) return true;
        
        exp[n]=true;
        return false;
    }
}
