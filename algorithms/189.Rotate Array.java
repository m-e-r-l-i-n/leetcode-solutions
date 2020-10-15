class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        reverse(nums,0,n-1); // reverse full array
        reverse(nums,0,k-1); // reverse first k elements
        reverse(nums,k,n-1); // reverse remaining n - k elements after k
    }

	void reverse(int a[],int s,int e) 
    {
        while(s<e) 
        {
            int t=a[s];
            a[s++]=a[e];
            a[e--]=t;
        }
    }
}
