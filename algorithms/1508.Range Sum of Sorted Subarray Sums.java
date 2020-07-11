class Solution {
    public int rangeSum(int[] nums, int n, int l, int r) {
        int s[]=new int[n+1],sum=0,i,j;
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
            s[i+1]=sum;
        }
        ArrayList<Integer> al=new ArrayList<>();
        for(i=1;i<=n;i++)
        for(j=i;j<=n;j++)
        al.add(s[j]-s[i-1]);
        
        Collections.sort(al);
        sum=0;
        for(i=l-1;i<r;i++)
        sum+=al.get(i);
        
        return sum;
    }
}
