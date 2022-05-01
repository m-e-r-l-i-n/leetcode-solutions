//Tamonash Chakraborty
//O(n^3)
class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<ArrayList<Integer>> set=new HashSet<>();
        int i,j,n=nums.length;
        for(i=0;i<n;i++)    //brute force checking using sets
        {
            ArrayList<Integer> te=new ArrayList<>();
            int div=0;
            for(j=i;j<n;j++)
            {
                te.add(nums[j]);
                if(nums[j]%p==0) div++;
                if(div>k) break;
                set.add(new ArrayList<>(te));    //this line is O(n)
            }
        }
        return set.size();
    }
}
