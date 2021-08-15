class Solution {
    public int numOfStrings(String[] p, String w) 
    {
        int i,j,ans=0,m=w.length();
        for(String s:p)
        {
            int n=s.length(),k;
            for(j=0;j<m;j++)
            {
                k=0;
                while(j+k<m && k<n && s.charAt(k)==w.charAt(j+k)) k++;
                if(k==n) {ans++; break;}
            }
        }
        return ans;
    }
}
