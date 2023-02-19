class Solution {
    public int minOperations(int n) {
        int i,c[]=new int[30];
        for(i=0;i<30;i++) c[i]=(n>>i)&1;
        
        int ans=0;
        for(i=0;i<30;i++)
        if(c[i]==1)
        {
            int j=i;
            while(j<30 && c[j]==1) j++;
            
            int ones=j-i;
            ans++;
            if(ones!=1) {c[j]=1; i=j-1;}
        }
        return ans;
    }
}
