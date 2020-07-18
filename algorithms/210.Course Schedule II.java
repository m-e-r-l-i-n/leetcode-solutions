class Solution {
    public int[] findOrder(int n, int[][] pre) {
        ArrayList<Integer> g[]=new ArrayList[n];
        int i,c[]=new int[n],ans[]=new int[n],v=0;
        for(i=0;i<n;i++)
        g[i]=new ArrayList<>();
        for(i=0;i<pre.length;i++)
        {
            c[pre[i][0]]++;
            g[pre[i][1]].add(pre[i][0]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<n;i++)
        if(c[i]==0) q.add(i);    
        while(!q.isEmpty()) 
        {
            int from=q.poll();
            ans[v++]=from;
            for(int to:g[from]) 
            {
                c[to]--;
                if(c[to]==0) q.add(to);
            }
        }
        return v==n?ans:new int[0]; 
    }
}
