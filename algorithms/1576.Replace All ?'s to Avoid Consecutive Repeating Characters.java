class Solution {
    public String modifyString(String s) {
        char c[]=s.toCharArray();
        int i,n=c.length;
        if(c[0]=='?')
        {
            if(n<2 || c[1]!='a') c[0]='a';
            else c[0]='b';
        }
        for(i=1;i<n-1;i++)
        if(c[i]=='?')
        {
            char ch=' ';
            for(int j=0;j<26;j++)
            {
                ch=(char)('a'+j);
                if(ch!=c[i-1] && ch!=c[i+1]) break;
            }
            c[i]=ch;
        }
        if(c[n-1]=='?')
        {
            if(c[n-2]=='a') c[n-1]='b';
            else c[n-1]='a';
        }
        return new String(c);    
    }
}
