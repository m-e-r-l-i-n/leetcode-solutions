class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        if(a==null || k<=0) return new int[0];
        int n=a.length,ans[]=new int[n-k+1],ri=0,i;

        Deque<Integer> q=new ArrayDeque<>();
        for(i=0; i<a.length; i++)
        {
            while(!q.isEmpty() && q.peek()<i-k+1) q.poll();
            while(!q.isEmpty() && a[q.peekLast()]<a[i]) q.pollLast();
            q.offer(i);
            if(i>=k-1) ans[ri++]=a[q.peek()];
        }
        return ans;
    }
}
