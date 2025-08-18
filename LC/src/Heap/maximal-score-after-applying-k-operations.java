//https://leetcode.com/problems/maximal-score-after-applying-k-operations/description/
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        long score = 0;

        for(long s : nums){
            pq.offer(s);
        }

        while(k-- > 0){
            long sc = pq.poll();
            score += sc;
            pq.offer((sc+2) / 3);
        }
        return score;
    }
}
