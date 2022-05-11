//Tamonash Chakraborty
//O(26*n)
class Solution {
    public int countTexts(String pressedKeys) {
        int n=pressedKeys.length(),i,j;
        long dp[]=new long[n+1],M=(int)1e9+7;
        int pos[]=new int[26],digit[]=new int[26];
        
        //mark the digit and index the letter maps to
        digit[0]=digit[1]=digit[2]='2';
        digit[3]=digit[4]=digit[5]='3';
        digit[6]=digit[7]=digit[8]='4';
        digit[9]=digit[10]=digit[11]='5';
        digit[12]=digit[13]=digit[14]='6';
        digit[15]=digit[16]=digit[17]=digit[18]='7';
        digit[19]=digit[20]=digit[21]='8';
        digit[22]=digit[23]=digit[24]=digit[25]='9';
        
        int cnt[]=new int[10];  //store count
        for(i=0;i<26;i++)
        {
            pos[i]=cnt[digit[i]-'0'];
            cnt[digit[i]-'0']++;
        }
        
        dp[0]=1;
        for(i=1;i<=n;i++)
        for(j=0;j<26;j++)
        {
            boolean ok=true;
            for(int k=i-pos[j];k<=i && ok;k++)    //check if character j can be placed here
            if(k<=0) ok=false;
            else ok&=digit[j]==pressedKeys.charAt(k-1);
            
            if(ok) dp[i]=(dp[i]+dp[i-pos[j]-1])%M;
        }
        return (int)dp[n];
    }
}
