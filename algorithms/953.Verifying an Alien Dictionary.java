class Solution {
    public boolean isAlienSorted(String[] w, String order) {
        int i,j,c[]=new int[26],k; 
        for(i=0;i<26;i++) c[order.charAt(i)-'a']=i;
        
        for(i=0;i<w.length;i++)
        for(j=i-1;j>=0;j--)
        {
            for(k=0;k<Math.min(w[i].length(),w[j].length());k++)
            if(c[w[j].charAt(k)-'a']>c[w[i].charAt(k)-'a']) return false;
            else if(c[w[j].charAt(k)-'a']<c[w[i].charAt(k)-'a']) break;
            if(k==w[i].length() && k!=w[j].length()) return false;
        }    
        return true;
    }
    
}
