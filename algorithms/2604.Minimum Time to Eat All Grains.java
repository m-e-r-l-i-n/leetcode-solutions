//Tamonash Chakraborty
//O(nlog(max))
class Solution {
    public int minimumTime(int[] hens, int[] grains) {
        Arrays.sort(hens);
        Arrays.sort(grains);
        int l=0,r=(int)2e9,mid,ans=r;
        while(l<=r)
        {
            mid=l+(r-l)/2;
            if(possible(hens,grains,mid))
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    
    boolean possible(int hens[],int grains[],int mid)
    {
        int i,j=0,n=hens.length,m=grains.length;
        Stack<Integer> st=new Stack<>();
        for(i=0;i<n;i++)
        {
            while(j<m && grains[j]<=hens[i]) st.add(grains[j++]);
            int last=hens[i];
            while(!st.isEmpty() && hens[i]-st.peek()<=mid)
            last=st.pop();
                
            int mv=hens[i]-last;  //maximum left
            if(!st.isEmpty()) return false; //we need to clear all left
            
            
            while(j<m) 
            {
                int cost1=grains[j]-hens[i],cost2=cost1;
                cost1=cost1*2+mv; cost2+=mv*2;
                if(Math.min(cost1,cost2)<=mid)
                j++;
                else break;
            }
        }
        return j==m;
    }
}
