class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int p[]=new int[1010],i,max=0;
        for(i=0;i<trips.length;i++)
        {
            p[trips[i][1]]+=trips[i][0];
            p[trips[i][2]]-=trips[i][0];
            max=Math.max(max,trips[i][2]);
        }
        
        for(i=1;i<=max;i++)
        p[i]+=p[i-1];
        for(i=0;i<=max;i++)
        if(p[i]>capacity) return false;
        return true;            
    }
}
