class Solution {
    public int countTime(String time) {
        int i,h[]=new int[4];
        h[0]=time.charAt(0); h[1]=time.charAt(1);
        h[2]=time.charAt(3); h[3]=time.charAt(4);
        for(i=0;i<4;i++)
        if(h[i]>='0' && h[i]<='9') h[i]-='0';
        
        int ans=0,g[]=new int[4];
        for(i=0;i<24*60;i++)
        {
            int j,hr=i/60,min=i%60;
            g[0]=hr/10; g[1]=hr%10; g[2]=min/10; g[3]=min%10;
            
            for(j=0;j<4;j++)
            if(h[j]!='?' && h[j]!=g[j]) break;
            if(j==4) ans++;
        }
        return ans;
    }
}
