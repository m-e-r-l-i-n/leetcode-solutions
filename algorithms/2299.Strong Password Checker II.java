class Solution {
    public boolean strongPasswordCheckerII(String password) {
        boolean len=password.length()>7;
        boolean low=false,hi=false,dig=false,sp=false,adj=false;
        
        int i,n=password.length();
        String special="!@#$%^&*()-+";
        for(i=0;i<n;i++)
        {
            char c=password.charAt(i);
            if(c>='a' && c<='z') low=true;
            else if(c>='A' & c<='Z') hi=true;
            else if(c>='0' & c<='9') dig=true;
            else sp=true;
            if(i>0 && password.charAt(i-1)==c) adj=true;
        }
        return len & low & hi & dig & sp & !adj;
    }
}
