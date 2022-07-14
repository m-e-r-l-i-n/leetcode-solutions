//Tamonash Chakraborty
//O(n)
class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n=nums.length,i,l[]=new int[n],r[]=new int[n];
        Stack<Integer> s=new Stack<>();
        s.add(-1);
        for(i=0;i<n;i++)
        {
            while(s.peek()!=-1 && nums[s.peek()]>=nums[i]) s.pop();
            l[i]=s.peek();	//find prev smaller
            s.add(i);
        }
        
        while(!s.empty()) s.pop();
        s.add(n);
        for(i=n-1;i>=0;i--)
        {
            while(s.peek()!=n && nums[s.peek()]>=nums[i]) s.pop();
            r[i]=s.peek();	//find next smaller
            s.add(i);
        }
        
        for(i=0;i<n;i++)
        {
            int length=r[i]-l[i]-1;	//all values are greater in this range
            if(nums[i]>threshold/length) return length;
        }
        return -1;
    }
}
