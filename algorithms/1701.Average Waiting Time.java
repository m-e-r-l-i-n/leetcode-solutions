class Solution {
    public double averageWaitingTime(int[][] c) {
        double tot=0;
        int i,n=c.length,last=0;
        for(i=0;i<n;i++)
        {
            int wait=0;
            if(last>c[i][0]) 
            {
                wait=last-c[i][0];
                c[i][0]=last;
            }
            wait+=c[i][1];
            tot+=wait;
            last=c[i][0]+c[i][1];
        }
        return tot/n;
    }
}
