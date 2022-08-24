class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length(),N=26,c[]=new int[n+1];
        for(int x[]:shifts)
        {
            int add=x[2];
            if(add==0) add--;
            c[x[0]]+=add;
            c[x[1]+1]-=add;
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            if(i>0) c[i]+=c[i-1];
            c[i]=(c[i]%N+N)%N;
            int here=(c[i]+s.charAt(i)-'a')%N;
            sb.append((char)(here+'a'));
        }
        return sb.toString();
    }
}
