class Solution {
    public boolean placeWordInCrossword(char[][] b, String w) 
    {
        int i,j,n=b.length,m=b[0].length,l=w.length();
        for(i=0;i<n;i++)
        {
            int c=0; boolean place=true;
            for(j=0;j<m;j++)    //left to right
            if(b[i][j]==' ') c++;
            else if(b[i][j]=='#')
            {
                if(c==l && place) return true;
                c=0;
                place=true;
            }
            else 
            {
                c++;
                if(c>l) place=false;
                else if(b[i][j]!=w.charAt(c-1)) place=false;
            }
            if(c==l && place) return true;
            
            c=0; place=true;
            for(j=m-1;j>=0;j--) //right to left
            if(b[i][j]==' ') c++;
            else if(b[i][j]=='#')
            {
                if(c==l && place) return true;
                c=0;
                place=true;
            }
            else
            {
                c++;
                if(c>l) place=false;
                else if(b[i][j]!=w.charAt(c-1)) place=false;
            }
            if(c==l && place) return true;
        }
        
        for(i=0;i<m;i++)
        {
            int c=0; boolean place=true;
            for(j=0;j<n;j++)    //top to bottom
            if(b[j][i]==' ') c++;
            else if(b[j][i]=='#')
            {
                if(c==l && place) return true;
                c=0;
                place=true;
            }
            else 
            {
                c++;
                if(c>l) place=false;
                else if(b[j][i]!=w.charAt(c-1)) place=false;
            }
            if(c==l && place) return true;
            
            c=0; place=true;
            for(j=n-1;j>=0;j--)     //bottom to top
            if(b[j][i]==' ') c++;
            else if(b[j][i]=='#')
            {
                if(c==l && place) return true;
                c=0;
                place=true;
            }
            else 
            {
                c++;
                if(c>l) place=false;
                else if(b[j][i]!=w.charAt(c-1)) place=false;
            }
            if(c==l && place) return true;
            
        }
        return false;
    }
}
