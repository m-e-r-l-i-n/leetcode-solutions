class NumArray {
    int bit[],n,a[];
    public NumArray(int[] nums) {
        n=nums.length;
        bit=new int[n+1];
        a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=nums[i];
            update(i,a[i],n);
        }    
    }
    
    public void update(int i, int v) {
        int ch=v-a[i];
        a[i]=v;
        update(i,ch,n);
    }
    
    public int sumRange(int left, int right) {
        return query(right)-query(left-1);
    }
    
    void update(int i,int v,int n)
    {
        i++;
        while(i<=n)
        {
            bit[i]+=v;
            i+=i&-i;
        }
    }
    
    int query(int i)
    {
        i++;
        int s=0;
        while(i>0)
        {
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
