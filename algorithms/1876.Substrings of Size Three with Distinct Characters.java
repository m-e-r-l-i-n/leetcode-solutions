class Solution {
    public int countGoodSubstrings(String s) {
        int i,n=s.length(),ans=0;
        for(i=0;i+2<n;i++)
        {
            char c1=s.charAt(i),c2=s.charAt(i+1),c3=s.charAt(i+2);
            if(c1!=c2 && c2!=c3 && c1!=c3) ans++;
        }    
        return ans;
    }
}
