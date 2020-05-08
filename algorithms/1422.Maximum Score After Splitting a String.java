class Solution {
    public int maxScore(String s) {
        int n=s.length(),ze=0,on=0,z[]=new int[n],o[]=new int[n],i;
        for(i=0;i<n;i++)
        {if(s.charAt(i)=='0') ze++;
        z[i]=ze;}
        for(i=n-1;i>=0;i--)
        {if(s.charAt(i)=='1') on++;
        o[i]=on;}
        int max=0;
        for(i=0;i<n-1;i++)
            if(z[i]+o[i+1]>max) max=z[i]+o[i+1];
        return max;
    }
}
