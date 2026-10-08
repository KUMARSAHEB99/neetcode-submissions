class Solution {
    public void islandsAndTreasure(int[][] grid) {
      Queue<int[]>queue=new LinkedList<>();
      int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==0)queue.offer(new int[]{i,j});
        }
      } 
      int count=0;
      while(!queue.isEmpty()){
        int size=queue.size();
        count++;
        for(int i=0;i<size;i++){
        int[] cur=queue.poll();
        int a=cur[0];
        int b=cur[1];
        for(int[] nb:dir){
            int nx=a+nb[0];
            int ny=b+nb[1];
            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==Integer.MAX_VALUE){
                grid[nx][ny]=count;
                queue.offer(new int[]{nx,ny});
            }
        }
      } 
      }
    }
}
