//Tamonash Chakraborty
//O(26*n)
class Solution {
    public List<String> removeAnagrams(String[] words) {
        int c[]=new int[26],t[]=new int[26];
        List<String> ans=new ArrayList<>();
        for(String x:words)
        {
            int i,n=x.length();
            for(i=0;i<26;i++) t[i]=0;
            for(i=0;i<n;i++) t[x.charAt(i)-'a']++;  //count frequency
            
            boolean same=true;
            for(i=0;i<26;i++)   //if this is the same as previous, no need to add it
            same&=c[i]==t[i];
            if(same) continue;
            
            ans.add(x);
            for(i=0;i<26;i++) c[i]=t[i];  
        }
        
        /*String ret[]=new String[ans.size()];
        int i=0;
        for(String x:ans) ret[i++]=x;
        return ret;*/
        return ans;
    }
}
