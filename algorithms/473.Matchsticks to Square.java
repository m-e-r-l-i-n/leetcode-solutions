class Solution {
    public boolean makesquare(int[] a) 
    {
        int i,n=a.length,sum=0;
        for(i=0;i<n;i++) sum+=a[i];
        if(sum%4!=0) return false;
        sum/=4;
        Arrays.sort(a);
        boolean v[]=new boolean[n]; 
        for(i=n-1;i>=0;i--)
        if(!v[i])
        {
            v[i]=true;
            if(!helper(i,a,v,sum-a[i])) return false;
        }
        return true;
    }
    
    boolean helper(int i, int[] a, boolean[] v, int s)
    {   
        if(s<=0) return s==0;
        while(i>=0)
        {
            if(!v[i])
            {
                v[i]=true;
                if(helper(i,a,v,s-a[i])) return true;
                v[i]=false;
            }
            i--;
        }
        return false;
    }
}
