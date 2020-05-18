class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int c1[]=new int[26],c2[][]=new int[s2.length()+1][26],i,j,n=s1.length();
        for(i=0;i<n;i++)
            c1[s1.charAt(i)-'a']++;
        for(i=1;i<=s2.length();i++)
        {
            c2[i][s2.charAt(i-1)-'a']++;
            for(j=0;j<26;j++)
            c2[i][j]+=c2[i-1][j];
            if(i-n>=0)
            {
                boolean f=true;
                for(j=0;j<26;j++)
                if(c1[j]!=(c2[i][j]-c2[i-n][j])) {f=false; break;}
                if(f) return f;
            }    
        }
        return false;
    }
}
