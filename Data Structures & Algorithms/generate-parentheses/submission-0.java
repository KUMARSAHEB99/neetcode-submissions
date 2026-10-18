class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
      int a=n,b=n;
      StringBuilder sb=new StringBuilder();
      fill(a,b,sb,0);
      return ans; 
    }
    public void fill(int a,int b,StringBuilder sb,int count){
        if(a==0 && b==0){
            ans.add(sb.toString());
        }
        
        if(b>0 && count>0){
            sb.append(')');
            fill(a,b-1,sb,count-1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(a>0){
            sb.append('(');
           fill(a-1,b,sb,count+1);
           sb.deleteCharAt(sb.length()-1);
        }
       
    }
}
