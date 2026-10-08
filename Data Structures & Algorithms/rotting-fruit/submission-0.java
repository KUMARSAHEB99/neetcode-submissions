class Solution {
    public int orangesRotting(int[][] grid) {
        int time=0,count=0;
        Queue<int[]>queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)queue.offer(new int[]{i,j});
                else if(grid[i][j]==1)count++;
            }
        }
int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int size=queue.size();
          
            boolean flag=false;
            for(int i=0;i<size;i++){
                int[] cur=queue.poll();
                int a=cur[0];
                int b=cur[1];
                for(int[] nb:dir){
                    int nx=a+nb[0];
                    int ny=b+nb[1];
                    if(nx>=0 && ny>=0 && nx<grid.length && ny<grid[0].length && grid[nx][ny]==1){
                          flag=true;
                          grid[nx][ny]=2;
                          queue.offer(new int[]{nx,ny});
                          count--;
                    }
                }
            }
              
            if(!flag)break;
            time++;
        }
        return count==0?time:-1;
    }
}
