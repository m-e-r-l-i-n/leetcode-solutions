class Solution {
    public String[] splitMessage(String message, int limit) {
        int len=1,parts=0,n=message.length(),max[]={10,100,1000,10000,100000};
        for(int x:max)
        {
            int l=x/10,r=Math.min(x-1,n),mid;
            //System.out.println(l+" "+r);
            while(l<=r)
            {
                mid=(l+r)>>1;
                if(possible(message,limit,mid))
                {
                    parts=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            if(parts!=0) break;
        }
        
        String ans[]=new String[parts];
        int i,j=0,d=digits(parts);
        for(i=0;i<parts;i++)
        {
            int rem=d+3+digits(i+1);
            rem=limit-rem;
            
            StringBuilder sb=new StringBuilder();
            while(j<n && rem>0) 
            {
                sb.append(message.charAt(j++));
                rem--;
            }
            sb.append("<"); sb.append(i+1); sb.append("/"); sb.append(parts+">");
            ans[i]=sb.toString();
        }
        return ans;
    }
    
    boolean possible(String s,int limit,int parts)
    {
        int i,j=0,l=digits(parts);
        for(i=1;i<=parts;i++)
        {
            int rem=l+3+digits(i);
            if(rem>=limit) return false;
            rem=limit-rem;
            
            while(j<s.length() && rem>0) {j++; rem--;}
        }
        return j==s.length();
    }
    
    int digits(int n)
    {
        int d=0;
        while(n>0)
        {
            n/=10;
            d++;
        }
        return d;
    }
}
