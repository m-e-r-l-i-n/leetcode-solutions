class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int n=s.length(),ans=0;
        char c[]=s.toCharArray();
        while(true)
        {
            boolean change=false;
            int i;
            for(i=0;i+1<n;i++)
            if(c[i]=='0' && c[i+1]=='1')
            {
                c[i]='1';
                c[i+1]='0';
                i++;
                change=true;
            }
            if(!change) break;
            ans++;
        }
        return ans;
    }
}
