class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> minq=new LinkedList<>(),maxq=new LinkedList<>();
        int i,n=nums.length,j=0;
        long ans=0;
        for(i=0;i<n;i++)
        {
            while(!minq.isEmpty() && nums[minq.peekLast()]>=nums[i]) minq.pollLast();
            minq.addLast(i);
            while(!maxq.isEmpty() && nums[maxq.peekLast()]<=nums[i]) maxq.pollLast();
            maxq.addLast(i);
            
            while(i>j && nums[maxq.peekFirst()]-nums[minq.peekFirst()]>2)
            {
                j++;
                while(!minq.isEmpty() && minq.peekFirst()<j) minq.pollFirst();
                while(!maxq.isEmpty() && maxq.peekFirst()<j) maxq.pollFirst();
            }
            ans+=i-j+1;
        }
        return ans;
    }
}
