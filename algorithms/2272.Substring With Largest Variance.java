//Tamonash Chakraborty
//O(26^2*n)
class Solution {
    public int largestVariance(String s) {
        int n=s.length(),temp[]=new int[n],cnt[]=new int[n];
        int i,j,ans=0;
        
        for(i=0;i<26;i++)
        for(j=0;j<26;j++)
        if(i!=j)    
        {
            int k,l=0;
            for(k=0;k<n;k++)    //convert string to array of +1 -1 
            {
                cnt[k]=0;
                if(s.charAt(k)-'a'==i) cnt[k]++;
                if(s.charAt(k)-'a'==j) cnt[k]--;
            }
            
            for(k=0;k<n;k++)    //merge all >0s
            if(cnt[k]>0)
            {
                int m=k; temp[l]=0;
                while(m<n && cnt[m]>=0) temp[l]+=cnt[m++];
                k=m-1; l++;
            }
            else if(cnt[k]<0) temp[l++]=-1;
                      
            ans=Math.max(ans,maximum(temp,l));
        }    
        return ans;
    }
    
    int maximum(int temp[],int n)   //find maximum subarray sum, where +ve has to exist with a -ve
    {
        if(n==1) return 0;
        int cur=-(int)1e9,max=cur,i;
        for(i=1;i<n;i++)
        {
            //+ve cannot exist independently
            int cur2=Math.max(cur+temp[i],temp[i]+temp[i-1]);
            //-ve can exist independently
            if(temp[i]<0) cur2=Math.max(cur2,Math.max(cur+temp[i],temp[i]));
            cur=cur2;   //note that cur is needed twice, so use cur2
            max=Math.max(max,cur);
        }    
        return max;
    }
}
