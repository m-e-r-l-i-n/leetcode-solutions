class Solution {
    public int numSub(String s) {
        int i,c=0; long ans=0,M=1000000007;
        for(i=0;i<s.length();i++)
        if(s.charAt(i)=='1') c++;
        else
        {
            ans+=1l*c*(c+1)/2;
            c=0;
            ans%=M;
        }
        ans+=1l*c*(c+1)/2;
        ans%=M;
        return (int)ans;
    }
}
