//https://leetcode.com/problems/smallest-number-in-infinite-set/
//Approach:1

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

/////////////////////////////
///APPROACH - 2 ===================
class SmallestInfiniteSet {
    int currentSmallest;
    HashSet<Integer> set;
    PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        currentSmallest = 1;
        set = new HashSet<>();
        pq = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        int result;
        if(! pq.isEmpty()){
            result = pq.poll();
            set.remove(result);
        }else{
            result = currentSmallest;
            currentSmallest++;
        }

        return result;
    }
    
    public void addBack(int num) {
        if(num >= currentSmallest || set.contains(num)){
            return;
        }
        set.add(num);
        pq.offer(num);
    }
}

