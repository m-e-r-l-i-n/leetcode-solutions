class Solution {
    public List<List<Long>> splitPainting(int[][] s) 
    {
        int i,N=100000;
        Queue<Integer> q[]=new LinkedList[N+1];
        for(i=0;i<=N;i++) q[i]=new LinkedList<>();
        for(i=0;i<s.length;i++) 
        {
            q[s[i][0]].add(s[i][2]);
            q[s[i][1]].add(-s[i][2]);
        }
        
        long l=0,cur=0;
        List<List<Long>> ans=new ArrayList<>();
        for(i=1;i<=N;i++)
        {
            boolean change=q[i].size()!=0;
            if(change)
            {
                if(cur!=0)
                {
                    List<Long> ad=new ArrayList<>();
                    ad.add(l); ad.add(1l*i); ad.add(cur);
                    ans.add(ad);
                }
                l=i;   
            }
            while(!q[i].isEmpty()) cur+=q[i].poll();
        }
        return ans;
    }
}
