class Solution {
    public String shiftingLetters(String s, int[] sh) 
    {
        int i,n=sh.length;
        for(i=n-2;i>=0;i--) sh[i]=(sh[i]+sh[i+1])%26;
        StringBuilder ans=new StringBuilder();
        for(i=0;i<n;i++)
        {
            int c=s.charAt(i)-'a';
            c+=sh[i];
            c%=26;
            ans.append((char)(c+'a'));
        }
        return ans.toString();
    }
}
