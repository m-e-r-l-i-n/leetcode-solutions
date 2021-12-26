//Tamonash Chakraborty
//O(n^2+nlogn)=O(n^2)
class Solution {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int i,n=nums.length/2,ans[]=new int[n];
        
        Queue<Integer> pairs=new LinkedList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<2*n;i++) hm.put(nums[i],0);   //storing count
        for(i=1;i<2*n;i++)
        {
            int k=nums[i]-nums[0];
            if(k%2==1 || k==0) continue;    //difference cannot be odd or 0
            
            //see if n pairs can be formed with this k
            int j;
            while(!pairs.isEmpty()) pairs.poll();
            for(int x:hm.keySet()) hm.put(x,0);
            
            for(j=0;j<2*n;j++) hm.put(nums[j],hm.get(nums[j])+1);    //count values
            for(j=0;j<2*n;j++)  //greedily choose the pairs
            if(hm.get(nums[j])>0 && hm.get(nums[j]+k)!=null && hm.get(nums[j]+k)>0) 
            {
                //if the number isn't part of f, it will be part of g, we have to utilize this
                pairs.add(nums[j]);
                pairs.add(nums[j]+k);
                hm.put(nums[j]+k,hm.get(nums[j]+k)-1);
                hm.put(nums[j],hm.get(nums[j])-1);    
            }
            
            if(pairs.size()==2*n)   //we have an answer
            {
                j=0;
                while(j<n)
                {
                    ans[j++]=pairs.poll()+k/2;
                    pairs.poll();   //the next value
                }
                return ans;
            }
        }
        return ans; //this should never be executed
    }
}
