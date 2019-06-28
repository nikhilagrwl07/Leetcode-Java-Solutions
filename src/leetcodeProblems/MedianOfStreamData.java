package leetcodeProblems;/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


public class MedianOfStreamData {
    public static void main(String[] args) {

//        int[] stream = {41, 35, 62, 5, 97, 108};
        int[] stream = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        MedianDS medianDS = new MedianDS();

        for (int i = 0; i < stream.length; i++) {
            medianDS.insert(stream[i]);
            System.out.println(medianDS.getMedian());
        }

    }
}


class MedianDS {
    MaxHeap maxHeap;
    MinHeap minHeap;
    int median;

    public MedianDS() {
        this.maxHeap = new MaxHeap();
        this.minHeap = new MinHeap();
        median = -1;
    }

    public int getMedian() {
        return median;
    }

    void insert(int element) {

        // first element insertion
        if (median == -1) {
            maxHeap.insert(element);
            median = element;
            return;
        }

        if (maxHeap.size() > minHeap.size()) {

            if (element > median) {
                minHeap.insert(element);
            } else {

                int maxElement = maxHeap.getMaxElement();
                minHeap.insert(maxElement);
                maxHeap.deleteAndInsertAtRoot(element);
            }
            median = (minHeap.getMinElement() + maxHeap.getMaxElement()) / 2;
        } else if (maxHeap.size() < minHeap.size()) {

            if (element > median) {
                int minElement = minHeap.getMinElement();
                maxHeap.insert(minElement);
                minHeap.deleteAndInsertAtRoot(element);
            } else {
                maxHeap.insert(element);
            }
            median = (minHeap.getMinElement() + maxHeap.getMaxElement()) / 2;
        } else {
            if (element > median) {
                minHeap.insert(element);
                median = minHeap.getMinElement();
            } else {

                maxHeap.insert(element);
                median = maxHeap.getMaxElement();
            }
        }
    }
}

class MaxHeap {
    private int[] maxheap;
    private int topIndex;

    public MaxHeap() {
        this.maxheap = new int[256];
        topIndex = 0;
    }

    int getMaxElement() {
        return maxheap[0];
    }


    void deleteAtRoot(){
        maxheap[0] = maxheap[topIndex];
        topIndex--;
        sinkDown(0);
    }

    void deleteAndInsertAtRoot(int newElement) {
        maxheap[0] = newElement;
        sinkDown(0);

    }

    void sinkDown(int minIndex) {

        while (minIndex <= topIndex) {

            int orginalIndex = minIndex;

            if (getLeft(minIndex) <= topIndex && maxheap[getLeft(minIndex)] > maxheap[minIndex]) {
                minIndex = getLeft(minIndex);
            }
            if (getRight(minIndex) <= topIndex && maxheap[getRight(minIndex)] > maxheap[minIndex]) {
                minIndex = getRight(minIndex);
            }

            if (minIndex != orginalIndex) {
                swap(maxheap, minIndex, orginalIndex);
            } else {
                break;
            }
        }
    }

    void insert(int element) {
        int size = size();

        if (size==0) {
            maxheap[topIndex] = element;
        } else {
            topIndex++;
            maxheap[topIndex] = element;
            swimUp(topIndex);
        }
    }

    void swimUp(int index) {

        while (maxheap[getParent(index)] < maxheap[index]) {
            swap(maxheap, getParent(index), index);
            index = getParent(index);
        }
    }

    private void swap(int[] minheap, int parent, int child) {
        int t = minheap[parent];
        minheap[parent] = minheap[child];
        minheap[child] = t;
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    int size() {
        if (topIndex == 0 && maxheap[topIndex] != 0) {
            return 1;
        } else if (topIndex == 0 && maxheap[topIndex] == 0) {
            return 0;
        } else {
            return topIndex + 1;
        }
    }

}

class MinHeap {
    private int[] minheap;
    private int topIndex;

    public MinHeap() {
        this.minheap = new int[256];
        topIndex = 0;
    }

    int getMinElement() {
        return minheap[0];
    }

    void deleteAndInsertAtRoot(int newElement) {
        minheap[0] = newElement;
        sinkDown(0);

    }

    void deleteAtRoot(){
        minheap[0] = minheap[topIndex];
        topIndex--;
        sinkDown(0);
    }

    private void sinkDown(int minIndex) {

        while (minIndex <= topIndex) {

            int orginalIndex = minIndex;

            if (getLeft(minIndex) <= topIndex && minheap[getLeft(minIndex)] < minheap[minIndex]) {
                minIndex = getLeft(minIndex);
            }
            if (getRight(minIndex) <= topIndex && minheap[getRight(minIndex)] < minheap[minIndex]) {
                minIndex = getRight(minIndex);
            }

            if (minIndex != orginalIndex) {
                swap(minheap, minIndex, orginalIndex);
            } else {
                break;
            }
        }
    }

    void insert(int element) {
        int size = size();

        if (size == 0) {
            minheap[topIndex] = element;
        } else {
            topIndex++;
            minheap[topIndex] = element;
            swimUp(topIndex);
        }

    }

    private void swimUp(int index) {

        while (minheap[getParent(index)] > minheap[index]) {
            swap(minheap, getParent(index), index);
            index = getParent(index);
        }
    }

    private void swap(int[] minheap, int parent, int child) {
        int t = minheap[parent];
        minheap[parent] = minheap[child];
        minheap[child] = t;
    }

    private int getLeft(int i) {
        return 2 * i + 1;
    }

    private int getRight(int i) {
        return 2 * i + 2;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    int size() {
        if (topIndex == 0 && minheap[topIndex] != 0) {
            return 1;
        } else if (topIndex == 0 && minheap[topIndex] == 0) {
            return 0;
        } else {
            return topIndex + 1;
        }

    }

}
