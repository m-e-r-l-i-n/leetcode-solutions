class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0) return -1;
        int l=1,v=1;
        boolean c[]=new boolean[k+1];
        c[k]=true;
        while(v%k!=0)
        {
            if(c[v]) return -1;
            c[v]=true;
            v=((10*v)+1)%k;
            l++;
        }
        return l;
    }
}
