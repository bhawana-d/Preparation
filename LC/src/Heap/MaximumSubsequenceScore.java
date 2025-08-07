//https://leetcode.com/problems/maximum-subsequence-score/description/
//TLE
//Brute Force -> using recursion
class Solution {
    int K;
    int n;
    PriorityQueue<Integer>pq = new PriorityQueue<>();
    
    int solve(int[] nums1, int[] nums2, int sum, int min, int i, int count){
        if(count == K){
            return sum*min;
        }
        if(i >= n){
            return 0;
        }

        pq.add(nums2[i]);
        int takenI = solve(nums1, nums2, sum+nums1[i], pq.peek(),i+1,count + 1);
        pq.remove(nums2[i]);
        int notTakenI = solve(nums1, nums2, sum, min,i+1,count);

        return Math.max(takenI ,notTakenI);
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        K = k;
        n = nums1.length;
        return solve(nums1,nums2,0,0,0,0);
    }
}
//TC = O(nlogn) 
//--Priority quue + sorting (OPTIMAL)
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        List<int []> ls = new ArrayList<>(n);

        for(int i = 0;i <n;i++){
            ls.add(new int[] {nums1[i],nums2[i]});
        }

        ls.sort((a,b) -> Integer.compare(b[1],a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long KSum = 0;
        for(int i =0;i < k;i++){
            KSum += ls.get(i)[0];
            pq.offer(ls.get(i)[0]);
        }

        long res = ls.get(k-1)[1] * KSum;

        for(int i = k;i < n;i++){
            KSum += ls.get(i)[0] - pq.poll();
            pq.offer(ls.get(i)[0]);

            res = Math.max(res, KSum*ls.get(i)[1]);
        }
        return res;
    }
}
