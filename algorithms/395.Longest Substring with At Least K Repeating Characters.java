class Solution {
    public int longestSubstring(String st, int k) {
        char s[]=st.toCharArray();
        int c[]=new int[26],h,max=0;
        for(h=1;h<=26; h++) 
        {
            Arrays.fill(c,0);
            int i=0,j=0,idx,unique=0,noLessThanK=0;
            while(j<s.length) 
            {
                if(unique<=h) 
                {
                    idx=s[j]-'a';
                    if(c[idx]==0) unique++;
                    c[idx]++;
                    if(c[idx]==k) noLessThanK++;
                    j++;
                }
                
                else 
                {
                    idx=s[i]-'a';
                    if(c[idx]==k) noLessThanK--;
                    c[idx]--;
                    if(c[idx]==0) unique--;
                    i++;
                }
                if(unique==h && unique==noLessThanK) max=Math.max(j-i,max);
            }
        }
        return max;
    }
}
