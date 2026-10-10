class Solution {
    public String foreignDictionary(String[] words) {
     HashMap<Character,Integer>indegree=new HashMap<>();
     HashMap<Character,HashSet<Character>>graph=new HashMap<>();
     for (String word : words) {
            for (char ch : word.toCharArray()) {
                graph.putIfAbsent(ch, new HashSet<>());
                indegree.putIfAbsent(ch, 0);
            }
        }

     for(int i=1;i<words.length;i++){
      String st1=words[i-1];
      String st2=words[i];
      int j=0;
      while(j<st1.length() && j<st2.length() && st1.charAt(j)==st2.charAt(j)){
        j++;
      }
      if(j==st1.length())continue;
      if(j==st2.length())return "";
      char ch1=st1.charAt(j);
      char ch2=st2.charAt(j);
      if(graph.containsKey(ch1)){
           if(graph.get(ch1).contains(ch2))continue;
           graph.get(ch1).add(ch2);     
           indegree.put(ch2,indegree.getOrDefault(ch2,0)+1);
           
      }
     }
     Queue<Character>q=new LinkedList<>();
     for(char ch:indegree.keySet()){
         if(indegree.get(ch)==0)q.offer(ch);
     }
     StringBuilder sb=new StringBuilder();
     while(!q.isEmpty()){
      char ch=q.poll();
      sb.append(ch);
      for(char nb:graph.get(ch)){
        int in=indegree.get(nb);
        in--;
        indegree.put(nb,in);
        if(in==0)q.offer(nb);
      }
     }
     return sb.length()==graph.size()?sb.toString():"";
    }
}
