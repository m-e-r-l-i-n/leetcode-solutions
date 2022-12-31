//Tamonash Chakraborty
//O(n)
class Solution {
    public int captureForts(int[] forts) {
        int ans=0,i,n=forts.length,enemy=0;
        boolean empty=false;
        for(i=0;i<n;i++)
        if(forts[i]==0) enemy++;
        else
        {
            if(forts[i]==1 && empty) 
            {
                ans=Math.max(ans,enemy);
                empty=false;
            }
            if(forts[i]==-1) empty=true;
            enemy=0;
        }
        
        empty=false;
        enemy=0;
        for(i=n-1;i>=0;i--)
        if(forts[i]==0) enemy++;
        else
        {
            if(forts[i]==1 && empty) 
            {
                ans=Math.max(ans,enemy);
                empty=false;
            }
            if(forts[i]==-1) empty=true;
            enemy=0;
        }
        return ans;
    }
}
