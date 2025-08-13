//https://leetcode.com/problems/task-scheduler/description/
//TC = O(n -> size of char array)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        //O(N -> size of task) , O(log(size of heap))
        for(char ch: tasks){
            freq[ch - 'A']++;
        }

        int time = 0;

        PriorityQueue<Integer>pq = new PriorityQueue<>(Comparator.reverseOrder());//Max Heap
        for(int i =0;i < 26;i++){
            if(freq[i] > 0){
                pq.offer(freq[i]);
            }
        }
        while(!pq.isEmpty()){
            List<Integer>tmp = new ArrayList<>();
            for(int i =1;i <= n+1;i++){
                if(!pq.isEmpty()){
                int f = pq.poll();
                f--;
                tmp.add(f);
                }
               
            }
            for(int fr : tmp){
                if(fr > 0){
                    pq.offer(fr);
                }
            }
            if(pq.isEmpty()){
                time += tmp.size();
            }else{
                time += (n + 1);
            }
        }
        return time;
    }
}
//with a lit bit if change in implementation:
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        //O(N -> size of task) , O(log(size of heap))
        for(char ch: tasks){
            freq[ch - 'A']++;
        }

        int time = 0;

        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());//Max Heap
        for(int i =0;i < 26;i++){
            if(freq[i] > 0){
                pq.offer(freq[i]);
            }
        }
        while(!pq.isEmpty()){
            int cycle = n +1;
            List<Integer>tmp = new ArrayList<>();
            int taskCount = 0;

            while(cycle-- > 0 && !pq.isEmpty()){
                int currFreq = pq.poll();
                if(currFreq > 1){
                    tmp.add(currFreq -1);
                }
                taskCount++;
            }
            tmp.forEach(pq :: offer);
            time += (pq.isEmpty())?taskCount:n+1;
           
        }
        return time;
    }
}
