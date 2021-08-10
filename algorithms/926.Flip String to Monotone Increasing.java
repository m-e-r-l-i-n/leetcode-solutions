class Solution {
    public int minFlipsMonoIncr(String s) {
        int n=s.length(),z=0,o=0,i;
        for(i=0;i<n;i++)
        if(s.charAt(i)=='0') z++;
        else o++;
        
        int cz=0,co=0,ans=Math.min(z,o);
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='0') cz++;
            else co++;
            ans=Math.min(ans,co+(z-cz));
        }
        return ans;
    }
}
