//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n=nums1.length,i,pos[]=new int[n];
        long bit[][]=new long[2][n+1],ans=0;
        for(i=0;i<n;i++) pos[nums2[i]]=i;
        
        for(i=0;i<n;i++)
        {
            long small=query(bit[0],pos[nums1[i]]); //number of pairs with same order
            update(bit[0],pos[nums1[i]],1,n);
            ans+=query(bit[1],pos[nums1[i]]);   //triplets ending here
            update(bit[1],pos[nums1[i]],small,n);
        }
        return ans;
    }
    
    void update(long bit[],int i,long v,int n)
    {
        i++;
        while(i<=n)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }
    
    long query(long bit[],int i)
    {
        long s=0;
        i++;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}
