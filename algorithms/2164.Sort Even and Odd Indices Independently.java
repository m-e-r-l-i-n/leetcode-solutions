//Tamonash Chakraborty
//O(nlog(n))
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int n=nums.length,i;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        //sort even in ascending order
        for(i=0;i<n;i+=2) pq.add(nums[i]);
        for(i=0;i<n;i+=2) nums[i]=pq.poll();
        
        //sort odd in descending order
        for(i=1;i<n;i+=2) pq.add(nums[i]);
        i-=2;
        for(;i>=0;i-=2) nums[i]=pq.poll();
        return nums;
    }
}
