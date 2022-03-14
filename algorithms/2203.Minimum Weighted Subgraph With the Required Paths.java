//Tamonash Chakraborty
//O(nlog(n))
class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        long dp1[]=new long[n],dp2[]=new long[n],dp3[]=new long[n];
        ArrayList<int[]> g[]=new ArrayList[n],rg[]=new ArrayList[n];
        int i;
        for(i=0;i<n;i++)    //we need graph, reverse graph, and 3 distinct dp arrays
        {
            g[i]=new ArrayList<>();
            rg[i]=new ArrayList<>();
            dp1[i]=dp2[i]=dp3[i]=M;
        }
        
        for(int x[]:edges)  //create graph and reverse graph
        {
            g[x[0]].add(new int[]{x[1],x[2]});
            rg[x[1]].add(new int[]{x[0],x[2]});
        }
        
        dijkstra(g,dp1,src1);   //find minimum weight path to every node from src1
        dijkstra(g,dp2,src2);   //find minimum weight path to every node from src2
        dijkstra(rg,dp3,dest);  //find minimum weight path to every node from dest(in reverse graph)
        
        long ans=M;
        //the optimal graph will have a set of edges common for both paths, and some which are not common
        //dp3[i] stores the common path while dp1 and dp2 are non intersecting
        for(i=0;i<n;i++)
        ans=Math.min(ans,dp1[i]+dp2[i]+dp3[i]);
        if(ans==M) ans=-1;
        return ans;
    }
    
    long M=(long)1e11;
    void dijkstra(ArrayList<int[]> g[],long dp[],int src)   //perform dijkstra's algorithm
    {
        dp[src]=0;
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>(){
           public int compare(long o1[],long o2[])
           {
               if(o1[0]>o2[0]) return 1;
               else return -1;
           }});
        
        pq.add(new long[]{0,src});
        while(!pq.isEmpty())
        {
            long e[]=pq.poll();
            int i=(int)e[1];    //the current node
            if(dp[i]<e[0]) continue;
            
            dp[i]=Math.min(dp[i],e[0]);
            for(int x[]:g[i])
            {
                long v=e[0]+x[1];
                if(v>=dp[x[0]]) continue;
                dp[x[0]]=v;
                pq.add(new long[]{v,x[0]});
            }    
        }
    }
}
