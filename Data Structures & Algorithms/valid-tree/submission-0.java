class Solution {
    public int find(int a,int[] parent){
        if(parent[a]!=a){
            parent[a]=find(parent[a],parent);
        }
        return parent[a];
    }
    public boolean union(int a,int b,int[] parent){
        int pa=find(a,parent);
        int pb=find(b,parent);
        if(pa==pb)return false;
        parent[pa]=pb;
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
       int count=n;
       int[] parent=new int[n];
       for(int i=0;i<n;i++){
        parent[i]=i;
       }
       for(int[] x:edges){
             if(union(x[0],x[1],parent))count--;
             else return false;
       }
       return count==1?true:false;
    }
}
