class Solution {
    public int leastInterval(char[] tasks, int n) {
        int c[]=new int[26],l=tasks.length,i,max=0,maxc=0;
        for(i=0;i<l;i++)
        {
            c[tasks[i]-'A']++;
            if(max==c[tasks[i]-'A']) maxc++;
            else if(max<c[tasks[i]-'A'])
            {
                max=c[tasks[i]-'A'];
                maxc=1;
            }
        }
        max--;
        maxc--;
        int emp=max*(n-maxc),avail=l-(max+1)*(maxc+1);
        return l+Math.max(0,emp-avail);
    }
}
