//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<Integer> g[]=new ArrayList[n];
        int i,dp[][]=new int[n][2],M=(int)1e9;
        for(i=0;i<n;i++)
        {
            g[i]=new ArrayList<>();
            dp[i][0]=dp[i][1]=M;
        }

        for(int x[]:edges)
        {
            g[x[0]-1].add(x[1]-1);
            g[x[1]-1].add(x[0]-1);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]) return 1;
                else return -1;
            }});
        pq.add(new int[]{0,0});
        
        while(!pq.isEmpty())
        {
            int e[]=pq.poll();
            if(dp[e[0]][0]>e[1])	//the time to reach this is minimum
            {
                dp[e[0]][1]=dp[e[0]][0];
                dp[e[0]][0]=e[1];
            }
            else if(dp[e[0]][0]<e[1] && e[1]<dp[e[0]][1])	//the time to reach is >min but <2nd min 
            dp[e[0]][1]=e[1];	
            else continue;

            for(int x:g[e[0]])
            {
                int cur=e[1],v=cur;
                cur%=change*2;
                if(cur>=change) v+=2*change-cur;	//we need to wait if the signal is red
                v+=time;
                if(v<dp[x][1]) pq.add(new int[]{x,v});
            }
        }
        return dp[n-1][1];
    }
}
