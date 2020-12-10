package strategy;

public class Sorter<T> {

    private Comparator<T> comparator;

    public Sorter(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void setComparator(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] arr){
        for (int i = 0; i < arr.length -1; i++) {
            int minidx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(comparator.compareTo(arr[minidx],arr[j]) == 1){
                    minidx = j;
                }
            }
            swap(arr,i, minidx);
        }
    }

    private void swap(T[] arr, int i , int j){
        if(i == j) return;
        T val = arr[i];
        arr[i] = arr[j];
        arr[j] = val;

    }

}
