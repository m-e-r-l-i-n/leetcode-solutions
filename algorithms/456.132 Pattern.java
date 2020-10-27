class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s=new Stack<>();
        int second=Integer.MIN_VALUE,i;
        for(i=nums.length-1;i>=0;i--) 
        {
            if(nums[i]<second) return true;
            while(!s.isEmpty() && nums[i]>s.peek())
                second=s.pop();
            s.push(nums[i]);
        }
        return false;
    }
}
