class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i,l=1,maxl=1;
        int st[]=new int[256];   
        if(s.equals("")) return 0;
        for(i=0;i<256;i++)
            st[i]=-1;
        st[s.charAt(0)]=0;   //first character of string is visited
        
        for(i=1;i<s.length();i++)
        {
            int index=st[s.charAt(i)];    
            if(index==-1 || (i-l)>index) 
            l++;    //if current character is not present in substring then add current value of l
            else
            {if(l>maxl) maxl=l; //if current substring length>max
            l=i-index;}
            st[s.charAt(i)]=i;   //update the index of the current character
        }
        
        if(l>maxl) maxl=l;
        return maxl;
    }
}
