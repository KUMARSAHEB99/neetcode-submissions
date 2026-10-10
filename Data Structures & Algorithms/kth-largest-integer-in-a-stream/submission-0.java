class KthLargest {
    PriorityQueue<Integer> pq;
    int cap;
    public KthLargest(int k, int[] nums) {
       pq=new PriorityQueue<>();
       cap=k;
        for(int x:nums){
            pq.offer(x);
            if(pq.size()>k)pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>cap)pq.poll();
        return pq.peek();
    }
}
