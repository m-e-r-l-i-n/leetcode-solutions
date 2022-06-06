//Tamonash Chakraborty
//O(n) where n=s.length()
class Solution {
    public int rearrangeCharacters(String s, String target) {
        int i,cs[]=new int[26];
        //count number of times each letter occurs in s 
        for(i=0;i<s.length();i++)   cs[s.charAt(i)-'a']++;
        
        int ct[]=new int[26];   //do the same for target
        for(i=0;i<target.length();i++) ct[target.charAt(i)-'a']++;
        
        int ans=s.length();
        for(i=0;i<26;i++)
        if(ct[i]!=0)    //we need values
        ans=Math.min(ans,cs[i]/ct[i]);  //if target needs ct[i], we can get atmost cs[i]/ct[i] copies
        //now we need to find minimum amongst them
        return ans;
    }
}
