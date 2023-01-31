/*
Tamonash Chakraborty
O(log(max(x,y)))
based on nskybytskyi's solution
we have a state(x,y) where x and y are odd
[we consider dividing by 2 for even to reduce numbers as much as possible]
now say gcd(x,y)=g > 1
(x,y) can be obtained from (x,y+x) or (x+y,y)
this means if after those division operations, we will still get stuck on a state (x',y') where gcd(x',y') will be at least g
so we just check if gcd is 1 after removing all 2s
*/
class Solution {
    public boolean isReachable(int x, int y) {
        int t;
        while(x%2==0) x/=2;	//making numbers odd
        while(y%2==0) y/=2;
        
        while(y!=0)	//calculating gcd
        {
            t=y;
            y=x%y;
            x=t;
        }
        return x==1;
    }
}
