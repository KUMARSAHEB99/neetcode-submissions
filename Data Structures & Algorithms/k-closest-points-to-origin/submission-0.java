class Solution {
    class Pair{
        int x,y;
        double d;
        Pair(int x,int y,double d){
            this.x=x;
            this.y=y;
            this.d=d;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][]ans=new int[k][2];
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)-> Double.compare(b.d, a.d));
        for(int[] a:points){
          int x=a[0];
          int y=a[1];
          double dist=Math.sqrt((x*x)+(y*y));
          Pair p=new Pair(x,y,dist);
          pq.offer(p);
          if(pq.size()>k)pq.poll();
        }
        int i=0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            ans[i++]=new int[]{p.x,p.y};
        }
        return ans;
    }
}
