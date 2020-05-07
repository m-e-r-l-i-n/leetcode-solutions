class Solution {
    public int search(int[] nums, int target) {
        return find(nums,target,0,nums.length-1);
    }
    
    int find(int a[],int k,int l,int r)
    {
        if(l>r) return -1;
        int m=l+(r-l)/2;
        if(a[m]==k) return m;
        else return Math.max(find(a,k,l,m-1),find(a,k,m+1,r));
    }
}
