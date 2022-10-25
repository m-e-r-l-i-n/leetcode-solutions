class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        int sum=0,max=0,i,n=nums.length;
        ArrayList<Integer> g[]=new ArrayList[n];
        for(i=0;i<n;i++) 
        {
            sum+=nums[i];
            max=Math.max(max,nums[i]);
            
            g[i]=new ArrayList<>();
        }
        for(i=0;i<n-1;i++)
        {
            g[edges[i][0]].add(edges[i][1]);
            g[edges[i][1]].add(edges[i][0]);
        }
        
        
        int ans=0;
        for(i=1;i*i<=sum;i++)
        if(sum%i==0)
        {
            if(i>=max && dfs(g,nums,0,-1,i)==0) ans=Math.max(ans,sum/i-1);
            if(sum/i!=i && sum/i>=max && dfs(g,nums,0,-1,sum/i)==0) ans=Math.max(ans,i-1);
        }
        return ans;
    }
    
    int dfs(ArrayList<Integer> g[],int nums[],int n,int p,int sum)
    {
        int add=nums[n];
        for(int x:g[n])
        if(x!=p)
        {
            int here=dfs(g,nums,x,n,sum);
            if(here==-1) return -1;
            add+=here; 
        }
        if(add>sum) return -1;
        if(add==sum) return 0;
        return add;
    }
}
