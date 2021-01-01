class Solution {
    public int largestRectangleArea(int[] h) {
        int i=0,n=h.length,ans=0,cur;
        Stack<Integer> s=new Stack<>();
        while(i<n)
        {
            if(s.isEmpty() || h[s.peek()]<=h[i]) s.push(i++);
            else
            {
                int p=s.pop();
                cur=h[p]*(s.isEmpty()?i:i-s.peek()-1);
                ans=Math.max(ans,cur);
            }
        }
        while(!s.isEmpty())
        {
            int p=s.pop();
            cur=h[p]*(s.isEmpty()?i:i-s.peek()-1);
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
