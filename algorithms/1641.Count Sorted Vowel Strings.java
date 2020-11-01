class Solution {
    public int countVowelStrings(int n) {
        int last[]=new int[5];
        Arrays.fill(last,1);
        int i=1;
        while(i<n)
        {
            i++;
            int j,k,t[]=new int[5];
            for(k=0;k<5;k++)
            for(j=k;j<5;j++)
            t[j]+=last[k];
            
            for(j=0;j<5;j++)
            last[j]=t[j];    
        }
        int ans=0;
        for(int x:last) ans+=x;
        return ans;
    }
}
