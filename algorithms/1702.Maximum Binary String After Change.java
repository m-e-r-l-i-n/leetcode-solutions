class Solution {
    public String maximumBinaryString(String binary) {
        char s[]=binary.toCharArray();
        int n=s.length,i;
        for(i=0;i<n;i++)
        if(s[i]=='0') break;
        if(i==n) return binary;
        
        int z=0,o=0,st=i;
        for(;i<n;i++)
        if(s[i]=='0') z++;
        else o++;
        for(i=st;i<n && z>0;i++,z--)
        if(z!=1) s[i]='1';
        else s[i]='0';
        for(;i<n;i++)
        s[i]='1';    
        return new String(s);
    }
}
