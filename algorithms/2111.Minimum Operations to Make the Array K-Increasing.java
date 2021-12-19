//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public int kIncreasing(int[] arr, int k) {
        int n=arr.length,i;
        ArrayList<Integer> na[]=new ArrayList[k];
        for(i=0;i<k;i++) na[i]=new ArrayList<>();
        for(i=0;i<n;i++) na[i%k].add(arr[i]);   //non overlapping chains are formed
        
        int ans=0,t[]=new int[n];
        for(i=0;i<k;i++)
        {
            ans+=na[i].size();
            ans-=lis(na[i],t);   //we remove only the values which are not a part of lis
        }
        return ans;
    }
    
    int lis(ArrayList<Integer> al,int t[])  //longest non-decreasing sequence
    {
        int sz=0; t[0]=0;
        for(int x:al)
        {
            int l=0,r=sz,m;
            while(l<r)
            {
                m=(l+r)>>1;
                if(t[m]<=x) l=m+1;  //smallest index with val <=x
                else r=m;
            }
            t[l]=x; 
            if(l==sz) sz++; //new largest value added
        }
        return sz;
    }
}
