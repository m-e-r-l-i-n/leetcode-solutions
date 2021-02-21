class Solution {
    public String longestNiceSubstring(String s) {
        int i,j,n=s.length(),ax=-1,ay=-1;
        for(i=0;i<n;i++)
        for(j=i;j<n;j++)
        if(j-i+1>ay-ax+1 && nice(s,i,j)) 
        {
            ax=i; ay=j;
        }
        if(ax==-1) return "";
        return s.substring(ax,ay+1);
    }
    
    boolean nice(String s,int a,int b)
    {
        int i,u=0,v=0;
        for(i=a;i<=b;i++)
        {
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z') u|=1<<(ch-'a');
            else v|=1<<(ch-'A');
        }
        return (u^v)==0;
    }
}
