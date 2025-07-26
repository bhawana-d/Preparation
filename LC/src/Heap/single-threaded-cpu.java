//https://leetcode.com/problems/single-threaded-cpu
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        // Store tasks with original index: {enqueueTime, processingTime, index}
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0]; // enqueueTime
            sortedTasks[i][1] = tasks[i][1]; // processingTime
            sortedTasks[i][2] = i;           // original index
        }

        // Sort tasks by enqueueTime
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        ); // {processingTime, index}

        long currTime = 0;
        int idx = 0;

        while (idx < n || !pq.isEmpty()) {
            // If no task is available yet, move time to the next task's enqueue time
            if (pq.isEmpty() && currTime < sortedTasks[idx][0]) {
                currTime = sortedTasks[idx][0];
            }

            // Push all available tasks into the heap
            while (idx < n && sortedTasks[idx][0] <= currTime) {
                pq.offer(new int[]{sortedTasks[idx][1], sortedTasks[idx][2]});
                idx++;
            }

            // Process the task with shortest processing time (or lowest index if tie)
            if (!pq.isEmpty()) {
                int[] currTask = pq.poll();
                currTime += currTask[0]; // Add processing time
                result.add(currTask[1]); // Add index to result
            }
        }

        // Convert result list to array
        return result.stream().mapToInt(i -> i).toArray();
    }
}
