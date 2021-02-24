import java.util.Comparator;
import java.util.function.Predicate;

public class HeapSort {
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sift(int[] array, int heapSize, int root, Comparator<Integer> comparator) {
        int largestValueIndex = root;

        while (true) {
            int leftChildIndex = 2 * root + 1;
            int rightChildIndex = 2 * root + 2;

            if (leftChildIndex < heapSize && comparator.compare(array[leftChildIndex], array[root]) > 0) {
                largestValueIndex = leftChildIndex;
            }

            if (rightChildIndex < heapSize && comparator.compare(array[rightChildIndex], array[largestValueIndex]) > 0) {
                largestValueIndex = rightChildIndex;
            }

            if (largestValueIndex == root) {
                return;
            }

            swap(array, largestValueIndex, root);
            root = largestValueIndex;
        }
    }

    public static void sort(int[] array, Comparator<Integer> comparator) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            sift(array, array.length, i, comparator);
        }

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);

            sift(array, i, 0, comparator);
        }
    }
}
