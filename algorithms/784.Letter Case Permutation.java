class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans=new ArrayList<>();
        ans.add("");
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            List<String> tem=new ArrayList<>();
            for(String s:ans)
            tem.add(s+ch);    
            if(ch>='a' && ch<='z')
            {
                ch=(char)(ch-32);
                for(String s:ans)
                tem.add(s+ch);
            }
            else if(ch>='A' && ch<='Z')
            {
                ch=(char)(ch+32);
                for(String s:ans)
                tem.add(s+ch);    
            }
            ans=tem;
        }    
        return ans;
    }
}
