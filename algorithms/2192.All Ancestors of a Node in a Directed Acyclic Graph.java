//Tamonash Chakraborty
//O(n*(n+m))
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int vis[]=new int[n],i,j;
        ArrayList<Integer> g[]=new ArrayList[n];
        for(i=0;i<n;i++) 
        {
            vis[i]=-1;
            g[i]=new ArrayList<>();
        }
        
        for(int x[]:edges)
        g[x[1]].add(x[0]);  //if we reverse the graph, then a node should visit all its ancestors
        
        List<List<Integer>> answer=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<n;i++)
        {
            List<Integer> ancestors=new ArrayList<>();
            q.add(i);
            vis[i]=i;
            while(!q.isEmpty()) //perform BFS
            {
                j=q.poll();
                for(int x:g[j])
                if(vis[x]!=i)
                {
                    vis[x]=i;
                    q.add(x);
                }
            }
            
            for(j=0;j<n;j++)	//find ancestors
            if(j!=i && vis[j]==i) ancestors.add(j);
            answer.add(ancestors);
        }
        return answer;
    }
}
