class Solution {
    public List<List<Integer>> fourSum(int[] nums, int t) {
        Arrays.sort(nums);
        return ksum(nums,0,4,t);
    }
    
    List<List<Integer>> ksum(int a[],int start,int k,int t) 
    {
        int n=a.length;
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(k==2) 
        { 
            int l=start,r=n-1;
            while(l<r) 
            {
                int sum=a[l]+a[r];
                if(sum==t) 
                {
                    List<Integer> tem=new ArrayList<Integer>();
                    tem.add(a[l]);
                    tem.add(a[r]);
                    ans.add(tem);
                    while(l<r && a[l]==a[l+1]) l++;
                    while(l<r && a[r]==a[r-1]) r--;
                    l++;
                    r--;
                } 
                else if(sum<t) l++;
                else r--;
            }
        } 
        else 
        {
            for(int i=start; i<=n-k;i++)
            {
                if(i>start && a[i]==a[i-1]) continue;
                List<List<Integer>> tem=ksum(a,i+1,k-1,t-a[i]);
                for(List<Integer> x:tem) x.add(0,a[i]);
                ans.addAll(tem);
            }
        }
        return ans;
    }
}
