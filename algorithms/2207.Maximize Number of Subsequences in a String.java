//Tamonash Chakraborty
//O(n)
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int c[]={0,0},n=text.length(),i;
        long ans=0;
        for(i=0;i<n;i++)
        {
            //do both because pat[0]==pat[1] is also valid
            if(text.charAt(i)==pattern.charAt(1))	//corner case : txt="aaa",pat="aa"  	
        	{
            	c[1]++; //count number of pattern[1]s
            	ans+=c[0];  //increase ans
        	}
            //don't do else if
            if(text.charAt(i)==pattern.charAt(0)) c[0]++;   //count number of pattern[0]s
        }
        //it is optimal either to add pat[0] in the beginning, or pat[1] at the end, ans increases by count
        ans+=Math.max(c[0],c[1]);   
        return ans;
    }
}
