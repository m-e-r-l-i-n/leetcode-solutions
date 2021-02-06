class Solution {
    public int minimumLength(String s) {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            char a=s.charAt(i),b=s.charAt(j);
            if(a!=b) break;
            while(i<j && s.charAt(i)==a) i++;
            while(j>i && s.charAt(j)==a) j--;
        }
        if(j<=i) 
        {
            int x=i,l=0;
            while(x>=0 && s.charAt(x)==s.charAt(i)) {x--; l++;}
            x=i+1;
            while(x<s.length() && s.charAt(x)==s.charAt(i)) {x++; l++;}
            if(l>1) return 0;
            else return 1;
        }
        return j-i+1;
    }
}
