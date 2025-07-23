//https://leetcode.com/problems/find-median-from-data-stream/description/
//SC= O(50001) ~= O(1)
//TC = O(n^2)
class MedianFinder {
    private int[] vec;
    private int i;
    public MedianFinder() {
        vec = new int [5 * 10000 + 1];
        i =0;
    }
    
    public void addNum(int num) {
        if(i == 0){
            vec[i++] = num;
            return;
        }
        int j = i - 1;
        while(j >= 0 && vec[j] > num){
            vec[j + 1] = vec[j];
            j--;
        }
        vec[j+1] = num;
        i++;
    }
    
    public double findMedian() {
        int n = i;
        if(n % 2 == 0){
            int l = n/2 -1;
            int r = n/2;
            return (double)(vec[l] + vec[r])/2;
        }
        return (double)(vec[n/2]);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//SC= O(N)
//TC = O(log N) for add num O(1) for findmedian

class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder()); //MaxHeap
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || leftMaxHeap.peek() > num){
            leftMaxHeap.add(num);
        }else{
            rightMinHeap.add(num);
        }

        //always maintain size + 1 in right min heap
        if(Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1){
            rightMinHeap.add(leftMaxHeap.poll());
        }else if(rightMinHeap.size() > leftMaxHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if(leftMaxHeap.size() == rightMinHeap.size()){
            return (double)(leftMaxHeap.peek() + rightMinHeap.peek())/2;
        }else{
            return leftMaxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
