//https://leetcode.com/problems/total-cost-to-hire-k-workers/
class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int hired = 0;
        int i =0;
        int j = n-1;

        long ans = 0;

        PriorityQueue<Integer>pq1 = new PriorityQueue<>();
        PriorityQueue<Integer>pq2 = new PriorityQueue<>();

        while(hired < k){
            while(pq1.size() < candidates && i <= j){
                pq1.offer(costs[i++]);
            }

            while(pq2.size() < candidates && j >= i){
                pq2.offer(costs[j--]);
            }
            int a = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
            int b = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();

            if(a <= b){
                ans += a;
                pq1.poll();
            }
            else{
                ans += b;
                pq2.poll();
            }
            hired++;
        }
        return ans;
    }
}
