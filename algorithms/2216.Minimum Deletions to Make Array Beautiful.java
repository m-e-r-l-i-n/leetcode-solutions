//Tamonash Chakraborty
//O(n)
class Solution {
    public int minDeletion(int[] nums) {
        int ans=0,index=0,prev=-1;
        for(int x:nums)
        if(index%2==0)  //we can put any value at even index
        {
            prev=x;
            index++;
        }
        else
        {
            if(x==prev) ans++;  //if current value is same as prev, we cant use it
            else {prev=x; index++;} //we use this and update index
        }
        if((nums.length-ans)%2==1) ans++;
        return ans;
    }
}
