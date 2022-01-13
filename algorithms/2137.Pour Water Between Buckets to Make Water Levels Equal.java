//Tamonash Chakraborty
//O(n*log(max(buckets[i]*1e9)))
class Solution {
    public double equalizeWater(int[] buckets, int loss) {
        int n=buckets.length,i;
        long a[]=new long[n],M=(int)1e9;
        for(i=0;i<n;i++) a[i]=M*buckets[i];   //to remove % cases
        
        int use=100-loss;    //amount of water that can be utilized 
        long l=1,r=(long)1e15,mid,ans=0;
        while(l<=r) //perform binary search
        {
            mid=(l+r)>>1;
            if(possible(a,mid,use)) //check if each bucket can have atleast mid litres
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans/(1.0*M); //since we had worked on multiplied values, we divide them
    }
    
    boolean possible(long a[],long m,int use)
    {
        int i,n=a.length;
        long ex=0;
        for(i=0;i<n;i++)
        if(a[i]>m) ex+=(a[i]-m)*use/100;    //we have used large values to allow integral division
        
        for(i=0;i<n;i++)
        if(a[i]<m)
        {
            ex-=m-a[i];
            if(ex<0) return false;
        }
        return true;
    }
}
