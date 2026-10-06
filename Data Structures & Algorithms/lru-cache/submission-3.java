class LRUCache {
     class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int val,int key){
            this.next=null;
            this.prev=null;
            this.key=key;
            this.val=val;
        }
     }
     HashMap<Integer,Node>map;
     Node head;
     Node tail;
     int size;
     int cur;
    public LRUCache(int capacity) {
        size=capacity;
        cur=0;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    public void insert(Node node){
        Node next=head.next;
        node.next=next;
        next.prev=node;
        head.next=node;
        node.prev=head;
    }
    public Node delete(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=null;
        node.prev=null;
        return node;
    }
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node current=map.get(key);
        delete(current);
        insert(current);
        return current.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
                Node ab=map.get(key);
                ab.val=value;
                delete(ab);
                insert(ab);
                return;
            }
        if(cur<size){
            Node node=new Node(value,key);
            map.put(key,node);
            cur++;
            insert(node);
        }else{
            
            Node node=tail.prev;
            delete(node);
            map.remove(node.key);
            Node ab=new Node(value,key);
            insert(ab);
            map.put(key,ab);
        }
    }
}
