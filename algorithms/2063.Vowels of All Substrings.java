//Tamonash Chakraborty
//O(n)
class Solution {
    public long countVowels(String word) {
        int i,n=word.length();
        long ans=0;
        for(i=0;i<n;i++)
        {
            int ch=word.charAt(i);
            if(!(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')) continue;
            ans+=1l*(i+1)*(n-i);	//(number of substrings beginning <=cur)*(ending>=cur)
            //count for each vowel
        }    
        return ans;
    }
}
