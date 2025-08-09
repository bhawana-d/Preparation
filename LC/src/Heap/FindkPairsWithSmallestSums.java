//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
//O(mnlogk)
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for(int i =0;i < n;i++){
            for(int j =0;j < m;j++){
                int sum = nums1[i] + nums2[j];
                if(pq.size() < k){
                    pq.offer(new int[]{sum,i,j});
                }else if(pq.peek()[0] > sum){
                    pq.poll();
                    pq.offer(new int[]{sum,i,j});
                }else{
                    break;
                }
                
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            res.add(0,List.of(nums1[i],nums2[j]));
        }

        return res;
    }
}
