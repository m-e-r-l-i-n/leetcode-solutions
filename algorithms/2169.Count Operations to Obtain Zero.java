//Tamonash Chakraborty
//O(log(max(n,m)))
class Solution {
    public int countOperations(int n, int m) {
        int ans=0;
        while(n!=0 && m!=0)
        {
            if(n<m) n=n^m^(m=n);    //we are ensuring n>=m for all cases. Note that answer doesn't depend on individual variables but the values in them
            
            int d=n-m;
            int ti=d/m;
            ti++;
            ans+=ti;
            n-=ti*m;
        }
        return ans;
    }
}
