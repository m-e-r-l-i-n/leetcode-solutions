//Tamonash Chakraborty
//O(n)
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int i,n=nums.length;
        boolean ok[]=new boolean[n];
        int j=-(int)1e9;
        for(i=0;i<n;i++)    //nearest value <=i
        {
            if(nums[i]==key) j=i;
            if(i-j<=k) ok[i]=true;
        }
        
        j=(int)1e9;
        for(i=n-1;i>=0;i--) //nearest value >=i
        {
            if(nums[i]==key) j=i;
            if(j-i<=k) ok[i]=true;
        }
        
        List<Integer> ans=new ArrayList<>();
        for(i=0;i<n;i++)
        if(ok[i]) ans.add(i);
        return ans;
    }
}
