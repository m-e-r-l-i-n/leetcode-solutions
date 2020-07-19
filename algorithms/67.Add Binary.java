class Solution {
    public String addBinary(String a, String b) {
        int n=a.length(),m=b.length();
        StringBuilder sb=new StringBuilder();
        int c=0,i=n-1,j=m-1,x,y,cur;
        while(i>=0 && j>=0)
        {
            x=a.charAt(i--)-'0';y=b.charAt(j--)-'0';
            cur=x+y+c;
            sb.append(cur%2);
            c=cur/2;
        }
        
        while(i>=0)
        {
            x=a.charAt(i--)-'0';
            cur=x+c;
            sb.append(cur%2);
            c=cur/2;
        }
        while(j>=0)
        {
            y=b.charAt(j--)-'0';
            cur=y+c;
            sb.append(cur%2);
            c=cur/2;
        }
        if(c!=0) sb.append(c);
        return sb.reverse().toString();
    }
}
