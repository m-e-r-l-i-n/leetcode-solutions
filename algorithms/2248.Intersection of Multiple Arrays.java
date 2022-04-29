//Tamonash Chakraborty
//O(1000) ~ O(n)
class Solution {
    public List<Integer> intersection(int[][] nums) {
        int i,n=nums.length,c[]=new int[1001];
        for(i=0;i<n;i++)
        for(int x:nums[i]) c[x]++;   //marking that this element is present in the ith list
        
        List<Integer> ans=new ArrayList<>();
        for(i=1;i<=1000;i++)
        if(c[i]==n) ans.add(i); //only those values which have been marked every time will have this
        return ans;
    }
}
