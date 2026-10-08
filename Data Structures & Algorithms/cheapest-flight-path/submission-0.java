class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        for(int i=0;i<=k;i++){
            int[] clone=distance.clone();
            for(int[] x:flights){
                int s=x[0];
                int d=x[1];
                int p=x[2];
                if(distance[s]!=Integer.MAX_VALUE){
                     if(distance[s]+p<clone[d]){
                        clone[d]=distance[s]+p;
                     }
                }
            }
            distance=clone;
        }
        return distance[dst]==Integer.MAX_VALUE?-1:distance[dst];
    }
}
