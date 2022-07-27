class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int cr[]=new int[14],sc[]=new int[4],mr=0,ms=0;
        for(int x:ranks) 
        {
            cr[x]++;
            mr=Math.max(mr,cr[x]);
        }
        
        for(char x:suits)
        {
            sc[x-'a']++;
            ms=Math.max(ms,sc[x-'a']);
        }
        
        if(ms==5) return "Flush";
        if(mr>2) return "Three of a Kind";
        if(mr==2) return "Pair";
        return "High Card";
    }
}
