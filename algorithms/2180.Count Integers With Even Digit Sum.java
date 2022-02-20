//Tamonash Chakraborty
//O(n*log10(n))
class Solution {
    public int countEven(int n) {
        int ans=0,i;
        for(i=1;i<=n;i++)
        {
            int sum=0,x=i;
            while(x>0)  //find sum
            {
                sum+=x%10;
                x/=10;
            }
            if(sum%2==0) ans++; //check if sum is even
        }
        return ans;
    }
}
