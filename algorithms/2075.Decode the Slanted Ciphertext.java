//Tamonash Chakraborty
//O(n)
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int l=encodedText.length(),cols=l/rows;
        StringBuilder sb=new StringBuilder();
        
        int i,space=0; char c;
        //space is necessary for adding spaces before character
        for(i=0;i<cols;i++)
        {
            int x=0,y=i;	//starting point of every slanting row 
            while(x<rows && y<cols)
            {
                c=encodedText.charAt(x*cols+y);
                if(c==' ') space++;
            	else
                {
                    while(space-->0) sb.append(' ');
                    sb.append(c);
                    space=0;
                }
                x++; y++;
            }
            //note that we will not append the spaces after the last character
        }
        return sb.toString(); 	//stringbuilder is a bit faster than normal strings
    }
}
