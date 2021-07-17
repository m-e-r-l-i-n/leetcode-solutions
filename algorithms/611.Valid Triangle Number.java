class Solution {
    public int triangleNumber(int[] a) {
        Arrays.sort(a);
        int i,ans=0;
        for(i=a.length-1;i>=2;i--)
        {
            int l=0,r=i-1;
            while(l<r) 
            {
                if(a[l]+a[r]>a[i])
                {
                    ans+=r-l;
                    r--;
                }
                else l++;
            }
        }
        return ans;
    }
}
