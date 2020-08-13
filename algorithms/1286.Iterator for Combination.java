class CombinationIterator {

    char[] cur, dic;
    boolean hasNext;
    int n;
    public CombinationIterator(String s,int l) 
    {
        cur=s.substring(0,l).toCharArray();
        dic=s.toCharArray();
        n=dic.length;
        hasNext=true;
    }
    
    public String next() 
    {
        if(!hasNext) return "";
        String res=new String(cur);
        int l=cur.length,i=l-1,j=dic.length-1;
        while(i>=0 && cur[i]==dic[j])
        {
            i--;
            j--;
        }
        if(i==-1) hasNext=false;
        else
        {
            int k,in=String.valueOf(dic).indexOf(cur[i]);
            for(k=i;k<l;k++) 
                cur[k]=dic[++in];
        }
        return res;
    }
    
    public boolean hasNext() 
    {
        return hasNext;
    }

}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
