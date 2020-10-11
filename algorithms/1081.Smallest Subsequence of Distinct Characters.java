class Solution {
    public String smallestSubsequence(String s) {
        int c[]=new int[26];
        boolean taken[]=new boolean[26];
        
        char st[]=s.toCharArray();
        for(char i:st) c[i-'a']++;
        
        StringBuilder sb=new StringBuilder();
        sb.append('0');
        for(char i:st) 
        {
            c[i-'a']--;
            if(!taken[i-'a'])
            {
                while(sb.charAt(sb.length()-1)>i && c[sb.charAt(sb.length()-1)-'a']>0) 
                {
                    taken[sb.charAt(sb.length()-1)-'a']=false;
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(i);
                taken[i-'a']=true;
            }
        }
        return sb.substring(1).toString();
    }
}
