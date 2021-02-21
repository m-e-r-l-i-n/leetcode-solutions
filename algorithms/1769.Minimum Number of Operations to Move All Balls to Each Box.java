class Solution {
    public int[] minOperations(String b) {
        int n=b.length(),ans[]=new int[n],s=0,c=0,i;
        for(i=n-1;i>=0;i--)
        {
            ans[i]=s;
            if(b.charAt(i)=='1') c++;
            s+=c;
        }    
        s=0; c=0;
        for(i=0;i<n;i++)
        {
            ans[i]+=s;
            if(b.charAt(i)=='1') c++;
            s+=c;
        }
        return ans;
    }
}
