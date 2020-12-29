class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
        int sum=0,cur=0;
        while(sum<target)
        {
            cur++;
            sum+=cur;
        }
        while((target-sum)%2!=0)
        {
            cur++;
            sum+=cur;
        }
        return cur;
    }
}
