class Solution {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int i,n=s.length,maxs=0,neg=0;
        for(i=0;i<n;i++)
        {
            if(s[i]<=0) neg++;
            maxs+=(i+1)*s[i];            
        }    
        if(neg==0) return maxs;
        else if(neg==n) return 0;
        for(i=0;i<n;i++)
        {
            int j,k=1,sum=0;
            for(j=i+1;j<n;j++)
            sum+=s[j]*(k++);
            if(sum>maxs) maxs=sum;
            else break;
        }
        return maxs;
    }
}
