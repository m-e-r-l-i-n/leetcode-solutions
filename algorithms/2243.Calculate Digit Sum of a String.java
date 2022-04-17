//Tamonash Chakraborty
//O(n^2)
//O(n) per round, maximum n rounds
class Solution {
    public String digitSum(String s, int k) {
        if(s.length()>k)
        {
            int i=0,n=s.length();
            StringBuilder sb=new StringBuilder();
            while(i<n)
            {
                int j=i,x=k,sum=0;
                while(j<n && x>0)
                {
                    x--;
                    sum+=s.charAt(j++)-'0';
                }
                i=j;
                sb.append(sum);
            }
            return digitSum(sb.toString(),k);   //recur with the new string
        }
        else return s;
    }
}
