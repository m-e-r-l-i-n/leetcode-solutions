class Solution {
    public int longestSubarray(int[] nums, int limit) 
    {
        int l=0,ls=0,le=0,s=0,e=0;
        Deque<Integer> minQueue=new LinkedList<>();
        Deque<Integer> maxQueue=new LinkedList<>();

        while(e<nums.length) 
        {
            int x=nums[e];
            while(!minQueue.isEmpty() && nums[minQueue.peekLast()]>=x) 
            minQueue.removeLast();
            minQueue.addLast(e);

            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()]<=x) 
            maxQueue.removeLast();
            maxQueue.addLast(e);

            int minIdx=minQueue.peekFirst(),minVal=nums[minIdx],maxIdx=maxQueue.peekFirst(),maxVal=nums[maxIdx];

            if(maxVal-minVal>limit) 
            {
                s++;
                if(s>minQueue.peekFirst())
                minQueue.removeFirst();
                if (s>maxQueue.peekFirst()) 
                maxQueue.removeFirst();
            }
            else 
            {
                if(e-s+1>l) 
                {
                    l=e-s+1;
                    ls=s;
                    le=e;
                }
                e++;
            }
        }
        return l;
    }
}
