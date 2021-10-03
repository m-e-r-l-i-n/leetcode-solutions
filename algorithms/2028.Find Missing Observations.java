//Tamonash Chakraborty
//O(n)
class Solution {
    public int[] missingRolls(int[] r, int mean, int n) {
        int sum=0,i,m=r.length;
        for(i=0;i<m;i++) sum+=r[i];
        mean*=(n+m);
        
        if(sum+n>mean || sum+6*n<mean) return new int[0];
        int ans[]=new int[n];
    	sum=mean-sum;
        int val=sum/n;
        for(i=0;i<n;i++) ans[i]=val;
        val=sum%n;
        for(i=0;i<val;i++) ans[i]++;
        return ans;
    }
}
