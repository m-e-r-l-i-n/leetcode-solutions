//Tamonash Chakraborty
//O(n)
class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer> hm=new HashMap<>();    //store count;
        int n=nums.length,i;
        for(i=1;i<n;i++)
        if(nums[i-1]==key) hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        
        Queue<Integer> q=new LinkedList<>();  
        //suppose there are multiple answers, which should not be the case here
        int max=0;
        for(int x:hm.keySet())
        {
            int v=hm.get(x);
            if(v>max)
            {
                while(!q.isEmpty()) q.poll();   //clear queue
                q.add(x);
                max=v;
            }
            else if(v==max) q.add(x);
        } 
        
        if(q.isEmpty()) return -1;  //not possible unless wrong test cases 
        int ans=q.poll();
        if(!q.isEmpty()) return -1; //more than 1 answer exists, wrong test cases again
        return ans;
    }
}
