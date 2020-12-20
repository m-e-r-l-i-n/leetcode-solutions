class Solution {
    public int maxResult(int[] a, int k) {
        int i,n=a.length,dp[]=new int[n];
        if(n==1) return a[0];
        
        dp[0]=a[0]; int max=dp[0];
        for(i=1;i<Math.min(n,k);i++)
        {
            dp[i]=max+a[i];
            max=Math.max(max,dp[i]);
        }
        if(i==n) return dp[n-1];
        
        Deque<Integer> q=new LinkedList<>();
        for(i=0;i<k;i++)
        {
            while(!q.isEmpty() && dp[i]>=dp[q.peekLast()]) q.removeLast();
            q.addLast(i);
        }    
        
        for(;i<n;i++)
        {
            max=dp[q.peek()];
            dp[i]=max+a[i];
            while(!q.isEmpty() && q.peek()<=i-k) q.removeFirst();
            while(!q.isEmpty() && dp[i]>=dp[q.peekLast()]) q.removeLast();
            q.addLast(i);
        }
        return dp[n-1];
    }
}
