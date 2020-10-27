class Solution {
    public int bagOfTokensScore(int t[], int p) 
    {
        Arrays.sort(t);
        int max=0,s=0,l=0,r=t.length-1;
        while(l<=r) 
        {
            if(p>=t[l]) 
            {
                p-=t[l++];
                s++;
                max=Math.max(max,s);
            } 
            else if(s>0) 
            {
                p+=t[r--];
                s--;
            } 
            else break;
        }
        return max;
    }
}
