import java.util.*;

class NumArray {
    //ArrayList<Integer> sums=new ArrayList<>();
    int sums[]=new int[100000];
    public NumArray(int[] nums) {
        sums[0]=0;
        int sum=0,i;
        for(i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            sums[i+1]=sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i]; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
