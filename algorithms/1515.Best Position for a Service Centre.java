class Solution {
    public double getMinDistSum(int[][] positions) {
        int n=positions.length,i;
        Point a[]=new Point[n],cur=new Point(0,0);
        for(i=0;i<n;i++)
        {
            a[i]=new Point(positions[i][0],positions[i][1]);
            cur.x+=a[i].x;
            cur.y+=a[i].y;
        }
        cur.x/=n;
        cur.y/=n;
        double min=distSum(cur,a,n);
        
        int k=0;
        while(k<n)
        {
            for(i=0;i<n && i!=k;i++)
            {
                double newd=distSum(a[i],a,n);
                if(newd<min)
                {
                    min=newd;
                    cur.x=a[i].x;
                    cur.y=a[i].y;
                }
            }
            k++;
        }
        
        double ep=0.0000001,tes=200;
        Point test[]={new Point(-1,0),new Point(1,0),new Point(0,1),new Point(0,-1)};
        while(tes>ep)
        {
            int flag=0;
            for(i=0;i<4;i++)
            {
                Point newp=new Point(0,0); 
                newp.x=cur.x+tes*test[i].x; 
                newp.y=cur.y+tes*test[i].y; 
  
                double newd=distSum(newp,a,n); 
                if(newd<min) 
                { 
                    min=newd;
                    cur.x=newp.x;
                    cur.y=newp.y;
                    flag=1; 
                    break;
                }
            }
            if(flag==0) tes/=2;
        }
        return min;        
    }
    
    double distSum(Point p,Point a[],int n) 
    { 
        double sum=0; 
        for(int i=0;i<n;i++) 
        { 
            double x=Math.abs(a[i].x-p.x), y=Math.abs(a[i].y-p.y); 
            sum+=Math.sqrt((x*x)+(y*y));   //no sqrt for better precision 
        } 
  
        return sum; 
    } 

    
    class Point
    {
        double x,y;
        Point(double a,double b)
        {
            x=a; y=b;
        }
    }
}
