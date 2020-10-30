class Solution {
    public int maxDistToClosest(int[] seats) {
        int i,l=-1,n=seats.length,max=0;
        for(i=0;i<n;i++) 
        if(seats[i]==1) 
        {
            if(l==-1) max=i;
            else max=Math.max(max,(i-l)/2);
            l=i;
        }
        if(seats[n-1]==0) max=Math.max(max,n-1-l);
        return max;
    }
}
