class Solution {
    public String oddString(String[] words) {
        if(!equal(words[0],words[1]))   //ans lies in first 2
        {
            if(equal(words[2],words[0])) return words[1];
            else return words[0];
        }
        
        int i,n=words.length;
        for(i=2;i<n;i++)    //just check with previous
        if(!equal(words[i-1],words[i])) return words[i];
        return words[n-1];  //never executed
    }
    
    boolean equal(String a,String b)    //check if 2 are equal
    {
        int i,n=a.length();
        for(i=1;i<n;i++)
        if(a.charAt(i)-a.charAt(i-1)!=b.charAt(i)-b.charAt(i-1)) return false;
        return true;
    }
}
