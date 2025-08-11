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
//--------------------------------- slightly optimised solution
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        Set<String> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        List<List<Integer>> res = new ArrayList<>();

        pq.offer(new int[]{nums1[0] + nums2[0],0,0});
        visited.add("0,0");
        while(k-- > 0 && !pq.isEmpty()){
            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            res.add(List.of(nums1[i],nums2[j]));

            if(j+1 < n ){
                String nextPairKey = i + "," + (j+1);
                if(!visited.contains(nextPairKey)){
                    pq.offer(new int[]{nums1[i] + nums2[j+1],i,j+1});
                    visited.add(nextPairKey);
                }
            }

            if(i+1 < m ){
                String nextPairKey = (i + 1) + "," + j;
                if(!visited.contains(nextPairKey)){
                    pq.offer(new int[]{nums1[i+1] + nums2[j],i+1,j});
                    visited.add(nextPairKey);
                }
            }
        }

    return res;
    }
}
