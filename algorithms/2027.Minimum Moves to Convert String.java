//Tamonash Chakraborty
//O(n)
class Solution {
    public int minimumMoves(String s) {
        int i,n=s.length();
        int count=0;	//counts number of moves needed
        for(i=0;i<n;i++)
        if(s.charAt(i)=='X')	//change needed
        {
            count++;
            i+=2;	//the next 2 segments have already been changed
        }
        return count;
    }
}
