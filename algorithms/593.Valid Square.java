class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d1=dist(p1,p2),d2=dist(p1,p3),d3=dist(p1,p4);
        Set<Integer> set=new HashSet<>();
        set.add(d1); set.add(d2); set.add(d3);
        if(set.size()!=2) return false;
        if(d1>d2 && d1>d3) return check(p2,p3,p4,p1,d2,d1);
        else if(d2>d1 && d2>d3) return check(p3,p2,p4,p1,d1,d2);
        else return check(p4,p2,p3,p1,d1,d3);
    }
    
    int dist(int a[],int b[])
    {
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
    
    boolean check(int a[],int b[],int c[],int p[],int ds,int dd)
    {
        int d1=dist(a,b),d2=dist(a,c),d3=dist(b,c);
        return d1==d2 && d1==ds && d3==dd;
    }
}
