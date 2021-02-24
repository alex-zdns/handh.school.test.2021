import java.util.*;

public class Main {
    private static final int MIN_VALUE = -999;
    private static final int MAX_VALUE = 999;
    private static final int MIN_SIZE_VALUE = 5;
    private static final int MAX_SIZE_VALUE = 300;

    private static final Random random = new Random(new Date().getTime());

    public static int[][] generateRandomArraysAndSortByParity(int arrayCount) {
        int[][] arrays = generateRandomArrays(arrayCount);
        sortArrays(arrays);
        return arrays;
    }

    private static int[][] generateRandomArrays(int arrayCount) {
        if (arrayCount > MAX_SIZE_VALUE - MIN_SIZE_VALUE) {
            throw new IllegalArgumentException("Range of sizes is too little");
        }

        Set<Integer> sizes = new HashSet<>();

        int[][] arrays = new int[arrayCount][];

        for (int i = 0; i < arrays.length; i++) {
            int size;

            do {
                size = generateRandomIntFromRange(MIN_SIZE_VALUE, MAX_SIZE_VALUE);
            } while (sizes.contains(size));

            sizes.add(size);

            arrays[i] = generateRandomArray(size);
        }

        return arrays;
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = generateRandomIntFromRange(MIN_VALUE, MAX_VALUE);
        }

        return array;
    }

    private static int generateRandomIntFromRange(int minValue, int maxValue) {
        return random.nextInt(maxValue - minValue + 1) + minValue;
    }

    private static void sortArrays(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            if (i % 2 == 0) {
                HeapSort.sort(arrays[i], Comparator.naturalOrder());
            } else {
                HeapSort.sort(arrays[i], Comparator.reverseOrder());
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] arrays = generateRandomArraysAndSortByParity(size);

        for (var array: arrays) {
            System.out.printf("size: %d\n", array.length);
            System.out.println(Arrays.toString(array));
            System.out.println();
        }
    }
}
