class Solution {
    public int[] shortestToChar(String s, char c) {
        int n=s.length(),a[]=new int[n],i,cur=n+1;
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)==c) cur=0;
            a[i]=cur++;
        }
        cur=n+1;
        for(i=n-1;i>=0;i--)
        {
            if(s.charAt(i)==c) cur=0;
            a[i]=Math.min(a[i],cur);
            cur++;
        }    
        return a;
    }
}
