class Solution {
    public boolean arrayStringsAreEqual(String[] w1, String[] w2) {
        int i=0,wi=0,j=0,wj=0;
        while(true)
        {
            if(wi==w1.length)
            {
                if(wj==w2.length) return true;
                return false;
            }
            else if(wj==w2.length) return false;
            
            if(w1[wi].charAt(i)!=w2[wj].charAt(j)) return false;
            i++; j++;
            if(i==w1[wi].length())
            {
                i=0;
                wi++;
            }
            if(j==w2[wj].length())
            {
                j=0;
                wj++;
            }
        }
        //return false;
    }
}
