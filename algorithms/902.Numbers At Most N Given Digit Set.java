class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int s=digits.length,d[]=new int[s],i,p[]=new int[10];
        for(i=0;i<s;i++)
        d[i]=Integer.parseInt(digits[i]);
        p[0]=1;
        String no=Integer.toString(n);
        int ans=0,l=no.length();
        for(i=1;i<10;i++)
        {
            p[i]=p[i-1]*s;
            if(i<l) ans+=p[i];
        }
        
        for(i=0;i<l;i++)
        {
            int di=no.charAt(i)-'0',c=0,j; boolean eq=false;
            for(j=0;j<s;j++)
            if(d[j]<di) c++;
            else if(d[j]==di) eq=true;
            ans+=c*p[l-i-1];
            if(eq)
            {
                if(i==l-1) ans++;
            }
            else break;            
        }    
        return ans;        
    }
}
