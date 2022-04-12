//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n=flowers.length,i;
        long ans=0,prefix[]=new long[n];
        Arrays.sort(flowers);
        for(i=0;i<n;i++)    //number of flowers in the smallest (i+1) gardens
        {
            prefix[i]=flowers[i];
            if(i>0) prefix[i]+=prefix[i-1];
        }
        
        for(i=n;i>=0;i--)   //do from n because there may be cases every garden is incomplete
        {
            if(i<n && target-flowers[i]>newFlowers) break; //we can't do anything anymore
            int ded=0;
            if(i<n) ded=Math.max(target-flowers[i],0);  //make all gardens >=i full 
            newFlowers-=ded;
            long cur=1l*full*(n-i);
            ans=Math.max(ans,cur);  //just consider the case there are no partial gardens
            
            int l=0,r=i-1,mid,ind=-1;    
            //find the largest index upto which we can make all values equal to it using newFlowers
            while(l<=r)
            {
                mid=(l+r)>>1;
                if(1l*(mid+1)*flowers[mid]-prefix[mid]<=newFlowers && flowers[mid]<target)  //if flowers[i]>target, they won't be partial
                {
                    ind=mid;
                    l=mid+1;
                }
                else r=mid-1;
            }
            if(ind<0) continue; //we can't do anything here
            
            long nf=newFlowers;
            nf-=1l*(ind+1)*flowers[ind]-prefix[ind];
            long minimum=flowers[ind];  //the maximum minima attainable
            minimum+=nf/(ind+1);
            cur+=Math.min(minimum,target-1)*partial;    //note that we will consider unfinished gardens only
            //System.out.println(cur);
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
