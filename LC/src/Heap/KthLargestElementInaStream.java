//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int kth = 0;
    public KthLargest(int k, int[] nums) {
        kth = k;
        for(int i=0;i< nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.remove();
            }
        }

    }
    
    public int add(int val) {
        pq.offer(val);
         if(pq.size() > kth){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
