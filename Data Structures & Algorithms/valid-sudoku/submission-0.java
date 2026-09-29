class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            boolean[] row=new boolean[10];
            boolean[] col=new boolean[10];
            for(int j=0;j<9;j++){
               if (board[i][j] != '.'){int r=board[i][j]-'0';
               if(row[r])return false;
               row[r]=true;}
               if (board[j][i] != '.'){
               int c=board[j][i]-'0';
               
               if(col[c])return false;
               
               col[c]=true;}
            }
        }
        for(int i=0;i<8;i++){
            boolean[] vis=new boolean[10];
            int row=(i/3)*3;
            int col=(i%3)*3;
            for(int j=row;j<row+3;j++){
                for(int k=col;k<col+3;k++){
                    if(board[j][k]=='.')continue;
                    int a=board[j][k]-'0';
                    if(vis[a])return false;
                    vis[a]=true;
                }
            }
        } 
        return true;  
    }
}
