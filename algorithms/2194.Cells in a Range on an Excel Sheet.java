//Tamonash Chakraborty
//O(cells)
class Solution {
    public List<String> cellsInRange(String s) {
        String cell[]=s.split(":");
        int low[]=getcell(cell[0]),high[]=getcell(cell[1]);
        int i,j;
        List<String> ans=new ArrayList<>();
        for(i=low[0];i<=high[0];i++)    //store column number first
        {
            String col=column(i);   //generate the column value
            for(j=low[1];j<=high[1];j++)    //store row number second
            ans.add(col+j);
        }
        return ans;
    }
    
    int[] getcell(String s)
    {
        int i,n=s.length(),cell[]={0,0};
        for(i=0;i<n;i++)
        {
            int c=s.charAt(i);
            if(c>='A' && c<='Z') cell[0]=cell[0]*26+c-'A'+1;
            else cell[1]=cell[1]*10+c-'0';
        }    
        return cell;
    }
    
    String column(int n)    //the column numbers will be very small in the given constraints
    {   
        n--;
        if(n<26) return ""+(char)('A'+n);
        n-=26;
        String col="";
        col+=(char)('A'+n/26);
        col+=(char)('A'+n%26);
        return col;
    }
}
