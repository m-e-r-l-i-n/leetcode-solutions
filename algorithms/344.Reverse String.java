class Solution {
    public void reverseString(char[] s) {
        int i,n=s.length;
        for(i=0;i<n/2;i++)
        {
            char temp=s[i];
            s[i]=s[n-i-1];
            s[n-i-1]=temp;
        }
    }
}
