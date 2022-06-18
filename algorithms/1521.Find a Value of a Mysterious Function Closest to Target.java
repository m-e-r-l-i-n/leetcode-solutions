class Solution {
    public int closestToTarget(int[] arr, int target) {
        int n=arr.length,c[][]=new int[n+1][25],prev[][]=new int[n+1][25];
        int i,j;
        for(i=1;i<=n;i++)
        for(j=0;j<25;j++)
        {
            prev[i][j]=prev[i-1][j];
            c[i][j]=c[i-1][j];
            if(((arr[i-1]>>j)&1)==1) c[i][j]++;
            else prev[i][j]=i;
        }
        
        int ans=Math.abs(-1000000000-target);
        Set<Integer> pos=new HashSet<>();
        for(i=1;i<=n;i++)
        {
            pos.clear();
            for(j=0;j<25;j++)
            {
                if(prev[i][j]!=0) pos.add(prev[i][j]);
                if(prev[i][j]+1<=i) pos.add(prev[i][j]+1);
            }    
            
            for(int x:pos)
            {
                int cur=0;
                for(j=0;j<25;j++)
                if(c[i][j]-c[x-1][j]==i-x+1) cur|=1<<j;
                ans=Math.min(ans,Math.abs(cur-target));
            }
        }
        return ans;
    }
}
