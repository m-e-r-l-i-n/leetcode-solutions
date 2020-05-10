class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int i;
        ArrayList<Integer>[] al=new ArrayList[n];
        ArrayList<Integer> tr=new ArrayList<>();
        for(i=0;i<edges.length;i++)
        {
            if(al[edges[i][0]]==null) al[edges[i][0]]=new ArrayList<>();
            al[edges[i][0]].add(edges[i][1]);
            if(al[edges[i][1]]==null) al[edges[i][1]]=new ArrayList<>();
            al[edges[i][1]].add(edges[i][0]);
        }
        boolean visited[]=new boolean[n];
        dfs(al,0,n,hasApple,visited);
        return time;
    }
    int time=0;
    
    int dfs(ArrayList<Integer> g[], int curr, int n, List<Boolean> hasApple, boolean[] visited) {
        if(visited[curr]) return 0;
        int count=hasApple.get(curr)?1:0,i;
        visited[curr]=true;
        for(i=0;i<g[curr].size();i++) 
        {
            time+=2;
            int apples=dfs(g,g[curr].get(i),n,hasApple,visited);
            if(apples==0) time-=2;
            count+=apples;
        }
        return count;
    }
}
