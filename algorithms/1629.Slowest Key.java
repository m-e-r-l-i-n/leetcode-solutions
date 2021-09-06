class Solution {
    public char slowestKey(int[] rel, String keys) {
        int c[]=new int[26],i,n=rel.length,prev=0;
        for(i=0;i<n;i++)
        {
            c[keys.charAt(i)-'a']=Math.max(c[keys.charAt(i)-'a'],rel[i]-prev);
            prev=rel[i];
        }
        
        char ans=' '; int max=0;
        for(i=0;i<26;i++)
        if(c[i]>=max)
        {
            max=c[i];
            ans=(char)('a'+i);
        }
        return ans;
    }
}
