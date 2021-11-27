//Tamonash Chakraborty
//O(n)
class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> ha=fill(words1),hb=fill(words2);
    	int ans=0;
        for(String s:ha.keySet())
        if(ha.get(s)==1 && hb.getOrDefault(s,0)==1) ans++;
        return ans;
    }
    
    HashMap<String,Integer> fill(String a[])
    {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:a) hm.put(s,hm.getOrDefault(s,0)+1);
        return hm;
    }
}
