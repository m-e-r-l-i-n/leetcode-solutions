//Tamonash Chakraborty
//O(n*factors(k)) ~ O(n*pow(k,1/3))
class Solution {
    public long coutPairs(int[] nums, int k) {
        HashMap<Integer,Integer> f=new HashMap<>(); //store count of factors
        int i;
        for(i=1;i*i<=k;i++) //get factors
        if(k%i==0)
        {
            f.put(i,0);
            if(k/i!=i) f.put(k/i,0);
        }
        
        long ans=0;
        for(int x:nums)
        {
            int t,g=x,b=k;
            while(b!=0)
            {
                t=b;
                b=g%b;
                g=t;
            }
            //g is gcd of (x,k) 
            //we need to know what we should multiply this with such that product is div by k
            ans+=f.get(k/g);
            for(int y:f.keySet()) 
            if(x%y==0) f.put(y,f.get(y)+1);  //all these are factors of x as well
        }
        return ans;
    }
}
