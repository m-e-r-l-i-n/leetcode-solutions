//Tamonash Chakraborty
//O(n) 
class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos=new ArrayList<>(),neg=new ArrayList<>();
        for(int x:nums)	//add values to lists
        if(x>0) pos.add(x);
        else neg.add(x);
        
        for(int i=0;i<nums.length;i++)
        if(i%2==0) nums[i]=pos.get(i/2);	//take the i/2 th value from list, 0/2=0, 1/2=0, 2/2=1, 3/2=1,....
        else nums[i]=neg.get(i/2);
        return nums;
    }
}
