class Solution {
    public int minOperationsMaxProfit(int[] a, int b, int r) 
    {
        int i,n=a.length,max=Integer.MIN_VALUE,maxp=-1,cur=0,m=0,rem=0,p=0;
        for(i=0;i<n;i++)
        {
            a[i]+=rem;
            m++;
            p+=Math.min(a[i],4);
            a[i]-=Math.min(a[i],4);
            rem=a[i];
            cur=p*b-m*r;
            if(cur>max)
            {
                max=cur;
                maxp=m;
            }
        }    
        
        while(rem>3)
        {
            m++;
            p+=4;
            rem-=4;
            cur=p*b-m*r;
            if(cur>max)
            {
                max=cur;
                maxp=m;
            }
        }
        p+=rem;
        m++;
        cur=p*b-m*r;
        if(cur>max) maxp=m;
        
        if(max<=0) return -1;
        else return maxp;
    }
}
