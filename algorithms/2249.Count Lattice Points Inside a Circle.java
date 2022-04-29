//Tamonash Chakraborty
//O(n^3)
class Solution {
    public int countLatticePoints(int[][] circles) {
        int i,j,ans=0,px[]={500,-1},py[]={500,-1};
        for(int x[]:circles)    //find the range for checking lattice points
        {
            px[0]=Math.min(px[0],x[0]-x[2]);
            px[1]=Math.max(px[1],x[0]+x[2]);
            
            py[0]=Math.min(py[0],x[1]-x[2]);
            py[1]=Math.max(py[1],x[1]+x[2]);
        }    
        
        for(i=px[0];i<=px[1];i++)
        for(j=py[0];j<=py[1];j++)
        for(int x[]:circles)    //for each lattice point, perform brute force
        if(distance(x,i,j)<=x[2]*x[2])  //inside a circle
        {
            ans++;
            break;
        }
        return ans;
    }
    
    int distance(int a[],int x,int y)
    {
        return (a[0]-x)*(a[0]-x)+(a[1]-y)*(a[1]-y);
    }
}
