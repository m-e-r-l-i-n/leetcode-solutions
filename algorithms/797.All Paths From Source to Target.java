class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int i,j,n=graph.length;
        List<List<Integer>> res=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(graph,0,res,path);
        return res;
    }
    
    static void dfs(int g[][],int n,List<List<Integer>> res,ArrayList<Integer> path)
    {
        if(n==g.length-1)
        {
            res.add(new ArrayList<Integer>(path));  //creating a new copy of arraylist path
            return;
        }
        for(int x:g[n])
        {
            path.add(x);
            dfs(g,x,res,path);
            path.remove(path.size()-1);
        }
    }
}
