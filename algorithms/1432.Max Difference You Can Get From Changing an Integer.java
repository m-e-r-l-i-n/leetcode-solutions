class Solution {
    public int maxDiff(int num) 
    {
        char s[]=Integer.toString(num).toCharArray();
        int i,n=s.length,c[]=new int[10];
        char s1[]=new char[n],s2[]=new char[n],d=' ';
        
        for(i=0;i<n;i++)    //step 1
            if(s[i]!='9') {d=s[i]; break;}
        for(i=0;i<n;i++)
            if(s[i]==d) s1[i]='9';
            else s1[i]=s[i];
        d=' ';
        if(s[0]!='1') 	//step 2
        {
            d=s[0]; 
            for(i=0;i<n;i++)
                if(s[i]==d) s2[i]='1';
                else s2[i]=s[i]; 
        }
        else
        {
            for(i=1;i<n;i++)
                if(s[i]!=s[0] && s[i]>'0') {d=s[i]; break;}
            for(i=0;i<n;i++)
                if(s[i]==d) s2[i]='0';
                else s2[i]=s[i];
        }
        int a=Integer.parseInt(new String(s1)),b=Integer.parseInt(new String(s2));
        return a-b;
    }
}
