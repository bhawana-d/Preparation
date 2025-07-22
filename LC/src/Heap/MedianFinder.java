//https://leetcode.com/problems/find-median-from-data-stream/description/
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
