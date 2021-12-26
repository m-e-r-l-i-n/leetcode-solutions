//Tamonash Chakraborty
//O(words*len of words)
class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans=0;
        for(String s:sentences)
        {
            if(s.length()==0) continue; //will count this as 1 in split
            String st[]=s.split(" ");	//splitting text into words
            ans=Math.max(ans,st.length);
        }
        return ans;
    }
}
