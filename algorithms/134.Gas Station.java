class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s=gas.length-1,e=0,sum=gas[s]-cost[s];
        while(e<s)
        if(sum>=0)
        sum+=gas[e]-cost[e++];
        else 
        sum+=gas[--s]-cost[s];
        return sum>=0?s:-1;
    }
}
