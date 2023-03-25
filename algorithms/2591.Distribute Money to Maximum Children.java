//Tamonash Chakraborty
class Solution {
    public int distMoney(int money, int n) {
        int giftees=n;
        if(money<giftees) return -1; //impossible to share
        
        int eight=0; money-=giftees;
        while(eight<giftees && money-7>=0) 
        {
            eight++;
            money-=7;   //1 has already been distributed
        }
        
        int ans=eight;
        if(eight==giftees) 
        {
            if(money>0) ans--;//additional money needs to be given to someone
        }
        else
        {
            if(money+1==4)  //bad move
            {
                if(giftees-eight==1) ans--; //we need to make sure someone takes excess 
            }
        }
        return ans;
    }
}
