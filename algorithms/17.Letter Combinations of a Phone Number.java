class Solution {
    public List<String> letterCombinations(String digits) {
        String s[]={"","","abc","def","ghi","jlk","mno","pqrs","tuv","wxyz"};
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        ans.add("");
        for(int i=0;i<digits.length();i++)
        {
            int j,c=digits.charAt(i)-'0';
            List<String> tem=new ArrayList<>();
            for(String st:ans)
            for(j=0;j<s[c].length();j++)
            {
                String s2=st+s[c].charAt(j);
                tem.add(s2);
            }
            ans=tem;
        }
        return ans;
    }
}
