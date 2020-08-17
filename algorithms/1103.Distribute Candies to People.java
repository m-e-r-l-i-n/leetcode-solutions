class Solution {
    public int[] distributeCandies(int candies, int n) {
        int i=0,m=0,cur=0;
        while(true)
        {
            cur+=i*n*n+n*(n+1)/2;
            if(cur>=candies) break;
            m++; i++;
        }
        
        int last=m*n,a[]=new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=n*m*(m-1)/2+m*(i+1);
            candies-=a[i];
        }
        i=0;
        while(candies!=0)
        {
            int t=Math.min(last+i+1,candies);
            a[i]+=t;
            candies-=t;
            i++;
        }
        return a;
    }
    
}
