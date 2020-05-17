class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int i,time[]=new int[1002];
        for(i=0;i<startTime.length;i++)
        {
            time[startTime[i]]++;
            time[endTime[i]+1]--;
        }    
        for(i=1;i<=1001;i++)
            time[i]+=time[i-1];
        return time[queryTime];
    }
}
