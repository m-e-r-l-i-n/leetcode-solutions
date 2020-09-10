class Solution {
    public String getHint(String secret, String guess) {
        int i,a=0,b=0,ca[]=new int[10],cb[]=new int[10],n=secret.length();
        for(i=0;i<n;i++)
        {
            if(secret.charAt(i)==guess.charAt(i)) {a++; continue;}
            ca[secret.charAt(i)-'0']++;
            cb[guess.charAt(i)-'0']++;
        }
        
        for(i=0;i<10;i++)
        b+=Math.min(ca[i],cb[i]);
        StringBuilder sb=new StringBuilder();
        sb.append(a); sb.append('A');
        sb.append(b); sb.append('B');
        return sb.toString();
    }
}
