class Solution {
    public String foreignDictionary(String[] words) {
      HashMap<Character,Set<Character>>graph=new HashMap<>();
      HashMap<Character,Integer>indegree=new HashMap<>();
      for(String word:words){
        for(int i=0;i<word.length();i++){
           char x=word.charAt(i);
           graph.putIfAbsent(x, new HashSet<>());
           indegree.putIfAbsent(x,0);
        }
      }
      for(int x=1;x<words.length;x++){
        String cur=words[x];
        String prev=words[x-1];
        int i=0;
        while(i<prev.length() && i<cur.length()){
            if(cur.charAt(i)!=prev.charAt(i)){
                char ch1=prev.charAt(i);
                char ch2=cur.charAt(i);
               if (graph.get(ch1).add(ch2)) {
    indegree.put(ch2, indegree.get(ch2) + 1);
}

                int ind=(int)ch2-97;
                
                break;
            }
            i++;
        }
        if(i==cur.length() && i<prev.length())return "";
      }
      Queue<Character>q=new LinkedList<>();
        for(char key:indegree.keySet()){
            if(indegree.get(key)==0){
                q.offer(key);
            }
        }
      StringBuilder sb=new StringBuilder();
      while(!q.isEmpty()){
        char a=q.poll();
        
        sb.append(a);
        for(char ch1:graph.get(a)){
            int xy=indegree.get(ch1)-1;
            indegree.put(ch1,xy);
            if(xy==0)q.offer(ch1);
        }
      }
      if(sb.length() != graph.size()){
    return "";
}
      return sb.toString();
    }
}
