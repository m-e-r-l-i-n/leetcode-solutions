//Tamonash Chakraborty
//O(n)
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length(),l=n/k;
        if(n%k!=0) l++;
        String ans[]=new String[l];
        
        int i,j;
        for(i=0;i<l;i++)
        {
            ans[i]="";
            for(j=0;j+i*k<Math.min(n,i*k+k);j++) ans[i]+=s.charAt(i*k+j);
            while(j++<k) ans[i]+=fill;
        }    
        return ans;
    }
}
