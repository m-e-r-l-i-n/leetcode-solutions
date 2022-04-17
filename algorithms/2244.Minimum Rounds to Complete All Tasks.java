//Tamonash Chakraborty
//O(n)
class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> count=new HashMap<>();
        for(int x:tasks)
        count.put(x,count.getOrDefault(x,0)+1);
        
        int ans=0;
        for(int x:count.values())   //we only need the values
        {
            int mod=x%3;
            ans+=x/3;
            if(mod==1) 
            {
                if(x/3==0)  //only 1 value present of this type
                return -1;
                ans++;  //we have at least 4, so we use 2+2
            }
            else if(mod==2) ans++;  //we pick 2 
        }
        return ans;
    }
}
