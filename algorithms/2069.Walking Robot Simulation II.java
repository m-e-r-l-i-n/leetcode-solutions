//Tamonash Chakraborty
//O((row+col)*move)
//O(1) query
class Robot {
	int n,m,x,y,d;
    public Robot(int width, int height) {
        n=width;	//for x axis
        m=height;	//for y axis
        this.x=0;
        this.y=0;
        this.d = 3; // "East"
    }
    
    public void move(int num) 
    {
        while(x>0 && x<n-1 && y>0 && y<m-1 && num>0)
        {
            if(d==0) y++;
            else if(d==2) y--;
            else if(d==3) x++;
            else x--;
            num--;
        }
        if(num==0) return;
        //we have brought the robot to the border if possible

        int nx,ny;
        //take it to a corner
        while(num>0 && !((x==0 && y==0) || (x==n-1 && y==m-1) || (x==0 && y==m-1) || (x==n-1 && y==0)))
        {
            nx=x; ny=y;
            if(d==0) ny++;
            else if(d==2) ny--;
            else if(d==3) nx++;
            else nx--;
            
            //if the next cell exceeds limits, then we have to change direction
            if(nx<0 || nx>=n || ny<0 || ny>=m)
            {
                d=(d+1)%4;
                continue;
            }

            num--;
            x=nx; y=ny;
        }
        if(num==0) return;

        int border=2*(n+m-2);	//number of border cells
        num%=border;	//it will move in circular path around the border, no need to trace it
        if(num==0) num=border;
        while(num>0)
        {
            nx=x; ny=y;
            if(d==0) ny++;
            else if(d==2) ny--;
            else if(d==3) nx++;
            else nx--;

            //if the next cell exceeds limits, then we have to change direction
            if(nx<0 || nx>=n || ny<0 || ny>=m)
            {
                d=(d+1)%4;
                continue;
            }
            num--;
            x=nx; y=ny;
        }
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        if(d==0) return "North";
        else if(d==2) return "South";
        else if(d==3) return "East";
        else return "West";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height, x, y, direction);
 * obj.move(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
