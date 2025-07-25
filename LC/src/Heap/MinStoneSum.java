//https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

//Time Complexity : O(n + k*log(n))
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int res =0;
        for(int val : piles){
            maxHeap.offer(val);
        }

        while(k-- > 0){
            int stones = maxHeap.poll();
            stones -= (int)(Math.ceil(stones/2));
            maxHeap.offer(stones);
        }

        for(int t : maxHeap){
            res += t;
        }

        return res;
    }
}
