//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int element : nums){
            pq.offer(element);
        }

        for(int i = 1;i< k;i++){
            pq.poll();
        }

        return pq.poll();
    }
}
