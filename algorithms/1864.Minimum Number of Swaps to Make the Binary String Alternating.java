class Solution {
    public int minSwaps(String s) {
        int n=s.length(),i,c[][]=new int[2][2];
        for(i=0;i<n;i++)
        c[i%2][s.charAt(i)-'0']++;
        if(Math.abs(c[0][0]+c[1][0]-c[0][1]-c[1][1])>1) return -1;
        
        int ans;
        if(n%2==1)
        {
            if(c[0][0]+c[1][0]>c[0][1]+c[1][1]) ans=c[0][1];
            else ans=c[0][0];
        }
        else ans=Math.min(c[0][0],c[0][1]);
        return ans;
    }
}
