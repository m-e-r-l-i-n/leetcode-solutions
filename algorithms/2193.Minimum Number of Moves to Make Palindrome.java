//Tamonash Chakraborty
//O(n^2)
class Solution {
    public int minMovesToMakePalindrome(String st) {
        char s[]=st.toCharArray();
        int i,n=s.length,c[]=new int[26];
        for(i=0;i<n;i++) c[s[i]-'a']++;

        int o=0;
        for(i=0;i<26;i++) o+=c[i]%2;
        if(o>1) return -1;  //will never be executed for this problem

        int ans=0; o=-1;
        for(i=0;i<26;i++)
        if(c[i]%2==1) o='a'+i;

        for(i=0;i<n/2;i++)
        if(s[i]!=s[n-1-i])
        {
            int l=n+1,r=n+1,j;
            //we can only find pairs if it is not the mid odd value
            if(s[i]!=o)  //swaps for s[i]=s[n-1-i]=cur s[i] 
            {
                for(j=n-1-i;j>i;j--)    //there has to be a same character in this range
                if(s[i]==s[j]) break;
                l=n-1-i-j;
            }

            if(s[n-1-i]!=o) //swaps for s[i]==s[n-1-i]=cur s[n-1-i] 
            {
                for(j=i;j<n-1-i;j++)
                if(s[j]==s[n-1-i]) break;
                r=j-i;
            }

            ans+=Math.min(l,r);
            if(l>r)
            {
                for(j=i+r;j>i;j--)
                {
                    char t=s[j];
                    s[j]=s[j-1];
                    s[j-1]=t;
                }
            }
            else
            {
                for(j=n-1-i-l;j<n-i-1;j++)
                {
                    char t=s[j];
                    s[j]=s[j+1];
                    s[j+1]=t;
                }
            }
        }
        return ans;
    }
}
