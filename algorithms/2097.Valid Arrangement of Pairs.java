class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer,Integer> in=new HashMap<>(),out=new HashMap<>();
        HashMap<Integer,Stack<Integer>> g=new HashMap<>();
        
        for(int x[]:pairs)
        {
            in.put(x[1],in.getOrDefault(x[1],0)+1);
            out.put(x[0],out.getOrDefault(x[0],0)+1);
            if(g.get(x[0])==null) g.put(x[0],new Stack<>());
            g.get(x[0]).add(x[1]);
        }    
        
        Stack<Integer> dfs=new Stack<>(),ans=new Stack<>();
        //Queue<Integer> ans=new LinkedList<>();
        int st=pairs[0][0]; //eulerian cycle
        for(int x:out.keySet())
        if(out.get(x)-in.getOrDefault(x,0)==1)     //eulerian trail
        {st=x; break;}
        
        dfs.add(st);
        while(!dfs.isEmpty())
        {
            while(g.get(dfs.peek())!=null && !g.get(dfs.peek()).isEmpty()) dfs.add(g.get(dfs.peek()).pop());
            ans.add(dfs.pop());
        }
        
        int i,n=pairs.length,prev=ans.pop(),ret[][]=new int[n][2];
        for(i=0;i<n;i++)
        {
            ret[i][0]=prev;
            ret[i][1]=ans.pop();
            prev=ret[i][1];
        }
        return ret;
    }
}
