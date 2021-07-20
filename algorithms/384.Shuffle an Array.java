class Solution {
    int a[];
    Random r;
    public Solution(int[] nums) {
        a=nums;
        r=new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return a;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int n=a.length,b[]=new int[n],i;
        for(i=0;i<n;i++)
        {
            b[i]=a[i];
            int j=r.nextInt(i+1);
            b[i]=b[i]^b[j]^(b[j]=b[i]);
        }
        return b;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
