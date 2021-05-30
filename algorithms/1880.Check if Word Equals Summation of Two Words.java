class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return weight(firstWord)+weight(secondWord)==weight(targetWord);
    }
    
    int weight(String s)
    {
        int i,r=0;
        for(i=0;i<s.length();i++)
        r=(10*r)+(s.charAt(i)-'a');
        return r;
    }
}
