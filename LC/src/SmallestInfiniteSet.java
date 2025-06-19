//https://leetcode.com/problems/smallest-number-in-infinite-set/
//Approach 1

class SmallestInfiniteSet {
    boolean[] arr;
    int i;
    public SmallestInfiniteSet() {
        arr = new boolean[1001];
        Arrays.fill(arr,true);
        i = 1;
    }
    
    public int popSmallest() {
        int result = i;
        arr[i] = false;

        for(int j = i + 1; j < 1001;j++){
            if(arr[j] == true){
                i = j;
                break;
            }

           
        }

        return result;
    }
    
    public void addBack(int num) {
        arr[num] = true;
        if(num < i){
            i = num;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
