class Solution {
    public boolean canReach(String s, int min, int max) {
        int n=s.length(),c[]=new int[n+1],i;
        c[min]++; c[max+1]--;
        for(i=1;i<n;i++)
        {
            c[i]+=c[i-1];
            if(c[i]>0 && s.charAt(i)=='0') {c[Math.min(i+min,n)]++; c[Math.min(i+max+1,n)]--;}
        }
        return s.charAt(n-1)=='0' && c[n-1]>0;
    }
}
