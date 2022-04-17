//Tamonash Chakraborty
//O(n)
class Solution {
    public int longestPath(int[] parent, String s) {
        int n=parent.length,i,c[]=new int[n];
        ArrayList<Integer> g[]=new ArrayList[n];
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        for(i=1;i<n;i++) g[parent[i]].add(i);
        
        ans=1;
        dfs(g,s,c,0);
        return ans;
    }
    
    int ans;
    void dfs(ArrayList<Integer> g[],String s,int c[],int n)
    {
        int max[]={0,0};
        c[n]=1;
        for(int x:g[n])
        {
            dfs(g,s,c,x);
            if(s.charAt(x)==s.charAt(n)) continue;
            c[n]=Math.max(c[n],c[x]+1);
            if(c[x]>max[0])
            {
                max[1]=max[0];
                max[0]=c[x];
            }
            else max[1]=Math.max(max[1],c[x]);
        }
        
        ans=Math.max(ans,max[0]+max[1]+1);  //path passing through node/ending at node
    }
}
