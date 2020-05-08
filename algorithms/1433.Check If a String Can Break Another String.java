class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char a[]=s1.toCharArray(),b[]=s2.toCharArray();
        Arrays.sort(a); Arrays.sort(b);
        int i,n=a.length,c=0,c2=0;
        for(i=0;i<n;i++)
        {if(a[i]>=b[i]) c++;
        if(a[i]<=b[i]) c2++;}
        if(c==n || c2==n) return true;
        else return false;
    }
}
