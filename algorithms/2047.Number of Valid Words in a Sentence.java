//Tamonash Chakraborty
//O(n)
class Solution {
    public int countValidWords(String sentence) {
        int i,n=sentence.length(),ans=0;
        String cur="";
        for(i=0;i<n;i++)
        if(sentence.charAt(i)==' ')
        {
            //System.out.println(cur+" "+check(cur));
            if(check(cur)) ans++;
            cur="";
        }
        else cur+=sentence.charAt(i);
        
        //System.out.println(cur+" "+check(cur));
        if(check(cur)) ans++;
        return ans;
    }
    
    boolean check(String x)
    {
        if(x.length()==0) return false;
        int i,l=x.length();
        int hyp=0,pun=0;
        boolean okay=true;
            
        for(i=0;i<l;i++)
        {
            char ch=x.charAt(i);
            if(ch>='a' && ch<='z') continue;
            else if(ch=='-')
            {
                hyp++;
                if(hyp>1 || i-1<0 || i+1>=l) {okay=false; break;}
            	char c1=x.charAt(i-1),c2=x.charAt(i+1);
                if(c1<'a' || c1>'z' || c2<'a' || c2>'z') {okay=false; break;}
            }
            else if(ch=='.' || ch==',' || ch=='!')
            {
                pun++;
                if(pun>1 || i!=l-1) {okay=false; break;}
            }
            else {okay=false; break;}
        }
        return okay;    
    }
}
