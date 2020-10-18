class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int i,n=s.length(),f[][]=new int[26][2];
        for(i=0;i<26;i++)
        f[i][0]=f[i][1]=-1;
        
        for(i=0;i<n;i++)
        {
            int ch=s.charAt(i)-'a';
            if(f[ch][0]==-1) f[ch][0]=i+1;
            f[ch][1]=i+1;
        }    
        int ans=-1;
        for(i=0;i<26;i++)
        if(f[i][0]==-1 || (f[i][0]==f[i][1])) continue;
        else ans=Math.max(ans,f[i][1]-f[i][0]-1);
        return ans;
    }
}
