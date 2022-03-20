//Tamonash Chakraborty
//O(500), O(n^2) can pass 
class Solution {
    public boolean divideArray(int[] nums) {
        int c[]=new int[501],i;
        for(int x:nums) c[x]++;
        boolean ans=true;
        for(i=0;i<=500;i++) ans&=c[i]%2==0;
        return ans;
    }
}
