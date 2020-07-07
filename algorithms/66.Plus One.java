class Solution {
    public int[] plusOne(int[] digits) {
        int i,n=digits.length,ans[]=new int[n+1],c=0;
        for(i=n;i>0;i--)
        {
            ans[i]=c+digits[i-1];
            if(i==n) ans[i]++;
            c=ans[i]/10;
            ans[i]%=10;
        }
        if(c!=0)
        {
            ans[i]=c;
            return ans;
        }
        else return Arrays.copyOfRange(ans,1,n+1);
    }
}
