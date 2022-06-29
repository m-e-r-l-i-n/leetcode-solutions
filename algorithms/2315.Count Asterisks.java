class Solution {
    public int countAsterisks(String s) {
        int ans=0,i,n=s.length();
        for(i=0;i<n;i++)
        if(s.charAt(i)=='|')
        {
            int j=i+1;
            while(j<n && s.charAt(j)!='|') j++;
            i=j;
        }
        else if(s.charAt(i)=='*') ans++;
        return ans;
    }
}
