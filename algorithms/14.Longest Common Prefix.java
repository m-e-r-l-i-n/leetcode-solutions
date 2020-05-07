class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i;
        if(strs.length==0) return "";
        Arrays.sort(strs);
        for(i=0;i<strs[0].length();i++)
        {
            if(strs[0].charAt(i)!=strs[strs.length-1].charAt(i))
                return strs[0].substring(0,i);
        }
        return strs[0];
    }
}
