class Solution {

    public String encode(List<String> strs) {
            StringBuilder sb=new StringBuilder();
            for(String s:strs){
                int l=s.length();
                sb.append(l);
                sb.append('#');
                sb.append(s);
            }
            return sb.toString();
    }

    public List<String> decode(String str) {
           int right=0,left=0;
           List<String>list=new ArrayList<>();
           while(right<str.length()){
            while(right<str.length() && str.charAt(right)!='#'){
                right++;
            }
             String num=str.substring(left,right);
             int n=Integer.parseInt(num);
            left=right+1;
            right=right+n;
            String cur=str.substring(left,right+1);
            list.add(cur);
            left=right+1;
            right++;
           }
           return list;
    }
}
