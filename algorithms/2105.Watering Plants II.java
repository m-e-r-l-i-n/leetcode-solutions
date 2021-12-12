//Tamonash Chakraborty
//O(n)
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n=plants.length,l=0,r=n-1,ans=0,ca=capacityA,cb=capacityB;
        while(l<r)  //we move as long as they don't coincide
        {
            if(ca<plants[l])    //we need refill
            {
                ca=capacityA;
                ans++;
            }
            if(cb<plants[r])    //we need refill
            {
                cb=capacityB;
                ans++;
            }
            ca-=plants[l++];
            cb-=plants[r--];
        }
        if(l==r)    //if they reach same place together
        {
            ca=Math.max(ca,cb);
            if(ca<plants[l]) ans++;
        }
        return ans;
    }
}
