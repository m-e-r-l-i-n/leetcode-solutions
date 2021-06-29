class Solution {
    public String removeDuplicates(String s) {
        int i,n=s.length(),p=-1; char ans[]=new char[n];
        for(i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(p!=-1 && ans[p]==c) p--;
            else ans[++p]=c;
        }
        return new String(ans,0,p+1);
    }
}
