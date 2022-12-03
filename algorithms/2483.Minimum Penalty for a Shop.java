class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length(),i,yes=0,no=0;
        for(i=0;i<n;i++)
        if(customers.charAt(i)=='Y') yes++;
        
        int cur,ans=-1,min=n;   
        for(i=0;i<n;i++)
        {
            cur=no+yes;
            if(cur<min)
            {
                min=cur;
                ans=i;
            }
            
            if(customers.charAt(i)=='Y') yes--;
            else no++;
        }
        
        cur=no+yes;
        if(cur<min) ans=i;
        return ans;
    }
}
