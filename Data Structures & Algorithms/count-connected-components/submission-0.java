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
    public int countComponents(int n, int[][] edges) {
      int[] parent=new int[n];
      for(int i=0;i<n;i++){
        parent[i]=i;
      }
      int count=n;
      for(int [] ed:edges){
        if(union(ed[0],ed[1],parent))count--;
      }
      return count;
    }
}
