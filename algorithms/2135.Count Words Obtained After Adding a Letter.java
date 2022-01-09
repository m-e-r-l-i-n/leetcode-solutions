//Tamonash Chakraborty
//O(1) per query, O(n) preprocessing
class Solution {
    public int wordCount(String[] words1, String[] words2) {
        Set<Integer> set=new HashSet<>();
        for(String x:words1)
        {
            int k=0,i,l=x.length();
            for(i=0;i<l;i++) k|=1<<(x.charAt(i)-'a');
            set.add(k);
        }
        
        int ans=0;
        for(String x:words2)
        {
            int k=0,i,l=x.length();
            for(i=0;i<l;i++) k|=1<<(x.charAt(i)-'a');
            
            //see if removing a character, the string exists in word1
            boolean ok=false;
            for(i=0;i<26;i++)
            if(((k>>i)&1)==1)
            if(set.contains(k^(1<<i)))
            {
                ok=true;
                break;
            }
            
            if(ok) ans++;
        }
        return ans;
    }
}
