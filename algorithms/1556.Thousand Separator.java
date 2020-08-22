class Solution {
    public String thousandSeparator(int n) {
        String s=Integer.toString(n);
        int i,tr=0;
        StringBuilder sb=new StringBuilder();
        for(i=s.length()-1;i>=0;i--)
        {
            if(tr==3) {tr=0; sb.append('.');}
            sb.append(s.charAt(i));
            tr++;
        }
        return sb.reverse().toString();
    }
}
