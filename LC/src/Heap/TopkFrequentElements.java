//https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }

        List<Integer> ls = new ArrayList<>();

        for(int i =0;i < k;i++){
            int[] pair = pq.poll();
            ls.add(pair[0]);
        }

        return ls.stream().mapToInt(i->i).toArray();
    }
}
