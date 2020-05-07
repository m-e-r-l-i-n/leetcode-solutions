class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int i,j,a[]=new int[nums.length];
        int count[]=new int[101];
        for(i=0;i<nums.length;i++)
            count[nums[i]]++;
        /*let us understand this-
        5 0s 3 1s 2 2s
        originally- count[0]=5 [1]=3 [2]=2
        new- count[0]=0 [1]=5 [2]=5+3=8
        note that max will never be required as there are no greater elements than max*/
        int temp=count[0];
        count[0]=0;
        for(i=1;i<101;i++)
        {
            int temp2=count[i]; 
            count[i]=count[i-1]+temp;
            temp=temp2;
        }
        for(i=0;i<nums.length;i++)
            a[i]=count[nums[i]];
        
        return a;        
    }
}
