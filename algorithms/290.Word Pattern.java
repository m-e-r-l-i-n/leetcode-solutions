class Solution {
    public boolean wordPattern(String pattern, String str) {
        String s[]=str.split(" ");
        if(pattern.length()!=s.length) return false;
        Map m=new HashMap();
        for(Integer i=0;i<s.length;++i)
        if(m.put(pattern.charAt(i),i)!=m.put(s[i],i)) return false;
        return true;
    }
}
