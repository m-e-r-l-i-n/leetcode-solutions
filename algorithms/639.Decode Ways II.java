class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        long a[]={s.charAt(0)=='*'?9:1,1},M=(int)1e9+7;
        int i;
        for(i=1;i<s.length();i++)
        {
            long cur=a[0];
            char c1=s.charAt(i),c2=s.charAt(i-1);
            if(c1=='0')
            {
                if(c2!='*' && c2!='1' && c2!='2') return 0;
                cur=a[1];
                if(c2=='*') cur*=2;
                //a[1]=a[0];
                a[0]=cur%M;
                continue;
            }
            
            if(c1=='*') cur=cur*9%M;
            if(c2=='0')
            {
                a[1]=a[0];
                a[0]=cur%M;
                continue;
            }
            
            if(c1=='*' && c2=='*') cur+=a[1]*15%M;
            else if(c1=='*')
            {
                if(c2=='1') cur+=a[1]*9%M;
                else if(c2=='2') cur+=a[1]*6%M;
            }
            else if(c2=='*')
            {
                if(c1<='6') cur+=a[1]*2%M;
                else cur+=a[1];
            }
            else 
            {
                int v=(c2-'0')*10+(c1-'0');
                if(v<=26) cur+=a[1];
            }
            a[1]=a[0];
            a[0]=cur%M;
        }
        return (int)a[0];
    }
}
