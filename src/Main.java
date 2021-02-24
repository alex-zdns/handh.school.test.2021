import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 65, 74, 75, 8, 21, 98, 45, 4, 86, 9, 78, 14, 2, 55, 54, 10, 79, 100, 6, 5, 3, 0, 44, 44, 58, 1, 105, 72, 7};

        HeapSort.sort(array, Comparator.naturalOrder());

        System.out.println(Arrays.toString(array));
    }
}
