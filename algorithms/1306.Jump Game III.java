class Solution {
    public boolean canReach(int[] a, int start) {
        int n=a.length;
        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis[start]=true;
        while(!q.isEmpty())
        {
            int p=q.poll();
            if(a[p]==0) return true;
            if(p+a[p]<n && !vis[p+a[p]]) 
            {
                vis[p+a[p]]=true;
                q.add(p+a[p]);
            }
            if(p-a[p]>=0 && !vis[p-a[p]]) 
            {
                vis[p-a[p]]=true;
                q.add(p-a[p]);
            }
        }
        return false;
    }
}
