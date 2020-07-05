class Solution {
    public String minInteger(String num, int k) {
        int n=num.length(),i;char a[]=num.toCharArray();
        
        for(i=0;i<n-1 && k>0; i++)
        {
            int pos=i,j;
            for(j=i+1;j<n;j++)
            {
                if(j-i>k) break;
                if(a[j]<a[pos]) pos=j;
            }
            char temp=a[pos];
            for(j=pos;j>i;j--)
            a[j]=a[j-1];
            a[i]=temp;
            k-=pos-i;
        }
        return new String(a);
    }
}
