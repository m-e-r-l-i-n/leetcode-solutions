//Tamonash Chakraborty
//O(n^2)
class Solution {
    public int triangularSum(int[] nums) {
        int i,j,n=nums.length,rows[][]=new int[2][n],cur=1;
        for(i=0;i<n;i++) rows[0][i]=nums[i];
        
        for(i=1;i<n;i++)
        {
            for(j=0;j<n-i;j++)
            rows[cur][j]=(rows[cur^1][j]+rows[cur^1][j+1])%10;	//fill current row with values of previous row
            cur^=1;	//we are reusing space
        }
        return rows[cur^1][0];
    }
}
