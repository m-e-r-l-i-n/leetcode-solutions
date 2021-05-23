class Solution {
    public boolean checkZeroOnes(String s) {
        int l[]={0,0},c[]={0,0},i,cur=s.charAt(0)-'0';
        for(i=0;i<s.length();i++)
        if(s.charAt(i)-'0'==cur) c[cur]++;
        else
        {
            l[cur]=Math.max(l[cur],c[cur]);
            c[cur]=0;
            cur^=1;
            c[cur]=1;
        }
        l[cur]=Math.max(l[cur],c[cur]);
        return l[0]<l[1];
    }
}
