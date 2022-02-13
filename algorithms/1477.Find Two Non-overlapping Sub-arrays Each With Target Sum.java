class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int pre=0,n=arr.length,min[]=new int[n+1],M=(int)1e9,ans=M,i;
        
        min[0]=M; hm.put(0,0);
        for(i=1;i<=n;i++)
        {
            pre+=arr[i-1];
            min[i]=min[i-1];
            if(hm.get(pre-target)!=null)    //prefix sum
            {
                int left=hm.get(pre-target);
                min[i]=Math.min(min[i],i-left); //check if this is smallest
                ans=Math.min(ans,i-left+min[left]); //see if there is another array before it
            }
            hm.put(pre,i);
        }
        if(ans==M) ans=-1;
        return ans;
    }
}
