//https://leetcode.com/problems/last-stone-weight/
// nlogn
class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int weight : stones){
            pq.offer(weight);
        }

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            pq.offer(x - y);
        }
        
        return pq.poll();

    }
}
