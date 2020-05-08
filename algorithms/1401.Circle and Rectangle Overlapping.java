class Solution {
    public boolean checkOverlap(int r, int cirx, int ciry, int x1, int y1, int x2, int y2) {
        int i;
        if(((cirx>=x1 && cirx<=x2) || (cirx>=x2 && cirx<=x1)) && ((ciry>=y1 && ciry<=y2) || (ciry>=y1 && ciry<=y2))) return true;
        if(x1>x2) x1=x1^x2^(x2=x1);
        if(y1>y2) y1=y1^y2^(y2=y1);
        for(i=x1;i<=x2;i++)
        {
            double dist=Math.sqrt(Math.pow(i-cirx,2)+Math.pow(y1-ciry,2));
            if(dist<=r) return true;
        }
        
        for(i=x1;i<=x2;i++)
        {
            double dist=Math.sqrt(Math.pow(i-cirx,2)+Math.pow(y2-ciry,2));
            if(dist<=r) return true;
        }
        
        for(i=y1;i<=y2;i++)
        {
            double dist=Math.sqrt(Math.pow(i-ciry,2)+Math.pow(x1-cirx,2));
            if(dist<=r) return true;
        }
        
        for(i=y1;i<=y2;i++)
        {
            double dist=Math.sqrt(Math.pow(i-ciry,2)+Math.pow(x2-cirx,2));
            if(dist<=r) return true;
        }
        return false;
    }
}
