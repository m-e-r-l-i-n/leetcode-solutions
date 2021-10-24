//Tamonash Chakraborty
//O(n)
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int min[]=new int[n],i,c[]=new int[n];
        ArrayList<Integer> g[]=new ArrayList[n];	//store graph
        for(i=0;i<n;i++)
        {
            g[i]=new ArrayList<>();
            min[i]=-1;
        }
        
        for(i=0;i<relations.length;i++)
        {
            g[relations[i][0]-1].add(relations[i][1]-1);
            c[relations[i][1]-1]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<n;i++)
        if(c[i]==0)
        {
            min[i]=time[i];	//they can be started at the same time
            q.add(i);
        }
        
        while(!q.isEmpty())		//perform topological sort
        {
            i=q.poll();
            for(int x:g[i])
            {
                c[x]--;
                min[x]=Math.max(min[x],min[i]+time[x]);	
                //time taken to complete course will be max(dependencies)+current time
                if(c[x]==0) q.add(x);
            }
        }
        
        int ans=0;
        for(i=0;i<n;i++)
        if(min[i]==-1) return -1;	//if testcases and soln are correct, this should never be executed
        else ans=Math.max(ans,min[i]);
        return ans;
    }
}
